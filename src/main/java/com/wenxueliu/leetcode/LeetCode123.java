package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2020/01/24 12:09
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode123
 * @modifiedBy ：
 */
public class LeetCode123 {
    /**
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        //交易两次，所以为 4
        int maxTradeTimes = 4;
        int [][]dp = new int[len][maxTradeTimes+1];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int index = 1; index < len; index++) {
            dp[index][0] = 0;
            for (int tradeTimes = 1; tradeTimes <= maxTradeTimes; tradeTimes++) {
                // index + 1 为元素个数，tradeTimes 为交易次数。 当 tradeTimes 大于 index+1 是没有意义的
                if (index + 1 < tradeTimes) {
                    dp[index][tradeTimes] = Integer.MIN_VALUE;
                } else {
                    if (tradeTimes % 2 == 0) {
                        // rest 或 sell
                        dp[index][tradeTimes] = Math.max(dp[index-1][tradeTimes], dp[index-1][tradeTimes-1] + prices[index]);
                    } else {
                        // rest 或 buy
                        dp[index][tradeTimes] = Math.max(dp[index-1][tradeTimes], dp[index-1][tradeTimes-1] - prices[index]);
                    }

                }
            }
        }
        int maxValue = Integer.MIN_VALUE;
        // 最大值一定为卖出操作
        for (int tradeTimes = 0; tradeTimes <= maxTradeTimes; tradeTimes+=2) {
            maxValue = Math.max(maxValue, dp[len-1][tradeTimes]);
        }
        return maxValue;
    }
}
