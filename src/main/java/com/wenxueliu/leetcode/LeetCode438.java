package com.wenxueliu.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ： liuwenxue
 * @date ：2020/01/14 00:38
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode438
 * @modifiedBy ：
 */
public class LeetCode438 {

    /**
     * 思路：典型的滑动窗口。 对于没有接触滑动窗口来说会想到
     * 1. 用 List 的 contains 接口
     * 2. 用 排列组合保存 p 的所有排列
     * 这两种方法都是 O(N^2)
     * 而滑动窗口是 O(N)，所以，O(N^2)的方法大概率应该是要超时的
     * 滑动窗口的算法，巧妙之处在于统计字母的频率，统计相同。这个非常重要，初次接触很难想到这个方法。
     *
     * 算法复杂度：O(N)
     * 空间复杂度：O(N)
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return Collections.emptyList();
        }
        int []target = new int[256];
        for (int pIndex = 0; pIndex < p.length(); pIndex++) {
            target[p.charAt(pIndex)]++;
        }
        int []src = new int[256];
        int left = 0;
        for (int right = 0; right < p.length(); right++) {
            src[s.charAt(right)]++;
        }
        if (isEqual(src, target)) {
            res.add(0);
        }
        for (int right = p.length(); right < s.length(); right++) {
            src[s.charAt(right)]++;
            left = right - p.length();
            src[s.charAt(left)]--;
            if (isEqual(src, target)) {
                res.add(left + 1);
            }
        }
        return res;
    }

    boolean isEqual(int[] src, int[] dst) {
        for (int index = 0; index < src.length; index++) {
            if (src[index] != dst[index]) {
                return false;
            }
        }
        return true;
    }
}
