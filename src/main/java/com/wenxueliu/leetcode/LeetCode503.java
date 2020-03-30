package com.wenxueliu.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
* @author liuwenxue
* @date 2020-03-30
*/
public class LeetCode503 {

    /**
     * 思路：递减栈
     * 实现：递减栈
     * 算法复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;

        Deque<Integer> stack = new ArrayDeque<>(nums.length);
        int[] result = new int[len];
        Arrays.fill(result, -1);
        for (int index = 0; index < len * 2; index++) {
            while (!stack.isEmpty() && nums[index % len] > nums[stack.peek()]) {
                result[stack.peek()] = nums[index % len];
                stack.pop();
            }
            if (index < nums.length) {
                stack.push(index % len);
            }
        }
        return result;

    }
}
