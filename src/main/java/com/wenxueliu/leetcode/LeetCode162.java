package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/11/09 21:52
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode162
 * @modifiedBy ：
 */
public class LeetCode162 {
    /**
     * 思路：关键在于 num[i] != num[i+1] 和 num[-1] = num[n] = 负无穷大，这两个条件决定了，如果 nums[i] > nums[i + 1]，小于 i
     * 的索引肯定可以找到满足条件的值。nums[i] > num[i-1] 同理。
     * 实现：理解思路中的前提，实现就非常简单了。
     * 用时：没有抓住题目隐藏的条件，需要好好审题。参考答案
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        for (; left < right; ) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
