package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class LeetCode438Test {

    @Test
    public void findAnagrams() {
        LeetCode438 leetCode438 = new LeetCode438();
        Assert.assertArrayEquals(new Integer[] {0, 6} , leetCode438.findAnagrams("cbaebabacd", "abc").toArray());
        Assert.assertArrayEquals(new Integer[] {0, 1, 2} , leetCode438.findAnagrams("abab", "ab").toArray());
        Assert.assertArrayEquals(new Integer[] {}, leetCode438.findAnagrams("a", "ab").toArray());
    }
}