package com.wenxueliu.leetcode;

/**
 * @author liuwenxue
 * @date 2020-04-06
 */
public class LeetCode209 {
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        int minLen = len;
        int sum = 0;
        int leftIndex = 0;
        boolean find = false;
        for (int rightIndex = 0; rightIndex < len; rightIndex++) {
            sum += nums[rightIndex];
            if (sum >= s) {
                find = true;
                while (sum - nums[leftIndex] >= s) {
                    sum -= nums[leftIndex];
                    leftIndex++;
                }
                minLen = Math.min(minLen, rightIndex - leftIndex + 1);
            }
        }
        return find ? minLen : 0;
    }
}
