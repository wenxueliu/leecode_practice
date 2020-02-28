package com.wenxueliu.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
* @author liuwenxue
* @date 2020-02-27
*/
public class LeetCode994 {

    /**
     * 思路：思路很简单，就是广度遍历算法
     * 实现：实现的坑很多。要考虑的情况也很多。
     * 1. 深度的标记比较难做，最后使用对象的方式才得以解决。
     * 2. 对于 {{2,2},{1,1},{0,0},{2,0}} 没有考虑到
     * 用时：5 个小时
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int depth = 0;
        int count = 0;
        Queue<Node> queue = new LinkedList<>();
        for (int rowIndex = 0; rowIndex < row; rowIndex++) {
            for (int colIndex = 0; colIndex < col; colIndex++) {
                if (grid[rowIndex][colIndex] == 2) {
                    queue.offer(new Node(rowIndex, colIndex, depth));
                }
                if (grid[rowIndex][colIndex] == 1) {
                    count++;
                }
            }
        }

        while(!queue.isEmpty()) {
            count++;
            Node node = queue.poll();
            depth = Integer.max(node.depth, depth);
            travel(queue, grid, node.rowIndex, node.colIndex, node.depth + 1);
        }

        for (int rowIndex = 0; rowIndex < row; rowIndex++) {
            for (int colIndex = 0; colIndex < col; colIndex++) {
                if (grid[rowIndex][colIndex] == 1) {
                    return -1;
                }
            }
        }
        return depth;
    }

    void travel(Queue<Node> queue, int [][]grid, int rowIndex, int colIndex, int depth) {
        int row = grid.length;
        int col = grid[0].length;
        if (rowIndex - 1 >= 0 && grid[rowIndex-1][colIndex] == 1) {
            grid[rowIndex-1][colIndex] = 2;
            queue.offer(new Node(rowIndex - 1, colIndex, depth));
        }
        if (rowIndex + 1 < row && grid[rowIndex+1][colIndex] == 1) {
            grid[rowIndex+1][colIndex] = 2;
            queue.offer(new Node(rowIndex + 1, colIndex, depth));
        }
        if (colIndex - 1 >= 0 && grid[rowIndex][colIndex - 1] == 1) {
            grid[rowIndex][colIndex - 1] = 2;
            queue.offer(new Node(rowIndex, colIndex - 1, depth));
        }
        if (colIndex + 1 < col && grid[rowIndex][colIndex + 1] == 1) {
            grid[rowIndex][colIndex + 1] = 2;
            queue.offer(new Node(rowIndex, colIndex + 1, depth));
        }
    }

    class Node {
        int rowIndex;
        int colIndex;
        int depth;

        Node(int rowIndex, int colIndex, int depth) {
            this.rowIndex = rowIndex;
            this.colIndex = colIndex;
            this.depth = depth;
        }
    }
}
