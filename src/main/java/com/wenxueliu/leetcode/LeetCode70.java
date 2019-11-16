package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/11/16 19:27
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode70
 * @modifiedBy ：
 */
public class LeetCode70 {
    /**
     * dp[n] = k 表示 n 个台阶有 k 中爬法
     * 根据题目，dp[n] 可以由
     * 1. dp[n-1] 爬一个台阶完成
     * 2. dp[n-2] 爬两个台阶完成
     * 于是递推公式为 dp[n] = dp[n-1] + dp[n-2]
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
