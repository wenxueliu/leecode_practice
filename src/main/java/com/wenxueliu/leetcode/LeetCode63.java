package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/11/17 11:43
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode63
 * @modifiedBy ：
 *
 * 可以先做 LeetCode 62
 */
public class LeetCode63 {
    /**
     * 思路：如果 62 会做，本题也就自然迎刃而解
     * 实现：略
     * 用时：20 分钟
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int col = 0; col < n; col++) {
            if (obstacleGrid[0][col] == 1) {
                dp[0][col] = 0;
                break;
            } else {
                dp[0][col] = 1;
            }
        }
        for (int row = 0; row < m; row++) {
            if (obstacleGrid[row][0] == 1) {
                dp[row][0] = 0;
                break;
            } else {
                dp[row][0] = 1;
            }
        }
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                dp[row][col] = obstacleGrid[row][col] == 1 ? 0 : dp[row][col-1] + dp[row-1][col];
            }
        }
        return dp[m-1][n-1];
    }
}
