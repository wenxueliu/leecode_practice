package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/11/16 16:04
 * @description :
 * @path : com.wenxueliu.leetcode.Node
 * @modifiedBy ：
 */
public class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {val = _val;}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
}
