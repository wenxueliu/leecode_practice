package com.wenxueliu.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ： liuwenxue
 * @date ：2019/12/25 23:38
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode220
 * @modifiedBy ：
 */
public class LeetCode220 {

    /**
     * 思路： 一直没有理解题意
     * 实现： 维护一个 k 元素的窗口，窗口中的元素以 t + 1 为桶的大小。
     * 1. 当新的元素所属的桶号i，窗口存在桶号为i的元素，返回 true
     * 2. 当新的元素所属的桶号，窗口存在桶号为i-1, i+1的元素的差值小于等于t，返回 true
     * 3. 当为 (-bucketSize, 0] [0, bucketSize) 的元素应该处于不同的桶，为了解决这个问题，参考 getBucketNum
     * 算法复杂度：O(N)
     * 空间复杂度：O(N)
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0 || k < 0) {
            return false;
        }
        int len = nums.length;
        int bucketSize = t + 1;
        Map<Integer, Integer> bucketNums = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int bucketNum = getBucketNum(nums[i], bucketSize);
            if (bucketNums.containsKey(bucketNum)) {
                return true;
            }
            bucketNums.put(bucketNum, nums[i]);
            if (bucketNums.containsKey(bucketNum-1) && Math.abs(bucketNums.get(bucketNum-1) - nums[i]) <= t) {
                return true;
            }
            if (bucketNums.containsKey(bucketNum+1) && Math.abs(bucketNums.get(bucketNum+1) - nums[i]) <= t) {
                return true;
            }
            if (i >= k) {
                bucketNums.remove(getBucketNum(nums[i-k], bucketSize));
            }
        }
        return false;
    }

    int getBucketNum(int num, int bucketSize) {
        int bucketNum = num / bucketSize;
        if (num < 0) {
            bucketNum--;
        } else {
            bucketNum++;
        }
        return bucketNum;
    }
}
