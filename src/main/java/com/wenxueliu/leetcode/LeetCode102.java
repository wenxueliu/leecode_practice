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
        List<TreeNode> curLevel = new ArrayList<>();
        curLevel.add(root);
        int depth = 0;
        List<TreeNode> nextLevel = new ArrayList<>();
        while (!curLevel.isEmpty()) {
            //遍历拿到当前层元素
            nextLevel.clear();
            for (TreeNode node : curLevel) {
                nextLevel.add(node);
                if (res.size() <= depth) {
                    List<Integer> oneLevel = new ArrayList<>();
                    oneLevel.add(node.val);
                    res.add(oneLevel);
                } else {
                    res.get(depth).add(node.val);
                }
            }
            //添加下一层元素
            curLevel.clear();
            for (TreeNode node : nextLevel) {
                if (node.left != null) {
                    curLevel.add(node.left);
                }
                if (node.right != null) {
                    curLevel.add(node.right);
                }
            }
            depth = depth + 1;
        }
        return res;
    }
}
