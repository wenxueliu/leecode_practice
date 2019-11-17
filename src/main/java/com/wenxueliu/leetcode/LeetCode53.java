package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/11/16 22:06
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode53
 * @modifiedBy ：
 */
public class LeetCode53 {

    /**
     * 思路：递归公式 dp[i] = Math.max(dp[i] + nums[i], nums[i])
     * 实现：很简单
     * 用时：对于递推公式是参考答案的，有了递推公式题目就很简单了。虽然想找到 dp[n] 和 dp[n-1] 的关系，
     * 但是如何定义 dp[n] 还是不得法
     *
     * 要点：
     * 定义 dp[i]：表示以 nums[i] 结尾的连续子数组的最大和。
     * 状态转移方程：
     * dp[i] 的值要看 dp[i - 1]，因为 nums[i] 一定被选取，那么 dp[i - 1] 的正负就作为分类的标准。
     * 1. 如果 dp[i - 1] >= 0，那么可以把 nums[i] 直接接在 dp[i - 1] 表示的那个数组的后面。
     * 2. 如果 dp[i - 1] < 0，那么加上前面的数反而我越来越小了，就是 nums[i]。
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[]dp = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], 0) + nums[i];
            result = Math.max(dp[i], result);
        }
        return result;
    }
}
