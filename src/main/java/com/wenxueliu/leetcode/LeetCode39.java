package com.wenxueliu.leetcode;

import java.util.ArrayList;
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
     * 解法一：递增模板
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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

    /**
     * 解法二：递减模板
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs1(0, target, candidates, list, res);
        return res;
    }

    public void dfs1(int starIndex, int target, int[] candidates, List<Integer> list, List<List<Integer>> res) {
        int len = candidates.length;
        for (int index = starIndex; index < len; index++) {
            int val = candidates[index];
            list.add(val);
            target -= val;
            if (target < 0) {
                list.remove(list.size()-1);
                target += val;
                continue;
            }
            if (target == 0) {
                res.add(new ArrayList<>(list));
                list.remove(list.size()-1);
                target += val;
                continue;
            }
            dfs1(index, target, candidates, list, res);
            list.remove(list.size()-1);
            target += val;
        }
    }

    /**
     * 解法三：解法二的简化版
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs2(0, target, candidates, list, res);
        return res;
    }

    public void dfs2(int starIndex, int target, int[] candidates, List<Integer> list, List<List<Integer>> res) {
        int len = candidates.length;
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int index = starIndex; index < len; index++) {
            int val = candidates[index];
            list.add(val);
            dfs2(index, target - val, candidates, list, res);
            list.remove(list.size()-1);
        }
    }
}
