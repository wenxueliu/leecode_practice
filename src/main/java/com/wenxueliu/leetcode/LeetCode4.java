package com.wenxueliu.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ： liuwenxue
 * @date ：2019/11/02 10:13
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode4
 * @modifiedBy ：
 *
 * Refer:
 * zh: https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * en: https://leetcode.com/problems/median-of-two-sorted-arrays
 *
 * 11-02
 * 思路: 将两个排序数组合并之后取中间值，复杂度 O(n+m)
 * 实现: 思路清楚了，实现不难
 *
 * 思路2:  通过二分搜索，复杂度 O(log(n+m))
 */
public class LeetCode4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int[] target = new int [len];
        int index = 0;
        int i = 0;
        int j = 0;
        for (i = 0, j = 0; (i < len1) && (j < len2); ) {
            if (nums1[i] > nums2[j]) {
                target[index] = nums2[j];
                index++;
                j++;
            } else {
                target[index] = nums1[i];
                index++;
                i++;
            }
        }
        if (i == len1) {
            for (; j < len2; j++) {
                target[index] = nums2[j];
                index++;
            }
        }
        if (j == len2) {
            for (; i < len1; i++) {
                target[index] = nums1[i];
                index++;
            }
        }

        if (len % 2 == 0) {
            int mid = len/2;
            return (target[mid] + target[mid-1])/2.0;
        } else {
            int mid = len/2;
            return target[mid];
        }
    }
}
