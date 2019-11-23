package com.wenxueliu.leetcode;

import com.sun.javafx.geom.Edge;

import javax.swing.undo.CannotUndoException;
import java.util.*;

/**
 * @author ： liuwenxue
 * @date ：2019/11/23 12:36
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode1245
 * @modifiedBy ：
 *
 * 该题与 124 相似
 *
 * 给你这棵「无向树」，请你测算并返回它的「直径」：这棵树上最长简单路径的 边数。
 *
 * 我们用一个由所有「边」组成的数组 edges 来表示一棵无向树，其中 edges[i] = [u, v] 表示节点 u 和 v 之间的双向边。
 *
 * 树上的节点都已经用 {0, 1, ..., edges.length} 中的数做了标记，每个节点上的标记都是独一无二的。
 *
 * 示例 1：
 *
 * 输入：edges = [[0,1],[0,2]]
 * 输出：2
 * 解释：
 * 这棵树上最长的路径是 1 - 0 - 2，边数为 2。
 *
 * 示例 2：
 *
 * 输入：edges = [[0,1],[1,2],[2,3],[1,4],[4,5]]
 * 输出：4
 * 解释：
 * 这棵树上最长的路径是 3 - 2 - 1 - 4 - 5，边数为 4。
 *  
 *
 * 提示：
 *
 * 0 <= edges.length < 10^4
 * edges[i][0] != edges[i][1]
 * 0 <= edges[i][j] <= edges.length
 * edges 会形成一棵无向树
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/tree-diameter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode1245 {

    /**
     * 思路：以每个节点为头，计算最大长度
     * 实现：遍历每个节点，执行 BFS
     * 功能正确但是超时，思路还是有问题。我的思路是以每个节点为根节点，找到最长路径。显然是有很多冗余的。
     *
     * 官方答案思路是树的最大直径为
     * 1. 以某个节点，找到以该节点的最长路径
     * 2. 以 1 最长节点的尾节点，找到最长的路径，就是最大直径
     * @param edges
     * @return
     */
    public int treeDiameter(int[][] edges) {
        if (edges.length == 0) {
            return 0;
        }
        int len = edges.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(edges[i][0])) {
                map.get(edges[i][0]).add(edges[i][1]);
            } else {
                map.put(edges[i][0], new ArrayList());
                map.get(edges[i][0]).add(edges[i][1]);
            }
            if (map.containsKey(edges[i][1])) {
                map.get(edges[i][1]).add(edges[i][0]);
            } else {
                map.put(edges[i][1], new ArrayList());
                map.get(edges[i][1]).add(edges[i][0]);
            }
        }
        //解法一 BFS
        Node maxNode = getMaxLen(0, map);
        maxNode = getMaxLen(maxNode.val, map);
        return maxNode.step;

        /*
        //解法二 DFS，此解法结果错误， 暂且还没有找到原因
        Node maxNode = new Node(0, 0);
        dfs(0, -1, map, 0, maxNode);
        maxNode.step = 0;
        dfs(maxNode.val, -1, map, 0, maxNode);
        return maxNode.step;
         */
    }

    Node getMaxLen(int start, Map<Integer, List<Integer>> map) {
        Node maxNode = new Node(0, 0);
        Set<Integer> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start, 0));
        int maxStep = 0;
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            if (visited.contains(curNode.val)) {
                continue;
            }
            visited.add(curNode.val);
            List<Integer> nextNodes = map.get(curNode.val);

            for (int nextNode : nextNodes) {
                queue.add(new Node(nextNode, curNode.step + 1));
                maxStep = Math.max(maxStep, curNode.step + 1);
                maxNode = new Node(nextNode, maxStep);
            }
        }
        return maxNode;
    }

    void dfs(int start, int next, Map<Integer, List<Integer>> map, int depth, Node maxNode) {
        for (int nextNode : map.get(start)) {
            if (nextNode == next) {
                continue;
            }
            dfs(nextNode, start, map, depth + 1, maxNode);
        }
        if (depth > maxNode.val) {
            maxNode.step = depth;
            maxNode.val = start;
        }
    }

    class Node {
        int val;
        int step;

        Node(int val, int step) {
            this.val = val;
            this.step = step;
        }
    }


    public int treeDiameter1(int[][] edges) {
        List<Integer>[]q = new ArrayList[edges.length+1];
        for(int i = 0; i <= edges.length; i++) {
            q[i] = new ArrayList();
        }
        for(int i=0; i<edges.length; i++) {
            q[edges[i][0]].add(edges[i][1]);
            q[edges[i][1]].add(edges[i][0]);
        }
        Node node = new Node(0, 0);
        dfs(0, -1, 0, q, node);
        node.step = 0;
        dfs(node.val, -1, 0, q, node);
        return node.step;
    }

    private void dfs(int cur, int next, int sum, List<Integer>[]edges, Node node) {
        for (int i=0; i<edges[cur].size(); i++) {
            if (edges[cur].get(i) == next) {
                continue;
            }
            dfs(edges[cur].get(i),cur,sum+1, edges, node);
        }
        if (sum > node.step) {
            node.step = sum;
            node.val = cur;
        }
    }
}
