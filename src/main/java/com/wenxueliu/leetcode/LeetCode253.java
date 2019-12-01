package com.wenxueliu.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ： liuwenxue
 * @date ：2019/11/17 15:13
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode253
 * @modifiedBy ：
 *
 * 给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)，为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
 *
 * 示例 1:
 *
 * 输入: [[0, 30],[5, 10],[15, 20]]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [[7,10],[2,4]]
 * 输出: 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/meeting-rooms-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode253 {


    /**
     * 思路：先根据 start 排序，之后根据 end  维护一个最小堆
     * 用时：见注释
     * 算法复杂度：O(N*lg(N))
     * 空间复杂度： O(N)
     */
    public int minMeetingRooms(int[][] intervals) {
        List<Item> items = new ArrayList<>();
        for (int index = 0; index < intervals.length; index++) {
            Item item = new Item(intervals[index][0], intervals[index][1]);
            items.add(item);
        }
        return minMeetingRooms(items);
    }

    public int minMeetingRooms(List<Item> items) {
        if (items.isEmpty()) {
            return 0;
        }
        Collections.sort(items, (o1, o2) -> o1.start - o2.start);
        PriorityQueue<Integer> queue = new PriorityQueue<>(items.size(), (o1, o2) -> o1 - o2);
        queue.add(items.get(0).end);
        for (int index = 1; index < items.size(); index++) {
            Item item = items.get(index);
            // 大于等于
            if (item.start >= queue.peek()) {
                queue.poll();
            }
            queue.offer(item.end);
        }
        return queue.size();
    }

    class Item {
        int start;
        int end;
        Item(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /**
     * 线段树，解法非常巧妙。
     *  ----------
     *  ---
     *       -----
     *  ----------
     *     ----
     *
     * 算法复杂度：O(N*lg(N))
     * 空间复杂度： O(N)
     * 比如上述表示不同的会议时间，最大并发为 4
     * @param intervals
     * @return
     */
    public int minMeetingRooms1(int[][] intervals) {
        int len = intervals.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
        }
        int res = 0;
        int ans = 0;
        List<Integer> keySorted = map.keySet().stream().sorted().collect(Collectors.toList());
        for (Integer key: keySorted) {
            ans += map.get(key);
            res = Math.max(res, ans);
        }
        return res;
    }



    /**
     * 线段树
     * 与上一解法相似，但是可读性不好
     *
     * 算法复杂度：O(N*lg(N))
     * 空间复杂度： O(N)
     * @param intervals
     * @return
     */
    public int minMeetingRooms2(int[][] intervals) {
        int len = intervals.length;
        int []start = new int[len]; int []end = new int[len];
        for (int index = 0; index < len; index++) {
            start[index] = intervals[index][0];
            end[index] = intervals[index][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int count = 0;
        int endIndex = 0;
        for (int i = 0; i < len; i++) {
            if (start[i] < end[endIndex]) {
                count++;
            } else {
                endIndex++;
            }
        }
        return count;
    }
}
