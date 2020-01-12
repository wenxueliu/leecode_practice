package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode1208Test {

    @Test
    public void equalSubstring() {
        LeetCode1208 leetCode1208 = new LeetCode1208();
        Assert.assertEquals(0, leetCode1208.equalSubstring("abc", "bcd", 0));
        Assert.assertEquals(2, leetCode1208.equalSubstring("abc", "zcd", 2));
        Assert.assertEquals(1, leetCode1208.equalSubstring("abcd", "zdef", 2));
        Assert.assertEquals(3, leetCode1208.equalSubstring("abcdef", "bcdxyz", 3));
        Assert.assertEquals(2, leetCode1208.equalSubstring("abcdef", "bcdxyz", 2));
        Assert.assertEquals(3, leetCode1208.equalSubstring("abcd", "bcdg",  3));
        Assert.assertEquals(3, leetCode1208.equalSubstring("abcd", "cddf", 5));
        Assert.assertEquals(3, leetCode1208.equalSubstring("jzmhzdq", "rymuemg", 17));
        Assert.assertEquals(3, leetCode1208.equalSubstring("abcde", "bcdgz",  3));

    }
}