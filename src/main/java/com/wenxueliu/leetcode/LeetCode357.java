package com.wenxueliu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuwenxue
 * @date 2020-08-28
 */
public class LeetCode357 {
    int count = 0;

    public int countNumbersWithUniqueDigits(int n) {
        List<Integer> list = new ArrayList<>();
        dfs(0, n, list);
        return count + 1;
    }

    void dfs(int depth, int n, List<Integer> list) {
        if (!list.isEmpty()) {
            count++;
        }
        if (depth == n) {
            return;
        }
        for (int index = depth == 0 ? 1 : 0; index <= 9; index++) {
            if (list.contains(index)) {
                continue;
            }
            list.add(index);
            dfs(depth + 1, n, list);
            list.remove(list.size() - 1);
        }
    }
}
