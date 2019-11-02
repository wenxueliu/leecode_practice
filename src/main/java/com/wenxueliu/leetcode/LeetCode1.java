package com.wenxueliu.leetcode;

import java.util.*;

/**
 * @author ： liuwenxue
 * @date ：2019/10/24 22:40
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode1
 * @modifiedBy ：
 *
 * https://leetcode-cn.com/problems/two-sum
 *
 *
 */
public class LeetCode1 {

    /**
     * 算法很巧妙 O(n)，这种思想很重要，缓存之前结果
     */
    static public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]) , i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalStateException("can not find two sum equals target");
    }

    /**
     * 简单的 O(n^2)，简单，可以保证正确
     */
    static public int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalStateException("can not find two sum equals target");
    }
}
