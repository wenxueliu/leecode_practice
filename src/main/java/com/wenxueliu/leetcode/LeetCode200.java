package com.wenxueliu.leetcode;/**
* @author liuwenxue
* @date 2020-05-26
*/
public class LeetCode200 {

    int [][]d = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;
        for (int rowIndex = 0; rowIndex < row; rowIndex++) {
            for (int colIndex = 0; colIndex < col; colIndex++) {
                if (grid[rowIndex][colIndex] == '1') {
                    ans++;
                    dfs(grid, rowIndex, colIndex);
                }
            }
        }
        return ans;
    }

    void dfs(char [][]grid, int x, int y) {
        int row = grid.length;
        int col = grid[0].length;
        if (isLegal(x, y, row, col) && grid[x][y] == '1') {
            grid[x][y] = '0';
            dfs(grid, x - 1, y);
            dfs(grid, x + 1, y);
            dfs(grid, x, y - 1);
            dfs(grid, x, y + 1);
        }
    }

    boolean isLegal(int x, int y, int row, int col) {
        return x < row && x >= 0 && y >= 0 && y < col;
    }
}
