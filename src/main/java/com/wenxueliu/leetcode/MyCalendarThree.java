package com.wenxueliu.leetcode;

import java.util.TreeMap;

/**
 * @author ： liuwenxue
 * @date ：2020/01/04 12:55
 * @description :
 * @path : com.wenxueliu.leetcode.MyCalendarThree
 * @modifiedBy ：
 */
public class MyCalendarThree {

    TreeMap<Integer, Integer> start2end = new TreeMap<>();
    public MyCalendarThree() {

    }

    /**
     * 思路：线段树的标准解法
     * 实现：O(N)
     * @param start
     * @param end
     * @return
     */
    public int book(int start, int end) {
        start2end.put(start, start2end.getOrDefault(start, 0)+1);
        start2end.put(end, start2end.getOrDefault(end, 0)-1);
        int overlapTimes = 0;
        int maxTimes = 0;
        for (int key : start2end.keySet()) {
            overlapTimes += start2end.get(key);
            maxTimes = Math.max(overlapTimes, maxTimes);
        }
        return maxTimes;
    }
}
