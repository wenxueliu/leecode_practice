package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode121Test {

    @Test
    public void maxProfit() {
        LeetCode121 leetCode121 = new LeetCode121();
        Assert.assertEquals(leetCode121.maxProfit(new int[] {7,1,5,3,6,4}), 5);
        Assert.assertEquals(leetCode121.maxProfit(new int[] {7,6,4,3,1}), 0);
    }
}