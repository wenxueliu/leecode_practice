package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/11/10 01:01
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode167
 * @modifiedBy ：
 */
public class LeetCode167 {
    /**
     * 思路：两边夹逼
     * 实现：很简单
     * 用时：10 分钟
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                return new int[]{left+1, right+1};
            }
        }
        return new int[]{};
    }

    /**
     * 思路：用二分法查找，过滤掉一部分数
     * 实现：需要考虑 target 为负数和正数，待完成
     * 用时：10 分钟
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum1(int[] numbers, int target) {
        return new int[] {};
    }
}
