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
     * 思路：
     * mid 与 0 比较
     * 如果 nums[mid] > nums[0]，nums[mid+1] < nums[0]，mid+1为索引
     * 如果 nums[mid] < nums[0]，nums[mid-1] > nums[0]，mid为索引
     *
     * @param nums 数组
     * @return
     */
    public int findMin1(int[] nums) {
        return nums[findMinIndex1(nums)];
    }

    int findMinIndex1(int []nums) {
        if (nums.length == 1) {
            return 0;
        }
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        if (nums[left] <= nums[right]) {
            return left;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[0]) {
                if (mid < len && nums[mid+1] < nums[0]) {
                    return mid+1;
                }
                left = mid + 1;
            } else if (nums[mid] == nums[0]) {
                if (mid < len && nums[0] > nums[mid+1]) {
                    return mid+1;
                }
                left = mid + 1;
            } else if (nums[mid] < nums[0]) {
                if (mid > 0 && nums[mid-1] > nums[0]) {
                    return mid;
                }
                right = mid - 1;
            }
        }
        return -1;
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
    public int findMin2(int[] nums) {
        return nums[findMinIndex2(nums)];
    }

    int findMinIndex2(int []nums) {
        if (nums.length == 1) {
            return 0;
        }
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        if (nums[left] <= nums[right]) {
            return left;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[0]) {
                //结束条件 1
                if (nums[mid+1] < nums[mid]) {
                    return mid+1;
                }
                left = mid + 1;
            } else if (nums[mid] < nums[0]) {
                //结束条件 2
                if (nums[mid-1] > nums[mid]) {
                    return mid;
                }
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 思路
     * 遍历过程
     * 1. 如果 nums[mid] <= num[right] 变化点在 [left,mid] 之间
     * 2. 如果 nums[mid] > num[right] 变化点在 [mid+1,right] 之间
     * 结束条件
     * left > right
     * @param nums
     * @return
     */
    public int findMin3(int[] nums) {
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
}
