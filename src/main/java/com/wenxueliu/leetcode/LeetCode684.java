package com.wenxueliu.leetcode;

/**
 * @author liuwenxue
 * @date 2020-08-13
 */
public class LeetCode684 {
    /**
     * 思路：并查集 + 如果某个元素的两个节点已经处于并查集内了，那么就表明该节点导致出现环，可以删除
     * 好方啊，感觉结果不对，然而过了。
     * 用时：30 分钟（前提，复习了一把并查集的实现）
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     *
     * @param edges
     * @return
     */
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind unionFind = new UnionFind(edges.length + 1);
        int index = 0;
        for (; index < edges.length; index++) {
            int left = edges[index][0];
            int right = edges[index][1];
            if (unionFind.find(left) != unionFind.find(right)) {
                unionFind.union(left, right);
            } else {
                return edges[index];
            }
        }
        return edges[index];
    }

    class UnionFind {
        int[] parent;
        int size;

        UnionFind(int size) {
            this.parent = new int[size];
            for (int index = 0; index < size; index++) {
                parent[index] = index;
            }
        }

        int find(int ele) {
            int x = ele;
            while (x != parent[x]) {
                x = parent[x];
            }
            int cur = ele;
            int next;
            // 路径压缩
            while (cur != x) {
                next = parent[cur];
                parent[cur] = x;
                cur = next;
            }
            return x;
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rootX >= rootY) {
                    parent[rootY] = rootX;
                } else {
                    parent[rootX] = rootY;
                }
            }
        }
    }
}
