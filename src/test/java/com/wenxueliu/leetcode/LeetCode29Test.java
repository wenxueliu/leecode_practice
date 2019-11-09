package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode29Test {

    @Test
    public void divide() {
        LeetCode29 leetCode29 = new LeetCode29();
        Assert.assertEquals(leetCode29.divide(2147483647, 1), 2147483647);
        Assert.assertEquals(leetCode29.divide(Integer.MIN_VALUE, 1), Integer.MIN_VALUE);
        Assert.assertEquals(leetCode29.divide(0, 1), 0);
        Assert.assertEquals(leetCode29.divide(Integer.MAX_VALUE, 1), Integer.MAX_VALUE);
        Assert.assertEquals(leetCode29.divide(Integer.MIN_VALUE, -1), Integer.MAX_VALUE);
        Assert.assertEquals(leetCode29.divide(Integer.MAX_VALUE, -1), -Integer.MAX_VALUE);
        Assert.assertEquals(leetCode29.divide(5, 2), 2);
        Assert.assertEquals(leetCode29.divide(-5, 2), -2);
        Assert.assertEquals(leetCode29.divide(5, -2), -2);
        Assert.assertEquals(leetCode29.divide(-5, -2), 2);
        Assert.assertEquals(leetCode29.divide( 6, 2), 3);
        Assert.assertEquals(leetCode29.divide( -6, 2), -3);
        Assert.assertEquals(leetCode29.divide( 6, -2), -3);
        Assert.assertEquals(leetCode29.divide( -6, -2), 3);
        Assert.assertEquals(leetCode29.divide( 2147483647, -2), -1073741823);
        Assert.assertEquals(leetCode29.divide( -2147483647, -2), 1073741823);
        Assert.assertEquals(leetCode29.divide( -2147483648, -2147483648), 1);


    }
}