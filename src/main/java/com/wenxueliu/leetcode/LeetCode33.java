package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/11/09 09:41
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode33
 * @modifiedBy ：
 *  注：该题可以理解为二分搜索 + LeetCode153
 */
public class LeetCode33 {

    /**
     * 思路：自己解法思路比较混乱，没有梳理清楚。 这里思路看起来清晰，但是细节需要非常注意
     * [实现](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/sou-suo-xuan-zhuan-pai-xu-shu-zu-by-leetcode-solut/)
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + ((end - start) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            //下面都是以 nums[mid] 不等于 target 为前提

            //前半部分有序，这里必须是小于等于
            if (nums[start] < nums[mid]) {
                //target在前半部分，注意target大于等于nums[start]，小于nums[mid]
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else { //target 在后半部分，target >= nums[mid+1]
                    start = mid + 1;
                }
            } else if (nums[start] == nums[mid]) {
                start = mid + 1;
            } else { //后半部分有序
                //target在后半部分，注意target大于mid，小于等于end
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else { //target在前半部分
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 更直观的思路：1. 找到最小值的索引。2. 如果 target 小于最小值，大于最大值，返回 -1，否则，以最小值为中心，左右二分查找
     */
    public int search2(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int len = nums.length;
        int minIndex = findMinIndex(nums);
        boolean isInLeft = target > nums[len-1];
        int left = isInLeft ? 0 : minIndex;
        int right = isInLeft ? minIndex - 1 : len - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int findMinIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] <= nums[right]) {
                return left;
            }
            int mid = left + ((right - left) >> 1);
            if (nums[mid] <= nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 可读性不好
     * @param nums
     * @param target
     * @return
     */
    public int search1(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            // 1 1 0 false
            // 1 1 1 true
            // 1 0 0 true
            // 1 0 1 false
            // 0 1 1 false
            // 0 1 0 true
            // 0 0 1 true
            // 0 0 0 false
            if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid])) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo == hi && nums[lo] == target ? lo : -1;

    }
}

