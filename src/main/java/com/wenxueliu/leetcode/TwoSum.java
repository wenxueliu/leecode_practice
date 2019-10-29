package com.wenxueliu.leetcode;

import java.util.*;

/**
 * @author ： liuwenxue
 * @date ：2019/10/24 22:40
 * @description :
 * @path : com.wenxueliu.leetcode.TwoSum
 * @modifiedBy ：
 *
 * https://leetcode-cn.com/problems/two-sum
 * 10-24
 * 思路:
 * 1. 排序
 * 2. 左右夹逼
 * 问题:
 * 没有考虑到建立原始数组 value:index 的映射关系
 * 但这种解法是错误的，当数组中遇到相同的数字是无法处理
 * 结果:
 * 最后，参考了答案
 *
 *
 */
public class TwoSum {

    public static void main(String[] args) {
        dumpResult(twoSum(new int[]{2, 11, 7, 15}, 9));
        dumpResult(twoSum(new int[]{3, 2, 4}, 6));
        dumpResult(twoSum(new int[]{3, 3}, 6));
    }

    static void dumpResult(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    static void dumpList(List<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            System.out.println(nums.get(i));
        }
    }

    static public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> index2Value = new HashMap<Integer, Integer>();
        List<Integer> elements = new ArrayList<Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            index2Value.put(i, nums[i]);
            elements.add(nums[i]);
        }
        Collections.sort(elements);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (elements.get(left) + elements.get(right) == target) {
                return new int[] {index2Value.get(elements.get(left)), index2Value.get(elements.get(right))};
            } else if (elements.get(left)+ elements.get(right) > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{};
    }

    /*
     * 简单的 n^2，简单，可以保证正确
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

    /*
     * 这个算法可读性不好
     */
    static public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]) , i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalStateException("can not find two sum equals target");
    }
}
