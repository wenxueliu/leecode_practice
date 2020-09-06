package com.wenxueliu.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

/**
* @author liuwenxue
* @date 2020-04-01
*/
public class LeetCode84 {

    public int largestRectangleArea(int[] heights) {

        Deque<Integer> stack = new ArrayDeque<>(heights.length);
        stack.push(-1);

        int maxValue = 0;
        for (int index = 0; index < heights.length; index++) {
            while(stack.size() > 1 && heights[index] <= heights[stack.peek()]) {
                int lastIndex = stack.pop();
                maxValue = Math.max(maxValue, (index - stack.peek() - 1) * heights[lastIndex]);
            }
            stack.push(index);
        }
        while(stack.size() > 1) {
            int lastIndex = stack.pop();
            maxValue = Math.max(maxValue, (heights.length -  stack.peek() - 1) * heights[lastIndex]);
        }
        return maxValue;
    }

    /**
     * 单调栈 + 特殊情况的考虑
     * 单调栈 + 哨兵
     *
     * 理解该题的方法
     * 1. [看这个题解](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/xiang-jie-dan-diao-zhan-bi-xu-miao-dong-by-sweetie/)，并自己亲自根据答案画图
     * 2. [看这个题解](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/bao-li-jie-fa-zhan-by-liweiwei1419/) 深入理解
     * 3. 自己背写
     * @param heights
     * @return
     */
    public int largestRectangleArea1(int[] heights) {
        int len = heights.length;
        int[]tmp = new int[len + 2];
        System.arraycopy(heights, 0, tmp, 1, len);
        Deque<Integer> stack = new ArrayDeque<>();
        int area = 0;
        for (int index = 0; index < len + 2; index++) {
            while (!stack.isEmpty() && tmp[index] < tmp[stack.peek()]) {
                int rightIndex = index;
                int heightIndex = stack.pop();
                int height = tmp[heightIndex];
                int leftIndex = stack.peek();
                area = Math.max(area, (rightIndex - leftIndex - 1) * height)
            }
            stack.push(index);
        }
        return area;
    }
}
