package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/11/09 11:34
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode81
 * @modifiedBy ：
 */
public class LeetCode81 {

    /**
     *  与 LeetCode33 的解法有非常小的区别，仅仅在 num[start] == nums[mid] 时处理不一样
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return false;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + ((end - start) >> 1);
            if (nums[mid] == target) {
                return true;
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
                start++;
            } else { //后半部分有序
                //target在后半部分，注意target大于mid，小于等于end
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else { //target在前半部分
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}
