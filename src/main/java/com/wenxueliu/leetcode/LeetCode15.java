package com.wenxueliu.leetcode;

import sun.util.resources.cldr.zh.CalendarData_zh_Hans_HK;

import java.util.*;

/**
 * @author ： liuwenxue
 * @date ：2019/11/03 13:19
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode15
 * @modifiedBy ：
 */
public class LeetCode15 {

    /**
     * 第一次的解法，使用了 List，刚过
     * @param nums
     * @return
     */
    static public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> inputs = new ArrayList<>();
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
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> inputs = nums.subList(startIndex, nums.size());
        int left = 0;
        int right = inputs.size() - 1;
        while (left < right) {
            if (inputs.get(left) + inputs.get(right) == target) {
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

    /**
     * 11-03
     * 用数组替换集合框架，时间 35ms 超过 91%
     * @param nums
     * @return
     */
    static public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if (len < 3) {
            return ans;
        }
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < len ; i++) {
            // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if (nums[i] > 0) {
                break;
            }
            // 去重
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            List<List<Integer>> twoSumValues = twoSum(nums, i+1, len-1, 0 - nums[i]);
            for (List<Integer> twoSumValue : twoSumValues) {
                twoSumValue.add(nums[i]);
                ans.add(twoSumValue);
            }
        }
        return ans;
    }

    static List<List<Integer>> twoSum(int[] nums, int start, int end, int target) {
        List<List<Integer>> results = new ArrayList<>();
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                List<Integer> result = new ArrayList<Integer>();
                result.add(nums[start]);
                result.add(nums[end]);
                results.add(result);
                while (start < end && nums[start] == nums[start+1]) {
                    start++;
                }
                while (start < end && nums[end] == nums[end-1]) {
                    end--;
                }
                start++;
                end--;
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }
        return results;
    }

    /**
     * 参考其他人解法，时间 35ms
     * @param nums
     * @return
     */
    static public List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if (len < 3) {
            return ans;
        }
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len ; i++) {
            if (nums[i] > 0) {
                break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                continue; // 去重
            }
            int L = i+1;
            int R = len-1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) {
                        L++; // 去重
                    }
                    while (L<R && nums[R] == nums[R-1]) {
                        R--; // 去重
                    }
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else if (sum > 0) {
                    R--;
                }
            }
        }
        return ans;
    }
}
