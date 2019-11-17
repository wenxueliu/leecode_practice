package com.wenxueliu.leetcode;

import java.util.Arrays;

/**
 * @author ： liuwenxue
 * @date ：2019/11/16 23:53
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode62
 * @modifiedBy ：
 */
public class LeetCode62 {

    /**
     * 思路：
     * 1. dp[i][j] 表示从 [0,0] 到 [i,j] 的路径数量
     * 2. 状态转移方程： dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * 3. 初始化第一行和第一列为 dp[1][j] = 1 dp[i][1] = 1
     * 实现：参考思路
     * 用时：20 分钟
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];
        for (int col = 0; col < n; col++) {
            dp[0][col] = 1;
        }
        for (int row = 0; row < m; row++) {
            dp[row][0] = 1;
        }
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                dp[row][col] = dp[row][col-1] + dp[row-1][col];
            }
        }
        return dp[m-1][n-1];
    }


    /**
     * 比较取巧。
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths1(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] += cur[j-1] ;
            }
        }
        return cur[n-1];
    }
}
