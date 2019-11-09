package com.wenxueliu.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author ： liuwenxue
 * @date ：2019/11/06 00:14
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode94
 * @modifiedBy ：
 */
public class LeetCode94 {


    /**
     * 思路：理解中序遍历概念及递归思想即可
     * 用时: 10 分钟
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }


    /**
     * 思路：理解中序遍历概念
     * 实现:
     * 1. 首先确保直到用栈保存临时数据
     * 2. 手动写前几个结果，然后提取公共结构
     * 用时：一个小时
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode iter = root;
        stack.push(iter);
        while (iter.left != null) {
            iter = iter.left;
            stack.push(iter);
        }

        while (stack.size() != 0) {
            iter = stack.pop();
            result.add(iter.val);
            if (iter.right != null) {
                iter = iter.right;
                stack.push(iter);
                while (iter.left != null) {
                    iter = iter.left;
                    stack.push(iter);
                }
            }
        }

        return result;
    }
}
