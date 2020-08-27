package com.wenxueliu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
* @author liuwenxue
* @date 2020-05-28
*/
public class LeetCode40 {
    /**
     * 标准模板解法
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visit = new boolean[candidates.length];
        dfs(candidates, 0, target, visit, tmp, res);
        return res;
    }

    void dfs(int[] candidates, int startIndex, int target, boolean[] visit, List<Integer> tmp, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            List<Integer> t = new ArrayList<>(tmp);
            Collections.sort(t);
            if (!res.contains(t)) {
                res.add(t);
            }
            return;
        }
        for (int index = startIndex; index < candidates.length; index++) {
            if (visit[index]) {
                continue;
            }
            visit[index] = true;
            target -= candidates[index];
            tmp.add(candidates[index]);
            dfs(candidates, 0, target, visit, tmp, res);
            visit[index] = false;
            target += candidates[index];
            tmp.remove(tmp.size() - 1);
        }
    }

    /**
     *  对解法优化
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum22(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        dfs2(0, target, candidates, path, res);
        return res;
    }

    public void dfs2(int starIndex, int target, int[] candidates, List<Integer> path, List<List<Integer>> res) {
        int len = candidates.length;
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int index = starIndex; index < len; index++) {
            if (target  - candidates[index] < 0) {
                break;
            }
            // 重复元素的条件
            if (index > starIndex && candidates[index] == candidates[index-1]) {
                continue;
            }
            int val = candidates[index];
            path.add(val);
            dfs2(index+1, target - val, candidates, path, res);
            path.remove(path.size()-1);
        }
    }
}
