package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode7Test {

    @Test
    public void reverse() {
        LeetCode7 leetCode7 = new LeetCode7();
        Assert.assertEquals(leetCode7.reverse(0), 0);
        Assert.assertEquals(leetCode7.reverse(-1), -1);
        Assert.assertEquals(leetCode7.reverse(1), 1);
        Assert.assertEquals(leetCode7.reverse(123), 321);
        Assert.assertEquals(leetCode7.reverse(-123), -321);
        Assert.assertEquals(leetCode7.reverse(Integer.MAX_VALUE), 0);
        Assert.assertEquals(leetCode7.reverse(Integer.MAX_VALUE - 1), 0);
        Assert.assertEquals(leetCode7.reverse(Integer.MIN_VALUE - 1), 0);
        Assert.assertEquals(leetCode7.reverse(Integer.MIN_VALUE), 0);
    }

    @Test
    public void reverse1() {
        LeetCode7 leetCode7 = new LeetCode7();
        Assert.assertEquals(leetCode7.reverse1(0), 0);
        Assert.assertEquals(leetCode7.reverse1(-1), -1);
        Assert.assertEquals(leetCode7.reverse1(1), 1);
        Assert.assertEquals(leetCode7.reverse1(123), 321);
        Assert.assertEquals(leetCode7.reverse1(-123), -321);
        Assert.assertEquals(leetCode7.reverse1(Integer.MAX_VALUE), 0);
        Assert.assertEquals(leetCode7.reverse1(Integer.MAX_VALUE - 1), 0);
        Assert.assertEquals(leetCode7.reverse1(Integer.MIN_VALUE - 1), 0);
        Assert.assertEquals(leetCode7.reverse1(Integer.MIN_VALUE), 0);
    }

    @Test
    public void reverseInt() {
        LeetCode7 leetCode7 = new LeetCode7();
        Assert.assertEquals(0, leetCode7.reverseInt(Integer.MAX_VALUE));
        Assert.assertEquals(321, leetCode7.reverseInt(123));
        Assert.assertEquals(1, leetCode7.reverseInt(1));
    }
}