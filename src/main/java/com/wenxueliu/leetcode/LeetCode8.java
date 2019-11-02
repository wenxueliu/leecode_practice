package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/11/02 10:28
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode8
 * @modifiedBy ：
 */
public class LeetCode8 {

    private static long toInt(String trimStr, int sign) {
        if (trimStr.isEmpty())
        {
            return 0;
        }
        StringBuilder intStr = new StringBuilder();
        int len = trimStr.length();
        boolean startZero = true;
        for (int i = 0; i<len; i++) {
            char charInt = trimStr.charAt(i);
            if (charInt == '0' && startZero) {
                continue;
            } else if (charInt >= '0' && charInt <= '9') {
                startZero = false;
                intStr.append(charInt);
            } else {
                break;
            }
        }
        if (intStr.toString().isEmpty())
        {
            return 0;
        }
        if (sign == 0) {
            if (intStr.toString().length() > String.valueOf(Integer.MAX_VALUE).length())
            {
                return Integer.MAX_VALUE;
            }
            long longValue = Long.parseLong(intStr.toString());
            if (longValue > Integer.MAX_VALUE)
            {
                return Integer.MAX_VALUE;
            } else {
                return longValue;
            }
        } else {
            if (intStr.toString().length() > String.valueOf(Integer.MAX_VALUE).length())
            {
                return Integer.MIN_VALUE;
            }
            long longValue = Long.parseLong(intStr.toString());
            if (-1 * longValue < Integer.MIN_VALUE)
            {
                return Integer.MIN_VALUE;
            } else {
                return -1 * longValue;
            }
        }
    }

    public static int myAtoi(String str) {
        String trimStr = str.trim();
        if (trimStr.startsWith("-")) {
            trimStr = trimStr.substring(1);
            long value = toInt(trimStr, 1);
            if (value == Integer.MAX_VALUE)
            {
                return Integer.MIN_VALUE;
            } else {
                return (int)value;
            }
        } else if (trimStr.startsWith("+")) {
            trimStr = trimStr.substring(1);
            return (int)toInt(trimStr, 0);
        } else {
            return (int)toInt(trimStr, 0);
        }
    }
}
