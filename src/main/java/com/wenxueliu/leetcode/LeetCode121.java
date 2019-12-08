package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/12/08 14:45
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode121
 * @modifiedBy ：
 */
public class LeetCode121 {

    /**
     * 思路：记录最大值和最小值
     * 实现：见思路
     * 算法复杂度: O(N)
     * 空间复杂度: O(1)
     * @param prices
     * @return
     */
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int index = 0; index < prices.length; index++) {
            if (prices[index] < minprice) {
                minprice = prices[index];
            } else if (prices[index] - minprice > maxprofit) {
                maxprofit = prices[index] - minprice;
            }
        }
        return maxprofit;
    }

    /**
     * 思路：动态规划，记录第 i 数之前的最大值 "Kadane 算法"
     * 实现：参考思路
     * 算法复杂度: O(N)
     * 空间复杂度: O(1)
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}
