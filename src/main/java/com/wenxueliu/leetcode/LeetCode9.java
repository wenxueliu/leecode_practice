package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/11/02 23:54
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode9
 * @modifiedBy ：
 */
public class LeetCode9 {

    /**
     * 思路：很简单，但是需要转字符串，可读性好，Lg(N)
     * 用时：20 分钟
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        String value = String.valueOf(x);
        int len = value.length();
        for (int i = 0; i < len/2; i++) {
            char left = value.charAt(i);
            char right = value.charAt(len - 1 - i);
            if (left != right) {
                return false;
            }
        }
        return true;
    }

    /**
     * 思路：与 LeetCode7 思路相近，时间超过 100%
     * @param x
     * @return
     */
    public boolean isPalindrome1(int x) {
        int reverseValue = 0;
        int cloneX = x;
        while (cloneX > 0) {
            reverseValue = reverseValue * 10 + cloneX % 10;
            cloneX = cloneX / 10;
        }
        return reverseValue == x;
    }
}
