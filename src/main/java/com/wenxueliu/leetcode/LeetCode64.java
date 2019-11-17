package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/11/17 12:27
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode64
 * @modifiedBy ：
 */
public class LeetCode64 {

    /**
     * 思路：
     * 初始化：dp[0][i] 和 dp[i][0]
     * 状态 dp[i][j] ：到当前节点时的最小路径
     * 转移方程：dp[i][j] = min(dp[i][j-1], dp[i-1][j]) + grid[i][j]
     * 实现：略
     * 用时: 20 分钟
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int [][]dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int row = 1; row < m; row++) {
            dp[row][0] = dp[row - 1][0] + grid[row][0];
        }
        for (int col = 1; col < n; col++) {
            dp[0][col] = dp[0][col- 1] + grid[0][col];
        }
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                dp[row][col] = Math.min(dp[row-1][col], dp[row][col-1]) + grid[row][col];
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * 解法与上面一样，但是空间是 O(1)
     * @param grid
     * @return
     */
    public int minPathSum1(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        for (int row = 1; row < m; row++) {
            grid[row][0] = grid[row - 1][0] + grid[row][0];
        }
        for (int col = 1; col < n; col++) {
            grid[0][col] = grid[0][col- 1] + grid[0][col];
        }
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                grid[row][col] = Math.min(grid[row-1][col], grid[row][col-1]) + grid[row][col];
            }
        }
        return grid[m-1][n-1];
    }
}
