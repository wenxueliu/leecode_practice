package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/11/01 22:44
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode12
 * @modifiedBy ：
 *
 * Refer: https://leetcode-cn.com/problems/integer-to-roman/
 *
 * 11-01
 * 思路：这个算法很巧妙， 一般想不出来
 * 实现：思路确定，实现很简单，但是时间效率上只超过 95%，还有提升空间
 *
 */
public class LeetCode12 {
    public String intToRoman(int num) {
        String[] M = {"", "M", "MM", "MMM"};
        String[] D = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + D[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }
}
