package com.wenxueliu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author ： liuwenxue
 * @date ：2019/12/28 22:56
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode1288
 * @modifiedBy ：
 */
public class LeetCode1288 {
    /**
     * 思路：对开始进行升序排序，对结束进行降序排序，遍历排序之后的元素， 检查当前元素是否能被之前的元素覆盖
     * 实现
     * 1. 之后与已经满足条件的最后一个元素对比，如果在最后一个元素范围之内，继续遍历。
     * 2. 如果不在，将当前元素加入队里
     * 算法复杂度: O(NlogN)
     * 空间复杂度: O(N)
     * @param intervals
     * @return
     */
    public int removeCoveredIntervals(int[][] intervals) {
        List<Interval> items = initList(intervals);
        if (items.isEmpty()) {
            return 0;
        }
        List<Interval> remainItems = new ArrayList<>();
        items.sort(Comparator.comparing(Interval::getStart).thenComparing(Interval::getEnd));

        remainItems.add(items.get(0));
        for (int index = 1; index < items.size(); index++) {
            Interval item = items.get(index);
            Interval lastItem = remainItems.get(remainItems.size() - 1);
            if (item.start >= lastItem.start && item.end <= lastItem.end) {
                continue;
            } else {
                remainItems.add(item);
            }
        }
        return remainItems.size();
    }

    List<Interval> initList(int[][] intervals) {
        List<Interval> items = new ArrayList<>(1);
        for (int row = 0; row < intervals.length; row++) {
            items.add(new Interval(intervals[row][0], intervals[row][1]));
        }
        return items;
    }

    class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        int getStart() {
            return this.start;
        }

        int getEnd() {
            return this.end;
        }
    }


    /**
     * 思路与我的完全一样，但是代码却比我用 java 8 还精简
     * @param intervals
     * @return
     */
    public int removeCoveredIntervals1(int[][] intervals) {
        int len = intervals.length;
        // 特判
        if (len < 2) {
            return len;
        }

        // 特别注意：当区间左端点相同的时候，右端点降序排序
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o2[0];
            }
            return o1[0] - o2[0];
        });

        // 需要被删除的区间个数
        int remove = 0;
        int currentRight = intervals[0][1];
        for (int i = 1; i < len; i++) {
            if (intervals[i][1] <= currentRight) {
                remove++;
            } else {
                currentRight = intervals[i][1];
            }
        }
        return len - remove;
    }
}

