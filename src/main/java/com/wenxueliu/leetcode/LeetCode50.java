package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/11/09 10:51
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode50
 * @modifiedBy ：
 */
public class LeetCode50 {

    /**
     * 思路：递归
     * 实现：
     * 1. 考虑 n 非常大的情况，遇到 n 就要考虑溢出可能性
     * 2. n 为负数情况
     * 看似简单的题，做起来坑不少
     * 用时：20 分钟
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 /x;
            N = -N;
        }
        return fastPow(x, N);
    }

    public double fastPow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double value = fastPow(x, n / 2);
        if (n % 2 == 1) {
            return value * value * x;
        } else {
            return value * value;
        }
    }
}
