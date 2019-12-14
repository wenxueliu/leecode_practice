package com.wenxueliu.leetcode;

import java.util.*;

/**
 * @author ： liuwenxue
 * @date ：2019/12/14 22:10
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode139
 * @modifiedBy ：
 */
public class LeetCode139 {



    /**
     * 思路：依次遍历 s，检查 s 是否以 wordDict 中某个字符串开始。
     * 实现：超时了。由于有大量的重复，可以采用剪枝法。
     * 算法复杂度：O(N^2)
     * 空间复杂度：O(N)
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean isBreak = false;
        Queue<Integer> startIndexes = isStartWith(s, 0, wordDict);
        Set<Integer> visited = new HashSet<>();
        while (!startIndexes.isEmpty()) {
            int startIndex = startIndexes.poll();
            if (visited.contains(startIndex)) {
                continue;
            } else {
                visited.add(startIndex);
            }

            if (startIndex == s.length()) {
                isBreak = true;
                break;
            }
            startIndexes.addAll(isStartWith(s, startIndex, wordDict));
        }
        return isBreak;
    }

    Queue<Integer> isStartWith(String s, int startIndex, List<String> wordDict) {
        Queue<Integer> startIndexes = new LinkedList<>();
        for (String word : wordDict) {
            if (s.substring(startIndex).startsWith(word)) {
                startIndexes.add(startIndex + word.length());

            }
        }
        return startIndexes;
    }

    /**
     * 方法二，每次以 i 来记录，以当前字符结尾的子串是否可以分解
     */
    public boolean wordBreak1(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
