package com.wenxueliu.leetcode;

import java.util.*;

/**
 * @author ： liuwenxue
 * @date ：2019/11/23 09:47
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode1197
 * @modifiedBy ：
 */
public class LeetCode1197 {

    public int minKnightMoves(int x, int y) {
        return travel(x, y);
    }


    /**
     * 第一版，BFS 近距离的可以工作，稍微远一点就不行了，时间超时
     * @param targetX
     * @param targetY
     * @return
     */
    int travel0(int targetX, int targetY) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 0, 0));
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            if (isMatch(curNode, targetX, targetY)) {
                return curNode.step;
            }
            for (Node node : getNextNodes(curNode)) {
                queue.offer(node);
            }
        }
        return Integer.MAX_VALUE;
    }

    private Node[] getNextNodes(Node curNode) {
        int [][]allPosition = new int[][] {{-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {-2, -1}, {-2, 1}, {2, -1}, {2, 1}};
        Node[] nodes = new Node[allPosition.length];
        for (int row = 0; row < allPosition.length; row++) {
            int curX = curNode.x + allPosition[row][0];
            int curY = curNode.y + allPosition[row][1];
            Node node = new Node(curX, curY, 0, curNode.step + 1);
            nodes[row] = node;
        }
        return nodes;
    }

    /**
     * 第二版，BFS 增加去重，结果超过 10%
     * @param targetX
     * @param targetY
     * @return
     */
    int travel1(int targetX, int targetY) {
        Set<Integer> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 0, 0));

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            if (isMatch(curNode, targetX, targetY)) {
                return curNode.step;
            }
            //去重，已经访问过的节点不再访问，这里不能用 equals 来判断，否则会超时
            if (visited.contains(curNode.x * 1000 + curNode.y)) {
                continue;
            }
            visited.add(curNode.x * 1000 + curNode.y);
            for (Node node : getNextNodes(curNode)) {
                queue.offer(node);
            }
        }
        return Integer.MAX_VALUE;
    }

    int travel(int targetX, int targetY) {
        Set<Integer> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 0, 0));

        int [][]allPosition = new int[][] {{-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {-2, -1}, {-2, 1}, {2, -1}, {2, 1}};
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            if (isMatch(curNode, targetX, targetY)) {
                return curNode.step;
            }
            //去重，已经访问过的节点不再访问，这里不能用 equals 来判断，否则会超时
            if (visited.contains(curNode.x * 1000 + curNode.y)) {
                continue;
            }
            visited.add(curNode.x * 1000 + curNode.y);

            //剪枝，找到离目标最近的
            int minWeight = Integer.MAX_VALUE;
            Node []nodes = new Node[8];
            for (int row = 0; row < allPosition.length; row++) {
                int curX = curNode.x + allPosition[row][0];
                int curY = curNode.y + allPosition[row][1];

                Node node = new Node(curX, curY, curNode.step + getWeight(curX, curY, targetX, targetY), curNode.step + 1);
                nodes[row] = node;
                if (node.weight < minWeight) {
                    minWeight = node.weight;
                }
            }
            for (Node node : nodes) {
                if (node.weight == minWeight) {
                    queue.offer(node);
                }
            }

            /*
            //替代方法一，超时
            int minIndex = 0;
            Node[] nodes = getNextNodes(curNode, targetX, targetY);
            for (int i = 1; i < 8; i++) {
                if (nodes[minIndex].weight > nodes[i].weight) {
                    minIndex = i;
                }
            }
            queue.offer(nodes[minIndex]);

            //替代方法二，超时
            Node []nodes = getNextNodes(curNode, targetX, targetY);
            Arrays.sort(nodes, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.weight - o2.weight;
                }
            });
            queue.offer(nodes[0]);
            */
        }
        return Integer.MAX_VALUE;
    }

    boolean isMatch(Node node, int targetX, int targetY) {
        if (node.x == targetX && node.y == targetY) {
            return true;
        }
        return false;
    }


    private Node[] getNextNodes(Node curNode, int targetX, int targetY) {
        int [][]allPosition = new int[][] {{-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {-2, -1}, {-2, 1}, {2, -1}, {2, 1}};
        Node[] nodes = new Node[allPosition.length];
        for (int row = 0; row < allPosition.length; row++) {
            int curX = curNode.x + allPosition[row][0];
            int curY = curNode.y + allPosition[row][1];
            Node node = new Node(curX, curY, curNode.step + getWeight(curNode.x, curNode.y, targetX, targetY), curNode.step + 1);
            nodes[row] = node;
        }
        return nodes;
    }

    int getWeight(int x, int y, int targetX, int targetY) {
        if (Math.abs(x - targetX) <= 70 || Math.abs(y - targetY) <= 70) {
            return 0;
        }
        return Math.abs(x - targetX) + Math.abs(y - targetY);
    }

    class Node {
        int x;
        int y;
        int weight;
        int step;

        Node(int x, int y, int weight, int step) {
            this.x = x;
            this.y = y;
            this.weight = weight;
            this.step = step;
        }
    }
}

