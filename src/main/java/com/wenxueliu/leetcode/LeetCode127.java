package com.wenxueliu.leetcode;/**
* @author liuwenxue
* @date 2020-05-07
*/
public class LeetCode127 {

    public int sumNumbers(TreeNode root) {
        int sum = 0;
        return dfs(root, sum);
    }

    int dfs(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        if (node.left != null || node.right != null) {
            return dfs(node.left, sum * 10 + node.val) + dfs(node.right, sum * 10 + node.val);
        }
        return sum * 10 + node.val;
    }
}
