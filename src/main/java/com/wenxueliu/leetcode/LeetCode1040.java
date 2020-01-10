package com.wenxueliu.leetcode;

import java.util.Arrays;

/**
 * @author ： liuwenxue
 * @date ：2020/01/10 23:22
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode1040
 * @modifiedBy ：
 */
public class LeetCode1040 {
    /**
     * 思路：这道题初看完全没有思路，题解也都看了，最后实现的时候，理解了 AlgsGC 的答案
     * @param stones
     * @return
     */
    public int[] numMovesStonesII(int[] stones) {
        int []ret = new int[2];
        if (stones.length < 3) {
            return ret;
        }
        Arrays.sort(stones);
        int len = stones.length;
        if (stones[len - 1] + stones[0] + 1 == len) {
            return ret;
        }
        // 1, 2, 5, 8, 10
        // 1, 2, 5, 7, 8
        //stones[n-1] 移动到 (stones[0], stones[n-2]) 之后，还要移动 stones[len-2] - stones[0] + 1) - len
        int max = Math.max(stones[len-2] - stones[0] + 1 - len + 1, stones[len-1] - stones[1] + 1 - len + 1);
        int min = max;
        // 使用滑动窗口，滑动窗口的核心两点：1. 维护窗口最大和最小元素差值 2. 窗口元素个数
        for (int i = 0, j = 0; j < len; j++) {
            //确保窗口中，元素个数不超过 len
            while (stones[j] - stones[i] + 1 > len) {
                i++;
            }
            // 当前窗口中最大值元素个数
            int currentMaxStones = j - i + 1;
            //特殊情况，前 n-1 个元素已经排好序
            if (currentMaxStones == len - 1 && stones[j] - stones[i] + 1 == len - 1) {
                min = Math.min(2, min);
            } else {
                min = Math.min(min, len - currentMaxStones);
            }
        }
        ret[0] = min;
        ret[1] = max;
        return ret;
    }
}
