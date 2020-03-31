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
}
