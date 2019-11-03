package com.wenxueliu.leetcode;

import java.util.Arrays;
import java.util.regex.Matcher;

/**
 * @author ： liuwenxue
 * @date ：2019/11/03 17:34
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode16
 * @modifiedBy ：
 */
public class LeetCode16 {


    /**
     *
     * 通过了，但是时间仅仅超过 5%
     * 思路： 将三数问题分解为两数问题
     * 实现： 按照思路即可
     * 用时: 10分钟
     *
     * 优化：使用 twoSumClosest1 时间超过 96%
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len - 2; i++) {
            int distant = twoSumClosest(nums, i+1, len, target - nums[i]);
            min = minAbs(min, distant);
        }
        return target - min;
    }

    public int twoSumClosest(int[] nums, int start, int end, int target) {
        int min = Integer.MAX_VALUE;
        for (int i = start; i < end - 1; i++) {
            for (int j = start + 1; j < end; j++) {
                int distant = target - nums[i] - nums[j];
                min = minAbs(min, distant);
            }
        }
        return min;
    }

    /**
     * 采用这个方法，时间超过 90%
     * @param nums
     * @param start
     * @param end
     * @param target
     * @return
     */
    public int twoSumClosest1(int[] nums, int start, int end, int target) {
        int min = Integer.MAX_VALUE;
        end = end - 1;
        while (start < end) {
            int sum = nums[start] + nums[end];
            int distant = target - sum;
            min = minAbs(min, distant);
            if (sum < target) {
                start++;
            } else if (sum > target){
                end--;
            } else {
                return 0;
            }
        }
        return min;
    }

    public int minAbs(int m, int n) {
        return Math.abs(m) > Math.abs(n) ? n : m;
    }
}

