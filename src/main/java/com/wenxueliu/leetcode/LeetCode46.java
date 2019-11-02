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
}
