package com.wenxueliu.leetcode;

/**
 * @author liuwenxue
 * @date 2020-11-18
 */
public class LeetCode213 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(rob1(nums, 0, len - 2), rob1(nums, 1, len - 1));
    }

    int rob1(int[] nums, int start, int end) {
        int len = end - start + 1;
        int[] dp = new int[len];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start + 1], nums[start]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i + start]);
        }
        return dp[len - 1];
    }
}
