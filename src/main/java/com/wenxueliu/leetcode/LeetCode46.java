package com.wenxueliu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ： liuwenxue
 * @date ：2019/11/02 10:35
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode46
 * @modifiedBy ：
 */
public class LeetCode46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> srcArray = new ArrayList<List<Integer>>();
        srcArray.add(new ArrayList<Integer>());
        List<List<Integer>> dstArray = new ArrayList<List<Integer>>();
        for (int e : nums) {
            srcArray = solution(srcArray, e);
        }
        return srcArray;
    }

    public List<List<Integer>> solution(List<List<Integer>> srcArray, int newElem) {
        List<List<Integer>> dstArray = new ArrayList<List<Integer>>();
        for (List<Integer> e : srcArray) {
            List<List<Integer>> elem = addNewToOneElem(e, newElem);
            dstArray.addAll(elem);
        }
        return dstArray;
    }

    public List<List<Integer>> addNewToOneElem(List<Integer> srcArray, int elem) {
        int newSize = srcArray.size() + 1;
        List<List<Integer>> dstArray = new ArrayList<List<Integer>>(newSize);
        for (int i = 0; i < newSize; i++) {
            List<Integer> newElem = new ArrayList<Integer>(srcArray);
            newElem.add(i, elem);
            dstArray.add(newElem);
        }
        return dstArray;
    }

    /**
     * 分析参考
     * https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
     * @param nums
     * @return
     */
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean []visited = new boolean[nums.length];
        dfs(0, nums, path, res, visited);
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
            visited[index] = true;
            path.add(nums[index]);
            dfs(depth + 1, nums, path, res, visited);
            path.remove(path.size()-1);
            visited[index] = false;
        }
    }
}
