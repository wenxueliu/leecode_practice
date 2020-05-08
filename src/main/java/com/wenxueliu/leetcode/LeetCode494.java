package com.wenxueliu.leetcode;/**
* @author liuwenxue
* @date 2020-05-09
*/
public class LeetCode494 {

    int count = 0;

    public int findTargetSumWays(int[] nums, int S) {
        count = 0;
        if (nums.length == 0) {
            if (S == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        sumWays(nums, 0, S - nums[0]);
        sumWays(nums, 0, S + nums[0]);
        return count;
    }

    public void sumWays(int[] nums, int index, int S) {
        if (index == nums.length - 1) {
            if (S == 0) {
                count++;
            }
            return;
        }
        sumWays(nums, index+1, S + nums[index+1]);
        sumWays(nums, index+1, S - nums[index+1]);
    }
}
