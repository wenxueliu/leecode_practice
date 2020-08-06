package com.wenxueliu.leetcode;

import java.util.*;

/**
* @author liuwenxue
* @date 2020-08-06
*/
public class LeetCode763 {
    /**
     * 这道题很简单 30分钟
     * @param S
     * @return
     */
    public List<Integer> partitionLabels(String S) {
        if (S.isEmpty()) {
            return new ArrayList<>();
        }
        int []map = new int[26];
        Arrays.fill(map, 0);
        char[] chars = S.toCharArray();
        for (int index = 0; index < chars.length; index++) {
            int orginIndex = map[chars[index] - 'a'];
            map[chars[index] - 'a'] = orginIndex >= index ? orginIndex : index;
        }
        List<Integer> res = new ArrayList<>();
        int maxIndex = -1;
        int lastIndex = -1;
        for (int index = 0; index < chars.length; index++) {
            int ch = chars[index] - 'a';
            maxIndex = Math.max(map[ch], maxIndex);
            if (index == maxIndex) {
                res.add(maxIndex - lastIndex);
                lastIndex = maxIndex;
            }
        }
        return res;
    }
}
