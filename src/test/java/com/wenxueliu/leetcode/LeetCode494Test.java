package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode494Test {

    @Test
    public void findTargetSumWays() {
        LeetCode494 leetCode494 = new LeetCode494();
        Assert.assertEquals(5, leetCode494.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        Assert.assertEquals(2, leetCode494.findTargetSumWays(new int[]{1, 0}, 1));
    }
}