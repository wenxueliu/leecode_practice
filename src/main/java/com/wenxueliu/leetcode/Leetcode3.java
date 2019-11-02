package com.wenxueliu.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ： liuwenxue
 * @date ：2019/10/30 23:07
 * @description :
 * @path : com.wenxueliu.leetcode.Leetcode3
 * @modifiedBy ：
 *
 * longest-substring-without-repeating-characters
 *
 * 10-30
 * 思路：没有思路，通过 Map 可以解决一部分问题
 * 实现：
 *
 * aabced
 * aabccd
 */
public class Leetcode3 {

    //仅仅击败了 8%
    public int lengthOfLongestSubstring(String s) {
        List<Integer> target = new ArrayList<>();
        List<Integer> source = StringToList(s);
        int index = 0;
        while (index < source.size()) {
            List<Integer> tmpTarget = new ArrayList<>();
            index = subSetOfNoDuplicated(source, index, tmpTarget);
            if (tmpTarget.size() > target.size()) {
                target = tmpTarget;
            }
        }
        return target.size();
    }

    private List<Integer> StringToList(String str) {
        List<Integer> strList = new ArrayList<>();
        for (char ch : str.toCharArray()) {
            strList.add(Integer.valueOf(ch));
        }
        return strList;
    }

    private int subSetOfNoDuplicated(final List<Integer> list, int startIndex, List<Integer> target) {
        int size = list.size();
        for (int index = startIndex; index < size; index++) {
            Integer ele = list.get(index);
            int indexOf = target.indexOf(ele);
            if (indexOf == -1) {
                target.add(ele);
            } else {
                return startIndex + indexOf + 1;
            }
        }
        return size;
    }


    //没有调通
    public int lengthOfLongestSubstring1(String s) {
        Map<String, List<Integer>> map = new HashMap<>();
        int length = s.length();

        // a 0 3
        // b 1 4 6 7
        // c 2 5
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (map.containsKey(String.valueOf(c))) {
                List<Integer> list = map.get(String.valueOf(c));
                list.add(i);
                map.put(String.valueOf(c), list);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(String.valueOf(c), list);
            }
        }

        int maxLen = 0;
        for (List<Integer> list : map.values()) {
            int len = maxLength(list);
            if (len > maxLen) {
                maxLen = len;
            }
        }

        int diffLen = 0;
        int maxLen2 = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (map.get(String.valueOf(c)).size() == 1) {
                maxLen2++;
            } else {

                diffLen = maxLen2 + 1 < diffLen ? diffLen : maxLen2 + 1;
                maxLen2 = 1;
            }
        }
        //diffLen = maxLen2 > diffLen ? maxLen2 : diffLen;
        return diffLen;
        //return maxLen > diffLen + 2 ? maxLen : diffLen + 2;
    }

    int maxLength(List<Integer> list) {
        if (list.size() == 1) {
            return 1;
        }
        int maxLen = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            int len = list.get(i+1) - list.get(i);
            if (len > maxLen) {
                maxLen = len;
            }
        }
        return maxLen;
    }
}
