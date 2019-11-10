package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/11/10 01:22
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode104
 * @modifiedBy ：
 */
public class LeetCode104 {

    /**
     * 思路：递归思想
     * 实现：很简单
     * 用时：10 分钟
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        return nextDepth(root, 0);
    }

    public int nextDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        int leftDepth = nextDepth(root.left, depth+1);
        int rightDepth = nextDepth(root.right, depth+1);
        return leftDepth > rightDepth ? leftDepth : rightDepth;
    }
}
