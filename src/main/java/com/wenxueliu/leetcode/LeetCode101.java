package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/11/10 01:43
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode101
 * @modifiedBy ：
 */
public class LeetCode101 {
    /**
     * 思路：递归，
     * 实现：
     * 1. 左子树的左子节点与右子数右子节点对称，同理左子树的右子节点与右子数左子节点对称，
     * 2. 结束条件
     * 用时：20 分钟，递归中算比较难的了。
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        } else if (leftNode == null && rightNode != null) {
            return false;
        } else if (leftNode != null && rightNode == null) {
            return false;
        } else {
            if (leftNode.val != rightNode.val) {
                return false;
            }
        }
        return isSymmetric(leftNode.left, rightNode.right) &&
                isSymmetric(leftNode.right, rightNode.left);
    }

    public boolean isSymmetric1(TreeNode root) {
        return false;
    }
}
