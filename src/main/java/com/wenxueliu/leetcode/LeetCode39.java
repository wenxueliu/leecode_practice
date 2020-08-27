package com.wenxueliu.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liuwenxue
 * @date 2020-05-27
 *
 * 分析参考这个链接，我遇到的问题和该题解几乎一模一样
 * https://leetcode-cn.com/problems/combination-sum/solution/fei-chang-xiang-xi-de-di-gui-hui-su-tao-lu-by-re-2/
*/
public class LeetCode39 {
    /**
     * 2020-08-27 第一个版本，刚过
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, 0, target, tmp, res);
        return res;
    }

    void dfs(int[] candidates, int depth, int target, List<Integer> tmp, List<List<Integer>> res) {
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
        for (int index = 0; index < candidates.length; index++) {
            target -= candidates[index];
            tmp.add(candidates[index]);
            dfs(candidates, depth + 1, target, tmp, res);
            target += candidates[index];
            tmp.remove(tmp.size() - 1);
        }
    }

    /**
     * 解法二： 增加剪枝
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, 0, 0, target, tmp, res);
        return res;
    }

    void dfs(int[] candidates, int startIndex, int depth, int target, List<Integer> tmp, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            List<Integer> t = new ArrayList<>(tmp);
            if (!res.contains(t)) {
                res.add(t);
            }
            return;
        }
        for (int index = startIndex; index < candidates.length; index++) {
            target -= candidates[index];
            tmp.add(candidates[index]);
            dfs(candidates, index, depth + 1, target, tmp, res);
            target += candidates[index];
            tmp.remove(tmp.size() - 1);
        }
    }

    /**
     * 解法三：递增模板
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(0, 0, target, candidates, list, res);
        return res;
    }

    public void dfs(int sum, int starIndex, int target, int[] candidates, List<Integer> list, List<List<Integer>> res) {
        int len = candidates.length;
        for (int index = starIndex; index < len; index++) {
            int val = candidates[index];
            list.add(val);
            sum += val;
            if (sum > target) {
                list.remove(list.size()-1);
                sum -= val;
                continue;
            }
            if (sum == target) {
                res.add(new ArrayList<>(list));
                list.remove(list.size()-1);
                sum -= val;
                continue;
            }
            dfs(sum, index, target, candidates, list, res);
            list.remove(list.size()-1);
            sum -= val;
        }
    }

}
