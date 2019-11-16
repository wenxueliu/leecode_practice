package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode70Test {

    @Test
    public void climbStairs() {
        LeetCode70 leetCode70 = new LeetCode70();
        Assert.assertEquals(1, leetCode70.climbStairs(1));
        Assert.assertEquals(2, leetCode70.climbStairs(2));
        Assert.assertEquals(89, leetCode70.climbStairs(10));
    }
}