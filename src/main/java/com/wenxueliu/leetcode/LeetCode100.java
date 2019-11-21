package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/11/21 22:56
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode100
 * @modifiedBy ：
 */
public class LeetCode100 {

    /**
     * 思路：树的遍历。两棵树同时遍历。
     * 实现：中序遍历、前序遍历、后序遍历均可
     * 用时：10 分钟
     * 时间：O(n) 空间 O(1)
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return travel(p, q);
    }

    boolean travel(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null && q != null) {
            return false;
        }
        if (p != null && q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        boolean leftEqual = travel(p.left, q.left);
        boolean rightEqual = travel(p.right, q.right);
        return leftEqual && rightEqual;
    }
}
