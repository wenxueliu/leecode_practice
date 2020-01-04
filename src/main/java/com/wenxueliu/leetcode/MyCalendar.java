package com.wenxueliu.leetcode;

import java.util.TreeMap;

/**
 * @author ： liuwenxue
 * @date ：2020/01/04 10:34
 * @description :
 * @path : com.wenxueliu.leetcode.MyCalendar
 * @modifiedBy ：
 */
public class MyCalendar {

    TreeMap<Integer, Integer> start2end = new TreeMap<>();

    public MyCalendar() {

    }

    /**
     * 思路：用双hashMap分别记录第一次和第二次重叠的算法，考虑情况多，实现复杂，非常容易出错。而线段树的方法，简洁实用
     * 实现：线段树
     * 算法复杂度：O(N^2)
     * 空间复杂度：O(N)
     * 拓展：要返回最后保留的数组列表，如何实现？
     * @param start
     * @param end
     * @return
     */
    public boolean book(int start, int end) {
        start2end.put(start, start2end.getOrDefault(start, 0)+1);
        start2end.put(end, start2end.getOrDefault(end, 0)-1);
        if (isOverlapTimes(start, end, 2)) {
            start2end.put(start, start2end.get(start)-1);
            start2end.put(end, start2end.get(end)+1);
            // 优化点1，删除不用的元素减少 hash 冲突
            if (start2end.get(start) == 0) {
                start2end.remove(start);
            }
            if (start2end.get(end) == 0) {
                start2end.remove(end);
            }
            return false;
        }
        return true;
    }

    boolean isOverlapTimes(int start, int end, int totalTimes) {
        int overlapTimes = 0;
        for (int key : start2end.keySet()) {
            overlapTimes += start2end.get(key);
            if (overlapTimes >= totalTimes) {
                return true;
            }
            // 优化点2，已经超过 end, 就没有必要继续算了
            if (key > end) {
                return false;
            }
        }
        return false;
    }

    /**
     * 思路：检查是否存在重复
     * 实现：略
     * 算法复杂度：O(NlogN)
     * 空间复杂度：O(N)
     * @param start
     * @param end
     * @return
     */
    public boolean book1(int start, int end) {
        Integer prev = start2end.floorKey(start),
                next = start2end.ceilingKey(start);
        if ((prev == null || start2end.get(prev) <= start) &&
                (next == null || end <= next)) {
            start2end.put(start, end);
            return true;
        }
        return false;
    }
}
