package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/11/02 10:32
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode41
 * @modifiedBy ：
 */
public class LeetCode41 {

    //并没有按照要求做
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 1;
        }
        int[] copyNums = new int[len+1];
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0 && nums[i] <= len) {
                copyNums[nums[i]-1] = 1;
            }
        }
        for (int j = 0; j < len; j++) {
            if (copyNums[j] != 1) {
                return j+1;
            }
        }
        return len+1;
    }
}
