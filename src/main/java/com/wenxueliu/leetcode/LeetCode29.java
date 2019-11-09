package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/11/06 22:56
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode29
 * @modifiedBy ：
 */
public class LeetCode29 {

    /**
     * 思路：将除数左移，每次减去最接近被减数的值，直到被减数小于减少
     * 实现：需要考虑的情况较多，容易出错。由于特殊情况没有考虑周到花费大量时间
     * 时长：4 个小时
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE) {
            return 1;
        }
        int flag = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) ? 1 : -1;
        if (dividend < 0) {
            dividend = -dividend;
        }
        if (divisor < 0) {
            divisor = -divisor;
        }
        int value = 0;
        while (dividend - divisor >= 0) {
            int i = 0;
            while (divisor << i <= dividend/2 ) {
                i++;
            }
            value += 1 << i;
            dividend -= divisor << i;
        }
        if (flag < 0) {
            return -value;
        } else {
            return value;
        }
    }

    /**
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide1(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE) {
            return 1;
        }
        if (divisor == -1) {
            return -dividend;
        }
        if (divisor == 1) {
            return dividend;
        }
        int flag = (dividend > 0) ^ (divisor > 0) ? -1 : 1;
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }
        int value = 0;
        while (dividend - divisor <= 0) {
            int i = 0;
            while (divisor << i >= dividend/2 ) {
                i++;
            }
            value += 1 << i;
            dividend -= divisor << i;
        }
        if (flag < 0) {
            return -value;
        } else {
            return value;
        }
    }
}
