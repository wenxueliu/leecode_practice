package com.wenxueliu.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author ： liuwenxue
 * @date ：2019/10/25 22:05
 * @description :
 * @path : com.wenxueliu.leetcode.MaxSubList
 * @modifiedBy ：
 */
public class MaxSubList {

    public static void main(String[] args) {

        int[] nums = new int[] {2, 9, 3, 6, 5, 1,7};
        dump(findMaxSubList(nums));

    }

    static void dump(List<Integer> list) {
        for (Integer e : list) {
            System.out.println(e);
        }
    }

    static List<Integer> findMaxSubList(int nums[]) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> initSolution = new ArrayList<Integer>();
        initSolution.add(nums[0]);
        results.add(initSolution);
        for (int i = 1; i < nums.length; i++) {
            for (List<Integer> group : results) {
                if (nums[i] > group.get(group.size()-1)) {
                    List<Integer> oneSolution = new ArrayList<Integer>(group);
                    oneSolution.add(nums[i]);
                    merge(results, oneSolution);
                }
                List<Integer> selfSolution = new ArrayList<Integer>();
                selfSolution.add(nums[i]);
                merge(results, selfSolution);
            }
        }
        int max = 0;
        List<Integer> target = null;
        for (List<Integer> group : results) {
            if (group.size() > max) {
                max = group.size();
                target = group;
            }
        }
        return target;
    }

    static Integer lastValue(List<Integer> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("");
        }
        return list.get(list.size() - 1);
    }

    static void merge(List<List<Integer>> results, List<Integer> oneSolution) {
        for (List<Integer> group : results) {
            //最后一个值相同，而且还短，不加入oneSolution
            if (lastValue(oneSolution).intValue() == lastValue(group).intValue() && oneSolution.size() < group.size()) {
                return;
            }
            //是某个子串最大值加一，长度加一
            if (lastValue(oneSolution).intValue() == lastValue(group).intValue()+1 && oneSolution.size() == group.size()+1) {
                results.remove(group);
            }
            //最大值相同，长度更长，删除短的
            if (lastValue(oneSolution).intValue() == lastValue(group).intValue() && oneSolution.size() > group.size()) {
                results.remove(group);
                results.add(oneSolution);
            }
            //最大值小于等于，长度更长，删除短的
            if (lastValue(oneSolution).intValue() <= lastValue(group).intValue() && oneSolution.size() > group.size()) {
                results.remove(group);
                results.add(oneSolution);
            }
        }
        results.add(oneSolution);
    }
}
