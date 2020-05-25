package com.wenxueliu.leetcode;/**
* @author liuwenxue
* @date 2020-05-25
*/
public class UnionFind {

    int []parent;
    int count;

    UnionFind(int num) {
        count = num;
        parent = new int[num];
        for (int index = 0; index < num; index++) {
            parent[index] = index;
        }
    }

    void union(int lvalue, int rvalue) {
        int left = find(lvalue);
        int right = find(rvalue);
        if (left != right) {
            count--;
            parent[right] = left;
        }
    }

    // 1,2  2,3  3,3
    //
    int find(int value) {
        while (parent[value] != value) {
            value = parent[parent[value]];
        }
        return parent[value];
    }

    boolean isConnect(int left, int right) {
        return find(left) == find(right);
    }
}
