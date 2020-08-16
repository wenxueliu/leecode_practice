package com.wenxueliu.leetcode;

import java.util.Arrays;

/**
 * @author liuwenxue
 * @date 2020-08-16
 */
public class LeetCode5489 {
    /**
     * 参考题解，自己完全没有思路
     * https://leetcode-cn.com/problems/magnetic-force-between-two-balls/solution/er-fen-sou-su-45ms-by-geguanting/
     * <p>
     * 1. m 个节点，先算出最大间隔，和最小间隔
     * 2. 利用二分法，找到合适的间隔
     *
     * @param position
     * @param m
     * @return
     */
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int len = position.length;
        int right = (position[len - 1] - position[0]) / (m - 1);
        int left = 1;
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(position, mid, m)) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    boolean check(int[] position, int distant, int m) {
        int count = 1;
        int left = 0;
        int len = position.length;
        for (int right = 1; right < len; right++) {
            if (position[right] - position[left] >= distant) {
                left = right;
                count++;
            }
            if (count >= m) {
                return true;
            }
        }
        return false;
    }
}
