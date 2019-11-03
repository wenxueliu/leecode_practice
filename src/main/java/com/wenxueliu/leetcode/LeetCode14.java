package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/11/03 01:06
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode14
 * @modifiedBy ：
 *
 * 本题黑可用解法：
 * 1. 分治
 * 2. trie 树
 */
public class LeetCode14 {
    /**
     * 思路：思路很简单的常规思路
     * @param strs
     * @return
     */
    public String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder commonPrefix = new StringBuilder();

        int commonMinlen = strs[0].length();
        for (String str : strs) {
            commonMinlen = str.length() > commonMinlen ? commonMinlen : str.length();
        }
        int leftIndex = 0;
        int rightIndex = 0;
        while (rightIndex < commonMinlen) {
            if (!isEqual(strs, leftIndex, rightIndex + 1)) {
                //commonPrefix.append(0, rightIndex)
                return strs[0].substring(0, rightIndex);
            }
            rightIndex++;
        }
        return strs[0].substring(0, rightIndex);
    }

    boolean isEqual(String[] strs, int start, int end) {
        String str = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].substring(start, end).equals(str.substring(start, end)) ){
                return false;
            }
        }
        return true;
    }

    /**
     * 11-03
     * 实现: 挨个字符比较是必须的，用 char 性能要好于 String，时间超过95%
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int i = 0;
        //情况一：元素 0 是最短的
        //情况二：元素 0 不是最短的
        while (i < strs[0].length()) {
            char stub = strs[0].charAt(i);
            for (String str : strs) {
                if (str.length() == i || str.charAt(i) != stub) {
                    return strs[0].substring(0, i);
                }
            }
            i++;
        }
        return strs[0];
    }
}
