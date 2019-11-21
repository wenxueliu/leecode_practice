package com.wenxueliu.leetcode;

import java.util.*;

/**
 * @author ： liuwenxue
 * @date ：2019/11/21 23:49
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode323
 * @modifiedBy ：
 */
public class LeetCode323 {

    /**
     * 思路：深度遍历
     * 实现：
     * 1. 将数组构建节点之间的关系
     * 2. 深度遍历
     * 用时：2 小时，参考了答案，自己的思路有问题
     * @param n
     * @param edges
     * @return
     */
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> allNodeMap = buildNodeMap(edges);
        int res = 0;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (dfs(i, visited, allNodeMap)) {
                res++;
            }
        }
        return res;
    }

    boolean dfs(int index, Set<Integer> visited, Map<Integer, List<Integer>> allNodes) {
        if (!visited.contains(index)) {
            visited.add(index);
            if (allNodes.containsKey(index)) {
                for (int subIndex : allNodes.get(index)) {
                    dfs(subIndex, visited, allNodes);
                }
            }
            return true;
        }
        return false;
    }


    /**
     * 思路：深度遍历
     * 实现：
     * 1. 将数组构建节点之间的关系
     * 2. 深度遍历
     * @param n
     * @param edges
     * @return
     */
    public int countComponents1(int n, int[][] edges) {
        Map<Integer, List<Integer>> allNodeMap = buildNodeMap(edges);
        return bfs(n, allNodeMap);
    }

    int bfs(int n, Map<Integer, List<Integer>> allNodes) {
        int res = 0;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (visited.contains(i)) {
                continue;
            }
            res++;
            queue.add(i);
            while (!queue.isEmpty()) {
                Integer element = queue.poll();
                visited.add(element);
                if (allNodes.containsKey(element)) {
                    for (Integer subElement : allNodes.get(element)) {
                        if (!visited.contains(subElement)) {
                            queue.add(subElement);
                        }

                    }
                }
            }
        }
        return res;
    }

    private Map<Integer, List<Integer>> buildNodeMap(int[][] edges) {
        Map<Integer, List<Integer>> allNodeMap = new HashMap<>();
        int rowNum = edges.length;
        for (int rowIndex = 0; rowIndex < rowNum; rowIndex++) {
            if (allNodeMap.containsKey(edges[rowIndex][0])) {
                allNodeMap.get(edges[rowIndex][0]).add(edges[rowIndex][1]);
            } else {
                allNodeMap.put(edges[rowIndex][0], new ArrayList<>());
                allNodeMap.get(edges[rowIndex][0]).add(edges[rowIndex][1]);
            }
            if (allNodeMap.containsKey(edges[rowIndex][1])) {
                allNodeMap.get(edges[rowIndex][1]).add(edges[rowIndex][0]);
            } else {
                allNodeMap.put(edges[rowIndex][1], new ArrayList<>());
                allNodeMap.get(edges[rowIndex][1]).add(edges[rowIndex][0]);
            }
        }
        return allNodeMap;
    }
}

