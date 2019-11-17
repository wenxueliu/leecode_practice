package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode256Test {

    @Test
    public void minCost() {
        LeetCode256 leetCode256 = new LeetCode256();
        Assert.assertEquals(leetCode256.minCost2(new int[][]{}), 0);
        Assert.assertEquals(leetCode256.minCost2(new int[][]{{17,2,17},{16,16,5},{14,3,19}}), 10);
    }
}