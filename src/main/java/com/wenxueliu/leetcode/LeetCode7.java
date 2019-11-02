package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/11/02 18:37
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode7
 * @modifiedBy ：
 *
 * 11-02
 * 思路：翻转非常容易，关键是要考虑各种情况，具体见测试类
 * 实现：一开始没有考虑到最大数翻转之后溢出，好在测试的时候发现了。
 * 用时： 30 分钟
 */
public class LeetCode7 {

    /**
     * @param x
     * @return
     *
     * 11-02
     * 思路：翻转非常容易，关键是要考虑各种情况，具体见测试类
     * 实现：一开始没有考虑到最大数翻转之后溢出，好在测试的时候发现了。
     * 用时： 30 分钟
     */
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        String str = String.valueOf(x);
        if (str.charAt(0) == '-') {
            String reverseStr = reverse(str.substring(1));
            return -strToInt(reverseStr);
        } else {
            String reverseStr = reverse(str);
            return strToInt(reverseStr);
        }
    }

    private String reverse(String s) {
        int len = s.length();
        StringBuilder res = new StringBuilder();
        for (int i = len-1; i >= 0; i--) {
            res.append(s.charAt(i));
        }
        return res.toString();
    }

    private int strToInt(String str) {
        String maxInt = String.valueOf(Integer.MAX_VALUE);
        if (str.length() > maxInt.length()) {
            return 0;
        } else if (str.length() == maxInt.length() && str.compareTo(maxInt) > 0) {
            return 0;
        } else {
            return Integer.valueOf(str);
        }
    }

    /**
     * 时间超过 100%
     * 用时：30 分钟
     * 思路：reverseInt 参考了别人的意见
     * @param x
     * @return
     */
    public int reverse1(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        if (x < 0) {
            return -reverseInt(-x);
        } else {
            return reverseInt(x);
        }
    }

    /**
     * 可读性不是很好
     * @param input
     * @return
     */
    public int reverseInt(int input) {
        int res = 0;
        while (input > 0) {
            //这里减少了遍历次数，算是一个 Trick
            if (res > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int v = input % 10;
            res = 10*res + v;
            input /= 10;
        }
        return res;
    }
}
