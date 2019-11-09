package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/11/09 11:11
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode34
 * @modifiedBy ：
 */
public class LeetCode34 {

    /**
     * 思路：
     * 找到目标值之后，分别向左，向右移动
     * 用时: 10分钟
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[] {-1, -1};
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                if (mid == 0) {
                    range[0] = mid;
                }
                if (mid == len - 1) {
                    range[1] = mid;
                }
                int less = mid;
                int more = mid;
                while(less > 0 && nums[less-1] == nums[less]) {
                    less--;
                }
                while(more < len - 1 && nums[more+1] == nums[more]) {
                    more++;
                }
                range[0] = less;
                range[1] = more;
                return range;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return range;
    }


    /**
     * 思路：
     * 这个算法效率更高，思路也非常简单
     * 1. 找到 target 的最小索引
     * 2. 找到 target 的最大索引
     * 用时: 10分钟
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange1(int[] nums, int target) {

        int[] range = new int[] {-1, -1};
        range[0] = findMinIndex(nums, target);
        range[1] = findMaxIndex(nums, target);
        return range;
    }

    int findMaxIndex(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                if (mid == len -1 || nums[mid] != nums[mid+1]) {
                    return mid;
                }
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    int findMinIndex(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid-1] != nums[mid]) {
                    return mid;
                }
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
