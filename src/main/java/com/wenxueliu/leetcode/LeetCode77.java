package com.wenxueliu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
* @author liuwenxue
* @date 2020-05-29
*/
public class LeetCode77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int[] nums = new int[n];
        for (int index = 0; index < n; index++) {
            nums[index] = index + 1;
        }
        dfs(0, k, nums, path, res);
        return res;
    }

    void dfs(int depth, int k, int[] nums, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int index = depth; index < nums.length; index++) {
            path.add(nums[index]);
            dfs( index + 1, k, nums, path, res);
            path.remove(path.size()-1);
        }
    }
}
