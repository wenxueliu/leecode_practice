package com.wenxueliu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
* @author liuwenxue
* @date 2020-05-26
*/
public class LeetCode107 {
    /**
     * 思路：每次遍历，之后翻转即可
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
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
                current.add(node.val);
            }
            lastRow.clear();
            lastRow.addAll(row);
            res.add(0, current);
        }
        return res;
    }
}
