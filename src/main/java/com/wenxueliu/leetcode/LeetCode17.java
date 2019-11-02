package com.wenxueliu.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ： liuwenxue
 * @date ：2019/11/01 01:10
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode17
 * @modifiedBy ：
 *
 * 10-30
 * 思路：之前看过解法，但是这里基本是自己的思路
 * 实现：所有组合使用递归。
 *     1. 解法1：recursive 没有预分配空间的，提交后超出内存限制
 *     2. 解法2; recursive2 预分配空间, 击败 98.88%
 * 用时 1 小时左右
 */
public class LeetCode17 {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return Collections.emptyList();
        }
        String[] digit2str = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int len = digits.length();
        String[] strArray = new String[len];
        int resultSize = 1;
        for (int i = 0; i < len; i++) {
            int digit = digits.charAt(i) - '0';
            String str = digit2str[digit];
            resultSize *= str.length();
            strArray[i] = str;
        }
        List<String> results = new ArrayList<String>(resultSize);
        recursive2(strArray, results);
        return results;
        //提交后，内存不够错误
        //return recursive(strArray, 0);
    }

    //提交后，内存不够错误
    List<String> recursive(String[] strArray, int index) {
        if (index == strArray.length - 1) {
            List<String> result = new ArrayList<String>();
            for (int i = 0; i < strArray[index].length(); i++) {
                result.add(String.valueOf(strArray[index].charAt(i)));
            }
            return result;
        }
        List<String> result = new ArrayList<String>();
        List<String> strs = recursive(strArray, index + 1);
        for (int i = 0; i < strArray[index].length(); i++) {
            for (String str : strs) {
                result.add(strArray[index].charAt(i) + str);
            }
        }
        return result;
    }

    void recursive2(String[] strArray, List<String> results) {
        for (int i = 0; i < strArray[0].length(); i++) {
            results.add(String.valueOf(strArray[0].charAt(i)));
        }
        recursive1(strArray, 1, results);
    }

    void recursive1(String[] strArray, int index, List<String> results) {
        if (index == strArray.length) {
            return;
        }
        List<String> result = new ArrayList<String>();
        for (String r : results) {
            for (int i = 0; i < strArray[index].length(); i++) {
                result.add(r + strArray[index].charAt(i));
            }
        }
        results.clear();
        results.addAll(result);
        recursive1(strArray, index + 1, results);
    }
}
