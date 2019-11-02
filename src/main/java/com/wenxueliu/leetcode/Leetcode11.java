package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/10/31 23:44
 * @description : container-with-most-water
 * @path : com.wenxueliu.leetcode.Leetcode11
 * @modifiedBy ：
 *
 * Refer: https://leetcode-cn.com/problems/container-with-most-water/
 *
 * 10-31
 * 思路： 双层循环，暴力法
 * 实现： 5 分钟
 *
 * 解法2：
 * 参考其他人解题思路, 独立完成, 10 分钟
 *
 * 备注：该题较为简单，无需复习
 */
public class Leetcode11 {

    // 两层循环，暴力法
    public int maxArea(int[] height) {
        int len = height.length;
        int capicity = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int cap =  min(height[i], height[j]) * (j - i);
                capicity = capicity > cap ? capicity : cap;
            }
        }
        return capicity;
    }

    int min(int m, int n) {
        return m > n ? n : m;
    }

    /*
     * 解法2：
     * 参考其他人解题思路, 独立完成
     */
    public int maxArea2(int[] height) {
        int capicity = 0;
        int right = height.length - 1;
        int left = 0;
        while (right > left) {
            if (height[left] > height[right]) {
                int cap = height[right] * (right - left);
                capicity = capicity > cap ? capicity : cap;
                right--;
            } else {
                int cap = height[left] * (right - left);
                capicity = capicity > cap ? capicity : cap;
                left++;
            }
        }
        return capicity;
    }


}
