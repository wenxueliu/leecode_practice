package com.wenxueliu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ： liuwenxue
 * @date ：2019/11/10 09:55
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode102
 * @modifiedBy ：
 */
public class LeetCode102 {
    /**
     * 思路：递归并记录每层的深度，以深度作为索引
     * 实现： 略
     * 时间：10 分钟
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelTravel(root, 0, res);
        return res;
    }

    void levelTravel(TreeNode node, int depth, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        if (res.size() <= depth) {
            List<Integer> oneLevel = new ArrayList<>();
            oneLevel.add(node.val);
            res.add(oneLevel);
        } else {
            res.get(depth).add(node.val);
        }
        levelTravel(node.left, depth + 1, res);
        levelTravel(node.right, depth + 1, res);
    }

    /**
     * 思路：广度遍历
     * 实现：参考代码注释
     * 时间：20 分钟
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<TreeNode> stack = new ArrayList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            List<TreeNode> currentRow = new ArrayList<>();
            List<Integer> current = new ArrayList<>();
            for (int index = 0; index < stack.size(); index++) {
                TreeNode node = stack.get(index);
                if (node.left != null) {
                    currentRow.add(node.left);
                }
                if (node.right != null) {
                    currentRow.add(node.right);
                }
                current.add(node.val);
            }
            stack.clear();
            stack.addAll(currentRow);
            res.add(current);
        }
        return res;
    }
}
