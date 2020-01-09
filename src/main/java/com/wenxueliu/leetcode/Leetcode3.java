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

    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>(256);
        int maxLen = 0;
        int start = 0;
        for (int index = 0; index < s.length(); index++) {
            if (map.containsKey(s.charAt(index))) {
                /**
                 * 这是关键，考虑 abba 的情况。
                 */
                start = Math.max(map.get(s.charAt(index)) + 1, start);
            }
            map.put(s.charAt(index), index);
            maxLen = Math.max(index - start + 1, maxLen);
        }
        return maxLen;
    }

    /**
     * 思路与上面一致，重复利用字符范围的特性。极大提高时间
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        if (s == null) {
            return 0;
        }
        int []map = new int[128];
        for (int i = 0; i < 128; i++) {
            map[i] = -1;
        }
        int maxLen = 0;
        int start = 0;
        for (int index = 0; index < s.length(); index++) {
            start = Math.max(map[s.charAt(index)] == -1 ? 0 : map[s.charAt(index)]+1, start);
            map[s.charAt(index)] =  index;
            maxLen = Math.max(index - start + 1, maxLen);
        }
        return maxLen;
    }


    /**
     * 这个解法看似和上面的解法一样，写正确却很难。通过每个字符实际索引加 1， 减少了冗余代码，但实现难度加大
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s == null) {
            return 0;
        }
        int []map = new int[128];
        int maxLen = 0;
        int start = 0;
        for (int index = 0; index < s.length(); index++) {
            start = Math.max(map[s.charAt(index)], start);
            // 核心在这里，这一定要为 index + 1。默认每个元素的索引加 1，避免了初始化每个元素为 -1
            map[s.charAt(index)] =  index + 1;
            maxLen = Math.max(index - start + 1, maxLen);
        }
        return maxLen;
    }
}
