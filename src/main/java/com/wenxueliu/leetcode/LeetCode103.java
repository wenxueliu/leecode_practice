package com.wenxueliu.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
* @author liuwenxue
* @date 2020-02-19
*/
public class LeetCode103 {

    /**
     * 本题的难点在于翻转的方法，有点绕
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        boolean reverse = true;
        List<TreeNode> lastRow = new ArrayList<>();
        lastRow.add(root);
        while (!lastRow.isEmpty()) {
            List<TreeNode> row = new ArrayList<>();
            List<Integer> current = new ArrayList<>();
            for (int index = 0; index < lastRow.size(); index++) {
                TreeNode node = lastRow.get(index);
                if (node.left != null) {
                    row.add(node.left);
                }
                if (node.right != null) {
                    row.add(node.right);
                }
                if (reverse) {
                    current.add(node.val);
                } else {
                    current.add(0, node.val);
                }
            }
            reverse = !reverse;
            lastRow.clear();
            lastRow.addAll(row);
            res.add(current);
        }
        return res;
    }
}
