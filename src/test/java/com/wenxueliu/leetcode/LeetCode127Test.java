package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode127Test {

    @Test
    public void sumNumbers() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        LeetCode127 leetCode127 = new LeetCode127();
        Assert.assertEquals(25, leetCode127.sumNumbers(root));
    }

    @Test
    public void sumNumbers1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        LeetCode127 leetCode127 = new LeetCode127();
        Assert.assertEquals(12, leetCode127.sumNumbers(root));
    }

    @Test
    public void sumNumbers2() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        LeetCode127 leetCode127 = new LeetCode127();
        Assert.assertEquals(12, leetCode127.sumNumbers(root));
    }

    @Test
    public void sumNumbers3() {
        TreeNode root = new TreeNode(4);
        root.right = new TreeNode(0);
        root.left = new TreeNode(9);
        TreeNode rootLeft = root.left;
        rootLeft.left = new TreeNode(5);
        rootLeft.right = new TreeNode(1);
        LeetCode127 leetCode127 = new LeetCode127();
        Assert.assertEquals(1026, leetCode127.sumNumbers(root));
    }
}