package com.wenxueliu.leetcode;

import java.util.List;

/**
 * @author ： liuwenxue
 * @date ：2019/11/16 21:06
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode120
 * @modifiedBy ：
 */
public class LeetCode120 {

    /**
     * 思路：从上到下，明显第 n 行只会受第 n-1 行影响，总结递推公式。
     * 实现：考虑边缘情况。
     * 用时：30 分钟
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty()) {
            return 0;
        }
        int rows = triangle.size();
        int [][]dp = new int[rows][rows];
        dp[0][0] = triangle.get(0).get(0);
        for (int row = 1; row < rows; row++) {
            for (int col = 0; col <= row; col++) {
                if (col == 0) {
                    dp[row][0] = dp[row-1][0] + triangle.get(row).get(0);
                    continue;
                }
                if (col == row) {
                    dp[row][row] = dp[row-1][row-1] + triangle.get(row).get(row);
                    continue;
                }
                dp[row][col] = Math.min(dp[row-1][col], dp[row-1][col-1]) + triangle.get(row).get(col);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i< rows; i++) {
            min = Math.min(dp[rows-1][i], min);
        }
        return min;
    }


    /**
     * 解法二，从下往上遍历，代码简洁很多
     * @param triangle
     * @return
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int[][] dp = new int[rows][rows];
        for (int col = 0; col < rows; col++) {
            dp[rows-1][col] = triangle.get(rows-1).get(col);
        }
        for (int row = rows-2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                dp[row][col] = Math.min(dp[row+1][col], dp[row+1][col+1]) + triangle.get(row).get(col);
            }
        }
        return dp[0][0];
    }
}
