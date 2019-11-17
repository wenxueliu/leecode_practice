package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode265Test {

    @Test
    public void minCostII() {
        LeetCode265 leetCode265 = new LeetCode265();
        Assert.assertEquals(0, leetCode265.minCostII(new int[][]{}));
        Assert.assertEquals(1, leetCode265.minCostII(new int[][]{{1}}));
        Assert.assertEquals(5, leetCode265.minCostII(new int[][]{{1,5,3},{2,9,4}}));
    }
}