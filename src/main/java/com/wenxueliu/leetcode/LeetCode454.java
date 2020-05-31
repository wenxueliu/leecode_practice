package com.wenxueliu.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
* @author liuwenxue
* @date 2020-05-31
*/
public class LeetCode454 {
    /**
     * 先排序，然后固定， 之后二分查找。超时了
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int len = A.length;
        Map<Integer, Integer> sumAB = sum2(A, B);
        int count = 0;
        for (int c = 0; c < len; c++) {
            for (int d = 0; d < len; d++) {
                count += sumAB.getOrDefault(-C[c] - D[d], 0);
            }
        }
        return count;
    }

    Map<Integer, Integer> sum2(int []one, int[]other) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = one.length;
        for (int leftIndex = 0; leftIndex < len; leftIndex++) {
            for (int rightIndex = 0; rightIndex < len; rightIndex++) {
                int value = one[leftIndex] + other[rightIndex];
                map.put(value, map.getOrDefault(value, 0) + 1);
            }
        }
        return map;
    }
}
