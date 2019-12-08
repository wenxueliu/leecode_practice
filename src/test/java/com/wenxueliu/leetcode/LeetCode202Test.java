package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode202Test {

    @Test
    public void isHappy() {
        LeetCode202 leetCode202 = new LeetCode202();
        Assert.assertEquals(true, leetCode202.isHappy(1));
        Assert.assertEquals(true, leetCode202.isHappy(19));
        Assert.assertEquals(false, leetCode202.isHappy(0));
        Assert.assertEquals(true, leetCode202.isHappy(10));
        Assert.assertEquals(false, leetCode202.isHappy(12));

        Assert.assertEquals(true, leetCode202.isHappy1(1));
        Assert.assertEquals(true, leetCode202.isHappy1(19));
        Assert.assertEquals(false, leetCode202.isHappy1(0));
        Assert.assertEquals(true, leetCode202.isHappy1(10));
        Assert.assertEquals(false, leetCode202.isHappy1(12));
    }
}