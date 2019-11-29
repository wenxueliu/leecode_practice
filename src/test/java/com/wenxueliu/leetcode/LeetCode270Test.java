package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode270Test {

    @Test
    public void closestValue() {
        test0();
        test1();
    }

    void test0() {
        LeetCode270 leetCode270 = new LeetCode270();
        TreeNode root = new TreeNode(0);
        Assert.assertEquals(0, leetCode270.closestValue(root, 2147483648.0));
    }

    void test1() {
        LeetCode270 leetCode270 = new LeetCode270();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        Assert.assertEquals(3, leetCode270.closestValue(root, 3.2));
    }
}