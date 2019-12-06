package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode1055Test {

    @Test
    public void shortestWay() {
        LeetCode1055 leetCode1055 = new LeetCode1055();
        Assert.assertEquals(2, leetCode1055.shortestWay("abc", "abcab"));
        Assert.assertEquals(-1, leetCode1055.shortestWay("a", "abcab"));
        Assert.assertEquals(3, leetCode1055.shortestWay("a", "aaa"));
        Assert.assertEquals(1, leetCode1055.shortestWay("abc", "a"));
    }
}