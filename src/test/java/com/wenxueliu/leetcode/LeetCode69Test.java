package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode69Test {

    @Test
    public void mySqrt() {
        LeetCode69 leetCode69 = new LeetCode69();
        Assert.assertEquals(0, leetCode69.mySqrt(0));
        Assert.assertEquals(1, leetCode69.mySqrt(1));
        Assert.assertEquals(1, leetCode69.mySqrt(2));
        Assert.assertEquals(1, leetCode69.mySqrt(3));
        Assert.assertEquals(2, leetCode69.mySqrt(4));
        Assert.assertEquals(2, leetCode69.mySqrt(5));
        Assert.assertEquals(2, leetCode69.mySqrt(8));
        Assert.assertEquals(3, leetCode69.mySqrt(9));
        Assert.assertEquals(46339, leetCode69.mySqrt(2147395599));
    }
}