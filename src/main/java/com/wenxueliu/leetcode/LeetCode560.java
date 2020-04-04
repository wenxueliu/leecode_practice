package com.wenxueliu.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
* @author liuwenxue
* @date 2020-04-04
*/
public class LeetCode560 {

    /**
     * 思路：暴力解决
     * 实现：
     * 1. 遍历所有的子数组，找到满足条件的数量
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum1(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0] != k ? 0 : 1;
        }
        int result = 0;
        for (int leftIndex = 0; leftIndex < nums.length - 1; leftIndex++) {
            int sum = nums[leftIndex];
            if (sum == k) {
                result++;
            }
            for (int rightIndex = leftIndex + 1; rightIndex < nums.length; rightIndex++) {
                sum += nums[rightIndex];
                if (sum == k) {
                    result++;
                }
            }
        }
        if (nums[nums.length - 1] == k) {
            result++;
        }
        return result;
    }


    /**
     * 思路：先将前 N 个元素之和缓存，之后再判断，思路更加清晰
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0] != k ? 0 : 1;
        }
        if (nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int[] sumArray = new int[nums.length];
        for (int index = 0; index < nums.length; index++) {
            sum += nums[index];
            sumArray[index] = sum;
        }
        int result = 0;
        for (int leftIndex = 0; leftIndex < nums.length - 1; leftIndex++) {
            // 确保前 0, n-2 的和都被遍历过
            if (sumArray[leftIndex] == k) {
                result++;
            }
            for (int rightIndex = leftIndex + 1; rightIndex < nums.length; rightIndex++) {
                // 确保 (leftIndex, rightIndex] 的和都被遍历过
                if (sumArray[rightIndex] - sumArray[leftIndex] == k) {
                    result++;
                }
            }
        }
        // 确保前 n-1 被遍历
        if (sumArray[nums.length - 1] == k) {
            result++;
        }
        return result;
    }

    /**
     * 思路：前缀和，用 sum[i] 表示前 i 个数字之和。如果存在 sum[i] - k = sum[j]，那么计数加一。
     *
     * 算法的优化来源于对重复计算的消除，而重复计算的消除，一般都是通过空间换时间
     * 对于解法一，第二组遍历，每次需要重复计算 sum，如果我们盟将 index 之和的 sum 缓存起来，利用
     * hash 的 O(1) 复杂度，就能将算法复杂度瞬间由 O(N^2) 降低为 O(n)。
     * 实现：
     * 1. 用一个数组 sumArray 保存后 n 个数字之和。遍历 nums，计算后 x 数字之和来初始化sumArray
     * 2. 遍历 sumArray 如果元素之和为 k 和 sumArray[i] - k = sumArray[j]
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum3(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0] != k ? 0 : 1;
        }
        if (nums.length == 0) {
            return 0;
        }
        int sum = 0;
        Map<Integer, Integer> sumMap = new HashMap<>(nums.length / 2);
        int[] sumArray = new int[nums.length];
        for (int index = 0; index < nums.length; index++) {
            sum += nums[index];
            sumArray[index] = sum;
            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        }
        int result = 0;
        result += sumMap.getOrDefault(k, 0);
        for (int index = 1; index < nums.length; index++) {
            sumMap.put(sumArray[index - 1], sumMap.get(sumArray[index-1]) - 1);
            if (sumMap.containsKey(sumArray[index - 1] + k)) {
                result += sumMap.get(sumArray[index - 1] + k);
            }
        }
        return result;
    }

    public int subarraySum4(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0] != k ? 0 : 1;
        }
        if (nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> sumMap = new HashMap<>(nums.length / 2);
        int sum = 0;
        int result = 0;
        for (int index = 0; index < nums.length; index++) {
            sum += nums[index];
            if (sum == k) {
                result++;
            }
            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        }
        int prefixSum = 0;
        for (int index = 1; index < nums.length; index++) {
            prefixSum += nums[index - 1];
            sumMap.put(prefixSum, sumMap.get(prefixSum) - 1);
            if (sumMap.containsKey(prefixSum + k)) {
                result += sumMap.get(prefixSum + k);
            }
        }
        return result;
    }


    /**
     * 对 subarraySum2 的优化，减少条件判断，思路就是增加一个桩元素
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum6(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0] != k ? 0 : 1;
        }
        if (nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int[] sumArray = new int[nums.length + 1];
        // 第一个元素打桩
        sumArray[0] = 0;
        for (int index = 1; index < nums.length + 1; index++) {
            sum += nums[index - 1];
            sumArray[index] = sum;
        }
        int result = 0;
        for (int rightIndex = 1; rightIndex < nums.length + 1; rightIndex++) {
            for (int leftIndex = 0; leftIndex < rightIndex; leftIndex++) {
                // 当 leftIndex == 0 的特殊情况归一化到下面的条件中，此时 sumArray[0] = 0
                // 确保 [leftIndex, rightIndex] 的和都被遍历过
                if (sumArray[rightIndex] == sumArray[leftIndex] + k) {
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * 对 subarraySum6 优化，使用 Map 缓存结果
     *
     * 这个答案看起来简单，但是从最初的版本到这里需要
     * 1. 空间换时间
     * 2. 打桩元素
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int result = 0;
        prefixSumMap.put(0, 1);
        int sum = 0;
        for (int index = 0; index < nums.length; index++) {
            sum += nums[index];
            // 此时 prefixSumMap 为索引小于 index 的子数组之和，找到子数组之和为 sum - k 的数量
            if (prefixSumMap.containsKey(sum - k)) {
                result += prefixSumMap.get(sum - k);
            }
            prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
