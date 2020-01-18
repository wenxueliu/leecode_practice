package com.wenxueliu.leetcode;

import java.util.*;

/**
 * @author ： liuwenxue
 * @date ：2020/01/17 23:14
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode480
 * @modifiedBy ：
 */
public class LeetCode480 {

    /**
     * 思路：用两个 TreeMap 将 k 个元素分为两等份。
     * 实现：没有考虑到的情况：1. 整数加、减法溢出。 窗口为 1。
     * @param nums
     * @param k
     * @return
     */
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = cornerCase(nums, k);
        if (result != null) {
            return result;
        }

        TreeSet<Element> leftWindow = new TreeSet<>((o1, o2) -> o1.compareTo(o2));
        TreeSet<Element> rightWindow = new TreeSet<>((o1, o2) -> o1.compareTo(o2));
        for (int index = 0; index < k; index++) {
            rightWindow.add(new Element(nums[index], index));
            leftWindow.add(rightWindow.pollFirst());
            if (leftWindow.size() > rightWindow.size()) {
                rightWindow.add(leftWindow.pollLast());
            }
        }

        int len = nums.length;
        double []medians = new double[len - k + 1];
        medians[0] = getMedian(leftWindow, rightWindow);
        for (int index = k; index < len; index++) {
            // remove
            if (leftWindow.last().value >= nums[index - k]) {
                leftWindow.remove(new Element(nums[index - k], index - k));
            } else {
                rightWindow.remove(new Element(nums[index - k], index - k));
            }

            //add
            rightWindow.add(new Element(nums[index], index));
            leftWindow.add(rightWindow.pollFirst());
            if (leftWindow.size() > rightWindow.size()) {
                rightWindow.add(leftWindow.pollLast());
            }
            medians[index - k + 1] = getMedian(leftWindow, rightWindow);
        }
        return medians;
    }


    private double getMedian(TreeSet<Element> leftWindow, TreeSet<Element> rightWindow) {
        if (leftWindow.size() == rightWindow.size()) {
            return ((double)leftWindow.last().value + rightWindow.first().value) / 2;
        } else {
            return rightWindow.first().value;
        }
    }

    class Element {
        int value;
        int index;

        Element(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            Element other = (Element)obj;
            return other.value == value && other.index == index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, index);
        }

        public int compareTo(Element e) {
            if (value > e.value) {
                return 1;
            } if (value < e.value) {
                return -1;
            } else {
                return index - e.index;
            }
        }
    }



    /**
     * 思路：与上面一致。算法复杂度为 N(N^2)
     * 如何找到要删除的元素在哪呢
     * 如果要删除的元素 < 中位数，那就在maxheap
     * 如果要删除的元素 > 中位数，那就在minheap
     * 如果要删除的元素 = 中位数，那就是在maxheap的堆顶
     * 由于要删除某个特定的元素，用heap的话，时间复杂度为O（n）
     *
     * 存在的坑：
     * 1.声明大顶堆，不要用maxheap = new PriorityQueue<>((x, y) -> y - x)形式， 在相等的时候会有问题。
     * 2.两个Int最大值相加溢出情况
     * 3.删除操作之后，大根堆和小根堆的数量有可能会存在 2-3 或者 4-2这种情况 所以添加操作的判断条件为minheap.size() > maxheap.size()
     * @param nums
     * @param k
     * @return
     */
    public double[] medianSlidingWindow1(int[] nums, int k) {
        double[] result = cornerCase(nums, k);
        if (result != null) {
            return result;
        }

        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        double[] medians = new double[nums.length - k + 1];
        for (int index = 0; index < k; index++) {
            maxheap.add(nums[index]);
            minheap.add(maxheap.poll());
            if(minheap.size() > maxheap.size()){
                maxheap.add(minheap.poll());
            }
        }
        medians[0] = getMedian(maxheap, minheap, k);
        for (int right = k; right < nums.length; right++) {
            // remove
            if (maxheap.peek() >= nums[right - k]) {
                maxheap.remove(nums[right - k]);
            } else {
                minheap.remove(nums[right - k]);
            }

            // add
            maxheap.add(nums[right]);
            minheap.add(maxheap.poll());
            if(minheap.size() > maxheap.size()){
                maxheap.add(minheap.poll());
            }
            medians[right - k + 1] = getMedian(maxheap, minheap, k);
        }
        return medians;
    }

    double getMedian(PriorityQueue<Integer> maxheap, PriorityQueue<Integer> minheap, int k) {
        if ((k & 1) == 1) {
            return maxheap.peek();
        } else {
            return ((double) maxheap.peek() + (double)minheap.peek()) / 2;
        }
    }

    private double[] cornerCase(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) {
            return new double[0];
        }
        if (len == 1) {
            return new double[] {nums[0]};
        }
        if (k == 1) {
            double []result = new double[len];
            for (int index = 0; index < len; index++) {
                result[index] = nums[index];
            }
            return result;
        }
        return null;
    }


    /**
     * 思路：每次移动从窗口利用二分法找到要删除的元素和要添加的元素。删除和添加对应的元素。对于数组来说，删除和添加都是 O(N)，查找 O(logN)
     * 算法复杂度：N(O^2) 21ms 超过 93%
     * 空间复杂度：N(K)
     * @param nums
     * @param k
     * @return
     */
    public double[] medianSlidingWindow2(int[] nums, int k) {
        double[] medians = new double[nums.length+1-k];
        List<Integer> list = new ArrayList<>();
        int index, pos;

        // 对前k个数字使用插入排序，并使用二分查找找到最佳插入点
        for(int i=0; i<k; i++){
            pos = binarySearch(list, nums[i]);
            list.add(pos, nums[i]);
        }
        medians[0] = ((double)list.get((k-1)/2)+(double)list.get(k/2))/2.0;

        for(int right = k; right < nums.length; right++){
            // 使用二分查找找到需要删除数字的下标并删除
            index = binarySearch(list, nums[right-k]);
            list.remove(index);
            // 使用二分查找找到最佳插入点
            pos = binarySearch(list, nums[right]);
            list.add(pos, nums[right]);
            medians[right-k+1] = ((double)list.get((k-1)/2)+(double)list.get(k/2))/2.0;
        }
        return medians;
    }

    private int binarySearch(List<Integer> data, int target){
        int left = 0, right = data.size()-1;
        while(left <= right){
            int mid = left+(right-left)/2;
            if (data.get(mid) > target) {
                right = mid-1;
            } else if (data.get(mid) < target) {
                left = mid+1;
            } else {
                return mid;
            }
        }
        return left;
    }


    /**
     * 思路：与解法三思路一致，但是使用了数组而不是List。
     * 算法复杂度：O(N^2) 用时 14 ms，超过 95%
     * 空间复杂度：O(K)
     * @param nums
     * @param k
     * @return
     */
    public double[] medianSlidingWindow3(int[] nums, int k) {
        int len =nums.length-k+1;
        if (len<=0)  {
            return null;
        }
        double []medians = new double[len];
        int []num = Arrays.copyOfRange(nums,0, k);
        Arrays.sort(num);
        for (int right = 0; right < len; right++){
            medians[right]=((double)num[(k-1)/2] + (double)num[k/2]) / 2;
            if (right <len-1) {
                change(num,nums[right ],nums[right +k]);
            }
        }
        return medians;
    }

    public void change(int[]num, int leave, int get){
        if (get == leave) {
            return;
        }
        int key = Arrays.binarySearch(num,leave);
        int i;
        if  (leave > get) {
            for (i = key;i > 0; i--) {
                if (num[i-1] < get) {
                    break;
                }
                num[i] = num[i-1];
            }
            num[i] = get;
        } else {
            for (i = key; i < num.length-1; i++) {
                if (num[i+1] > get) {
                    break;
                }
                num[i] = num[i+1];
            }
            num[i] = get;
        }
    }
}
