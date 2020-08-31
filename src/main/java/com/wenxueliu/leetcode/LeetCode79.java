package com.wenxueliu.leetcode;

/**
 * @author liuwenxue
 * @date 2020-08-31
 */
public class LeetCode79 {
    int [][]direction = new int[][] {{0, 1}, {0, -1,}, {1, 0}, {-1, 0}};

    /**
     * 要好好读题
     *
     * 条件比较多，当前应该有优化空间
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        for (int ri = 0; ri < row; ri++) {
            for (int ci = 0; ci < col; ci++) {
                boolean[][] visit = new boolean[row][col];
                if (word.charAt(0) == board[ri][ci]) {
                    boolean res = dfs(board, visit, 0, ri, ci, word.toCharArray());
                    if (res) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, boolean [][]visit, int depth, int rowIndex, int colIndex, char[] words) {
        if (words.length == depth + 1 && words[depth] == board[rowIndex][colIndex]) {
            return true;
        }
        if (words[depth] != board[rowIndex][colIndex]) {
            return false;
        }
        visit[rowIndex][colIndex] = true;
        int row = board.length;
        int col = board[0].length;
        for (int r = 0; r < 4; r++) {
            int newRowIndex = rowIndex + direction[r][0];
            int newColIndex = colIndex + direction[r][1];
            if (newRowIndex >= row || newRowIndex < 0 || newColIndex >= col || newColIndex < 0) {
                continue;
            }
            if (visit[newRowIndex][newColIndex]) {
                continue;
            }
            boolean find = dfs(board, visit, depth + 1, newRowIndex, newColIndex, words);
            if (find) {
                return true;
            }
        }
        visit[rowIndex][colIndex] = false;
        return false;
    }
}
