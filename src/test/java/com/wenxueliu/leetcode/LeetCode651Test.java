package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode651Test {

    @Test
    public void maxA() {
        LeetCode651 leetCode651 = new LeetCode651();
        Assert.assertEquals(1, leetCode651.maxA(1));
        Assert.assertEquals(2, leetCode651.maxA(2));
        Assert.assertEquals(3, leetCode651.maxA(3));
        Assert.assertEquals(4, leetCode651.maxA(4));
        Assert.assertEquals(5, leetCode651.maxA(5));
        Assert.assertEquals(6, leetCode651.maxA(6));
        Assert.assertEquals(27, leetCode651.maxA(11));
    }
}