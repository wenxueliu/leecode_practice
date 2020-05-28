package com.wenxueliu.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* @author liuwenxue
* @date 2020-05-29
*/
public class LeetCode47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        boolean[] vistied = new boolean[nums.length];
        dfs(0, nums, path, res, vistied);
        return res;
    }

    void dfs(int depth, int[] nums, List<Integer> path, List<List<Integer>> res, boolean []visited) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int index = 0; index < nums.length; index++) {
            if (visited[index]) {
                continue;
            }
            // 与 46 唯一的变化点
            if (index > 0 && nums[index] == nums[index-1] && !visited[index-1]) {
                continue;
            }
            visited[index] = true;
            path.add(nums[index]);
            dfs(depth + 1, nums, path, res, visited);
            visited[index] = false;
            path.remove(path.size() - 1);
        }
    }
}
