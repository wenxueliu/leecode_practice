package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode123Test {

    @Test
    public void maxProfit() {
        LeetCode123 leetCode123 = new LeetCode123();
        Assert.assertEquals(6, leetCode123.maxProfit(new int[]{3,3,5,0,0,3,1,4}));
        Assert.assertEquals(4, leetCode123.maxProfit(new int[]{1, 2, 3, 4, 5}));
        Assert.assertEquals(1, leetCode123.maxProfit(new int[]{1, 2}));
    }
}