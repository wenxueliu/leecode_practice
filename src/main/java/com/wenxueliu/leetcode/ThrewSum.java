package com.wenxueliu.leetcode;

import java.util.*;

/**
 * @author ： liuwenxue
 * @date ：2019/10/24 23:27
 * @description :
 * @path : com.wenxueliu.leetcode.ThrewSum
 * @modifiedBy ：
 *
 * 10.24
 * 前提：先完成 Two Sum
 * 思路: 分治思想，在Two Sum 的基础上增加一个数
 * 解决办法：遍历每个数字，其余数字用 Two Sum，我用了 Map 的方式，超出时间限制，由于需要的是值，我用 Set，还是超出时间限制
 * 只能看答案
 *
 */
public class ThrewSum {

    public static void main(String[] args) {
        dump(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        dump(threeSum(new int[]{-1, 0, 0, 0, 0, 0, 0, -1, 2}));
        dump(threeSum(new int[]{-1, 0, 0, 0, -1, 2, -1}));
    }

    static void dump(List<List<Integer>> nums) {
        for (List<Integer> elements : nums) {
            StringBuilder line = new StringBuilder();
            for (int e : elements) {
                line.append(e).append(",");
            }
            System.out.println(line);
        }
        System.out.println();
    }

    static public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            List<List<Integer>> twoResults = twoSum2(nums, i+1, 0 - nums[i]);
            if (!twoResults.isEmpty()) {
                for (List<Integer> oneSolution : twoResults) {
                    oneSolution.add(nums[i]);
                    Collections.sort(oneSolution);
                    if (!results.contains(oneSolution)) {
                        results.add(oneSolution);
                    }
                }
            }
        }
        return results;
    }

    /**
     * 第一次尝试，超时时间限制
     * @param nums
     * @param startIndex
     * @param target
     * @return
     */
    static public List<List<Integer>> twoSum1(int[] nums, int startIndex, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = startIndex; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                List<Integer> oneSolution = new ArrayList<Integer>();
                oneSolution.add(nums[i]);
                oneSolution.add(target - nums[i]);
                results.add(oneSolution);
            } else {
                map.put(nums[i], i);
            }
        }
        return results;
    }

    /**
     * 在 map 基础上改为 set，还是超出时间限制
     * @param nums
     * @param startIndex
     * @param target
     * @return
     */
    static public List<List<Integer>> twoSum2(int[] nums, int startIndex, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Set<Integer> set = new HashSet<Integer>();
        for (int i = startIndex; i < nums.length; i++) {
            if (set.contains(target - nums[i])) {
                List<Integer> oneSolution = new ArrayList<Integer>();
                oneSolution.add(nums[i]);
                oneSolution.add(target - nums[i]);
                results.add(oneSolution);
            } else {
                set.add(nums[i]);
            }
        }
        return results;
    }

    /**
     * 该解法刚通过，只击败了 5% 的用户
     * @param nums
     * @return
     */
    static public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> inputs = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            inputs.add(nums[i]);
        }
        Collections.sort(inputs);
        for (int i = 0; i < inputs.size() - 2; i++) {
            List<List<Integer>> twoResults = twoSum(inputs, i+1, 0 - inputs.get(i));
            if (!twoResults.isEmpty()) {
                for (List<Integer> oneSolution : twoResults) {
                    oneSolution.add(inputs.get(i));
                    Collections.sort(oneSolution);
                    if (!results.contains(oneSolution)) {
                        results.add(oneSolution);
                    }
                }
            }
        }
        return results;
    }

    static public List<List<Integer>> twoSum(List<Integer> nums, int startIndex, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> inputs = nums.subList(startIndex, nums.size());
        int left = 0;
        int right = inputs.size() - 1;
        while (left < right) {
            if (inputs.get(left) + inputs.get(right) == target) {
                //while (left > 0 && inputs.get(left).equals(inputs.get(left-1))) {
                //    left++;
                //}
                //while (right > 0 && right < inputs.size() - 1 && inputs.get(right).equals(inputs.get(right+1))) {
                //    right--;
                //}
                List<Integer> oneSolution = new ArrayList<Integer>();
                oneSolution.add(inputs.get(left));
                oneSolution.add(inputs.get(right));
                results.add(oneSolution);
                left++;
                right--;
            } else if (inputs.get(left) + inputs.get(right) > target) {
                right--;
            } else {
                left++;
            }
        }
        return results;
    }
}
