package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode484Test {

    @Test
    public void findPermutation() {
        LeetCode484 leetCode484 = new LeetCode484();
        Assert.assertArrayEquals(new int[] {1}, leetCode484.findPermutation(""));
        Assert.assertArrayEquals(new int[] {1,2}, leetCode484.findPermutation("I"));
        Assert.assertArrayEquals(new int[] {2,1}, leetCode484.findPermutation("D"));
        Assert.assertArrayEquals(new int[] {2,1}, leetCode484.findPermutation("D"));
        Assert.assertArrayEquals(new int[] {1,4,3,2,5,8,7,6,9}, leetCode484.findPermutation("IDDIIDDI"));
    }
}