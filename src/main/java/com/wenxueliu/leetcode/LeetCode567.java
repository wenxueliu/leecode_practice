package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2020/01/16 23:14
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode567
 * @modifiedBy ：
 */
public class LeetCode567 {

    /**
     * 思路：计算字符出现的频率
     * 实现：掌握思路，本地不难的。
     * 算法复杂度：O(N1 * N2)
     * 空间复杂度：O(N1)
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        int s1Len = s1.length();
        int s2Len = s2.length();
        if (s1Len > s2Len) {
            return false;
        }

        int []s1Map = buildMap(s1);
        int []subS2Map = buildMap(s2.substring(0, s1.length()));
        if (isMapEqual(s1Map, subS2Map)) {
            return true;
        }
        for (int index = s1Len; index < s2Len; index++) {
            subS2Map[s2.charAt(index - s1Len)]--;
            subS2Map[s2.charAt(index)]++;
            if (isMapEqual(s1Map, subS2Map)) {
                return true;
            }
        }
        return false;
    }

    private int[] buildMap(String str) {
        int []map = new int[256];
        for (int index = 0; index < str.length(); index++) {
            map[str.charAt(index)]++;
        }
        return map;
    }

    private boolean isMapEqual(int[] src, int[] dst) {
        for (int index = 0; index < src.length; index++) {
            if (src[index] != dst[index]) {
                return false;
            }
        }
        return true;
    }


    /**
     * 有问题，但是找不到原因。
     * 算法复杂度：O(N1 * N2)
     * 空间复杂度：O(N1)
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion1(String s1, String s2) {
        int charNumber = 256;
        if (s1 == null || s2 == null) {
            return false;
        }
        int s1Len = s1.length();
        int s2Len = s2.length();
        if (s1Len > s2Len) {
            return false;
        }

        int []s1Map = buildMap(s1);
        int []subS2Map = buildMap(s2.substring(0, s1.length()));
        int count = 0;
        for (int index = 0; index < charNumber; index++) {
            if (s1Map[index] == subS2Map[index]) {
                count++;
            }
        }
        if (count == charNumber) {
            return true;
        }
        for (int index = s1Len; index < s2Len; index++) {
            char deleteChar = s2.charAt(index - s1Len);
            subS2Map[deleteChar]--;
            char addChar = s2.charAt(index);
            subS2Map[addChar]++;
            // 相等变为不等
            if (subS2Map[deleteChar] + 1 == s1Map[deleteChar]) {
                count--;
            } else if (subS2Map[deleteChar] == s1Map[deleteChar]) {
                // 不等变为相等
                count++;
            }
            // 相等变为不等
            if (subS2Map[addChar] - 1 == s1Map[addChar]) {
                count--;
            } else if (subS2Map[addChar] == s1Map[addChar]) {
                // 不等变为相等
                count++;
            }
            if (count == charNumber) {
                return true;
            }
        }
        return false;
    }
}
