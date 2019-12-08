package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode1167Test {

    @Test
    public void connectSticks() {
        LeetCode1167 leetCode1167 = new LeetCode1167();
        Assert.assertEquals(0, leetCode1167.connectSticks(new int[]{1}));
        Assert.assertEquals(0, leetCode1167.connectSticks(new int[]{5}));
        Assert.assertEquals(3, leetCode1167.connectSticks(new int[]{1, 2}));
        Assert.assertEquals(14, leetCode1167.connectSticks(new int[]{2, 4, 3}));
        Assert.assertEquals(30, leetCode1167.connectSticks(new int[]{1, 8, 3, 5}));
        Assert.assertEquals(87, leetCode1167.connectSticks(new int[]{1, 8, 3, 9, 11, 5}));
    }
}