package com.wenxueliu.leetcode;

import java.util.*;

/**
 * @author ： liuwenxue
 * @date ：2020/01/15 23:27
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode239
 * @modifiedBy ：
 */
public class LeetCode239 {

    /**
     * 思路：用一个长度为 k 的数组维护窗口。每次对窗口内元素排序。
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{};
        }
        if (k == 1) {
            return nums;
        }
        int []window = new int [k];
        int []res = new int[len - k + 1];
        for (int index = 0; index < k; index++) {
            window[index] = nums[index];
        }
        res[0] = sortAndMax(window);
        int lastMax = res[0];
        for (int right = k; right < len; right++) {
            window[right % k] = nums[right];
            res[right - k + 1] = sortAndMax(window);
        }
        return res;
    }

    /**
     * 思路：用一个长度为 k 的数组维护窗口。保留最大值，减少排序次数。
     * 时间复杂度： 超过 85%
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{};
        }
        if (k == 1) {
            return nums;
        }
        int []window = new int [k];
        int []res = new int[len - k + 1];
        for (int index = 0; index < k; index++) {
            window[index] = nums[index];
        }
        res[0] = sortAndMax(window);
        for (int right = k; right < len; right++) {
            window[right % k] = nums[right];
            if (nums[right - k] == res[right - k]) {
                if (nums[right] < res[right -k]) {
                    res[right - k + 1] = sortAndMax(window);
                } else {
                    res[right - k + 1] = nums[right];
                }
            } else {
                if (nums[right] > res[right -k]) {
                    res[right - k + 1] = nums[right];
                } else {
                    res[right - k + 1] = res[right - k];
                }

            }

        }
        return res;
    }

    int sortAndMax(int []window) {
        int []clone = new int[window.length];
        for (int index = 0; index < window.length; index++) {
            clone[index] = window[index];
        }
        Arrays.sort(clone);
        return clone[window.length - 1];
    }

    /**
     * 优化了 sortAndMax 函数，每次只需要求解最大值即可，不需要排序
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow3(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{};
        }
        if (k == 1) {
            return nums;
        }
        int []window = new int[k];
        int []res = new int[len - k + 1];
        for (int index = 0; index < k; index++) {
            window[index] = nums[index];
        }
        res[0] = max(window);
        for (int right = k; right < len; right++) {
            window[right % k] = nums[right];
            if (nums[right - k] == res[right - k]) {
                if (nums[right] < res[right -k]) {
                    res[right - k + 1] = max(window);
                } else {
                    res[right - k + 1] = nums[right];
                }
            } else {
                if (nums[right] > res[right -k]) {
                    res[right - k + 1] = nums[right];
                } else {
                    res[right - k + 1] = res[right - k];
                }

            }

        }
        return res;
    }

    int max(int window[]) {
        int max = window[0];
        for (int index = 1; index < window.length; index++) {
            max = Math.max(window[index], max);
        }
        return max;
    }


    /**
     * 思路：刚开始准备中 HashMap，但是发现，每次都要删一个元素，添加一个元素。如果删除的是最大值，那么，就必须对所有元素排序。 而这样就
     * 将复杂度退化为 O(N * KlogK)。于是，想到用 TreeMap，这样复杂度降低为 O(N * logK)
     * 算法复杂度：O(N * logK)
     * 空间复杂度：O(K)
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow4(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{};
        }
        TreeMap<Integer, List<Integer>> num2Indexes = new TreeMap<>();
        for (int index = 0; index < k; index++) {
            List<Integer> indexes = num2Indexes.getOrDefault(nums[index], new ArrayList<>());
            indexes.add(index);
            // 这里 put 是必须的
            num2Indexes.put(nums[index], indexes);
        };

        int []out = new int[len - k + 1];
        out[0] = num2Indexes.lastKey();
        if (len > k) {
            for (int index = k; index < len; index++) {
                List<Integer> indexes =  num2Indexes.get(nums[index - k]);
                indexes.remove(Integer.valueOf(index - k));
                // 这里要将元素为空的 key 删掉否则结果错误的
                if (!indexes.isEmpty()) {
                    num2Indexes.put(nums[index - k], indexes);
                } else {
                    num2Indexes.remove(Integer.valueOf(nums[index - k]));
                }

                List<Integer> tmp = num2Indexes.getOrDefault(nums[index], new ArrayList<>());
                tmp.add(index);
                // 这里 put 是必须的
                num2Indexes.put(nums[index], tmp);
                out[index - k + 1] = num2Indexes.lastKey();
            }
        }
        return out;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k + 1, (o1, o2) -> o2 - o1);
        int[] res = new int[len - k + 1];
        for (int index = 0; index < k; index++) {
            priorityQueue.add(nums[index]);
        }
        res[0] = priorityQueue.peek();
        for (int index = k; index < len; index++) {
            if (nums[index - k] != nums[index]) {
                priorityQueue.remove(nums[index - k]);
                priorityQueue.add(nums[index]);
            }
            res[index - k + 1] = priorityQueue.peek();
        }
        return res;
    }
}
