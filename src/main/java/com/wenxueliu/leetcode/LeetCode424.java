package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2020/01/12 15:28
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode424
 * @modifiedBy ：
 */
public class LeetCode424 {

    /**
     * 思路：记录每个字母出现的次数。用滑动窗口记录，当前窗口内出现频率最高的字母 + k 如果大于窗口长度，就继续增加窗口，否则缩小窗口。
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        int maxLen = 0;
        int map[] = new int[26];
        int len = s.length();
        for (int startIndex = 0, endIndex = startIndex; startIndex < len; startIndex++) {
            while (endIndex < len ) {
                map[s.charAt(endIndex)-'A']++;
                if (maxCountAlpha(map) + k >= endIndex - startIndex + 1) {
                    maxLen = Math.max(maxLen, endIndex - startIndex + 1);
                    endIndex++;
                } else {
                    map[s.charAt(endIndex)-'A']--;
                    break;
                }
            }
            map[s.charAt(startIndex)-'A']--;
        }
        return maxLen;
    }

    int maxCountAlpha(int []map) {
        int maxLen = 0;
        for (int i = 0; i < map.length; i++) {
            maxLen = Math.max(map[i], maxLen);
        }
        return maxLen;
    }

    /**
     * 思路：保持最大窗口只增不减
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement1(String s, int k) {
        int maxLen = 0;
        int map[] = new int[26];
        int len = s.length();
        for (int startIndex = 0, endIndex = startIndex; startIndex < len; startIndex++) {
            while (endIndex < len ) {
                map[s.charAt(endIndex)-'A']++;
                if (maxCountAlpha(map) + k >= endIndex - startIndex + 1) {
                    maxLen = Math.max(maxLen, endIndex - startIndex + 1);
                    endIndex++;
                } else {
                    endIndex++;
                    break;
                }

            }
            map[s.charAt(startIndex)-'A']--;
        }
        return maxLen;
    }

    /**
     * 优化了map最大值计算
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement2(String s, int k) {
        int maxLen = 0;
        int map[] = new int[26];
        int len = s.length();
        int maxCount = 0;
        for (int startIndex = 0, endIndex = startIndex; startIndex < len; startIndex++) {
            while (endIndex < len ) {
                map[s.charAt(endIndex) - 'A']++;
                maxCount = Math.max(maxCount, map[s.charAt(endIndex) - 'A']);
                if (maxCount + k >= endIndex - startIndex + 1) {
                    maxLen = Math.max(maxLen, endIndex - startIndex + 1);
                    endIndex++;
                } else {
                    endIndex++;
                    break;
                }
            }
            map[s.charAt(startIndex)-'A']--;
        }
        return maxLen;
    }


    /**
     * 解法 2 提高一倍，时间超过 60%
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement3(String s, int k) {

        int result = 0;
        int maxCount = 0;
        int []count = new int[26];
        for (int right = 0, left = 0; right < s.length(); right++) {
            count[s.charAt(right)-'A']++;
            // 当前窗口内的最多字符的个数
            maxCount = Math.max(maxCount, count[s.charAt(right)-'A']);
            // 需要替换的字符个数就是当前窗口的大小减去窗口中数量最多的字符的数量
            while(k + maxCount < right-left+1){
                count[s.charAt(left)-'A']--;
                //缩小窗口
                left++;
            }
            // 当窗口内可替换的字符数小于等于k时，我们需要根据该窗口长度来确定是否更新result
            result = Math.max(result, right-left+1);
        }
        return result;
    }

    /**
     * 优化解法 3，从 8 ms 变为 6 ms。超过 90%
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement4(String s, int k) {
        int result = 0;
        int maxCount = 0;
        int []count = new int[26];
        for (int right = 0, left = 0; right < s.length(); right++) {
            // 当前窗口内的最多字符的个数
            maxCount = Math.max(maxCount, ++count[s.charAt(right)-'A']);
            // 需要替换的字符个数就是当前窗口的大小减去窗口中数量最多的字符的数量
            while(k + maxCount < right-left+1){
                count[s.charAt(left)-'A']--;
                //缩小窗口
                left++;
            }
            // 当窗口内可替换的字符数小于等于k时，我们需要根据该窗口长度来确定是否更新result
            result = Math.max(result, right-left+1);
        }
        return result;
    }
}
