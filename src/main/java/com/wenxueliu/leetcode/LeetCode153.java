package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/11/09 17:06
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode153
 * @modifiedBy ：
 */
public class LeetCode153 {

    /**
     * 思路
     * 遍历过程 * 1. 如果 nums[mid] <= num[right] 变化点在 [left,mid] 之间
     * 2. 如果 nums[mid] > num[right] 变化点在 [mid+1,right] 之间
     * 结束条件
     * left > right
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] <= nums[right]) {
                return nums[left];
            }
            int mid = left + ((right - left) >> 1);
            if (nums[mid] <= nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

    /**
     * 思路
     * 遍历过程
     * 1. 如果 nums[mid] > num[left] 变化点在 mid,right 之间
     * 2. 如果 nums[mid] < num[left] 变化点在 left,mid 之间
     * 结束条件
     * nums[mid-1] > num[mid] 或 nums[mid] > nums[mid+1]
     * @param nums
     * @return
     */
    public int findMin1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;

        //本来就是排好序的
        if (nums[0] < nums[right]) {
            return nums[0];
        }

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < nums[right]) {
                //结束条件 2
                if (nums[mid - 1] > nums[mid]) {
                    return nums[mid];
                }
                right = mid - 1;
            } else {
                //结束条件 1
                if (nums[mid] > nums[mid + 1]) {
                    return nums[mid + 1];
                }
                left = mid + 1;
            }
        }
        return -1;
    }


}
