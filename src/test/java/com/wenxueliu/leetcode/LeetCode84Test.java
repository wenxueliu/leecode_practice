package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode84Test {

    @Test
    public void largestRectangleArea() {
        LeetCode84 leetCode84 = new LeetCode84();
        Assert.assertEquals(6, leetCode84.largestRectangleArea(new int []{1, 1, 1, 1, 1, 1}));
        Assert.assertEquals(12, leetCode84.largestRectangleArea(new int []{1, 2, 3, 4, 5, 6}));
        Assert.assertEquals(15, leetCode84.largestRectangleArea(new int []{1, 2, 7, 8, 5, 3}));
    }
}