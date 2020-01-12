package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode424Test {

    @Test
    public void characterReplacement() {
        LeetCode424 leetCode424 = new LeetCode424();
        Assert.assertEquals(4, leetCode424.characterReplacement("AABABBA", 1));
        Assert.assertEquals(4, leetCode424.characterReplacement("ABBB", 1));
        Assert.assertEquals(4, leetCode424.characterReplacement("ABAB", 2));
    }

    @Test
    public void characterReplacement1() {
        LeetCode424 leetCode424 = new LeetCode424();
        Assert.assertEquals(4, leetCode424.characterReplacement1("AABABBA", 1));
        Assert.assertEquals(4, leetCode424.characterReplacement1("ABBB", 1));
        Assert.assertEquals(4, leetCode424.characterReplacement1("ABAB", 2));
    }
}