package com.wenxueliu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ： liuwenxue
 * @date ：2019/12/01 19:11
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode484
 * @modifiedBy ：
 */
public class LeetCode484 {

    /**
     * 思路：遇到 I，元素之间增加到后面，遇到 D 元素增加到上一个值的前面
     * 实现：仅仅利用 List 的 API 即可
     * 算法复杂度：O(n)
     * 空间复杂度：O(n)
     * @param s
     * @return
     */
    public int[] findPermutation(String s) {
        if (s.length() == 0) {
            return new int[]{1};
        }
        List<Integer> result = new ArrayList<>();
        int []map = new int[s.length()+2];
        result.add(1);
        map[1] = 0;
        int count = 2;
        int insertIndex = 0;
        for (int index = 0; index < s.length(); index++) {
            char num = s.charAt(index);
            if (num == 'I') {
                result.add(count);
            }
            if (num == 'D') {
                result.add(result.indexOf(count-1), count);
            }
            count++;
        }
        int [] res = new int[result.size()];
        for (int index = 0; index < result.size(); index++) {
            res[index] = result.get(index);
        }
        return res;
    }
}
