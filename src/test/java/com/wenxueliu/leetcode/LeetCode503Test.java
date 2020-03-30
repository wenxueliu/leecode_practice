package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;

import static org.junit.Assert.*;

public class LeetCode503Test {

    @Test
    public void nextGreaterElements() {
        LeetCode503 leetCode503 = new LeetCode503();
        Assert.assertArrayEquals(new int[]{-1, -1, -1, -1, -1}, leetCode503.nextGreaterElements(new int[]{1, 1, 1, 1, 1}));
        Assert.assertArrayEquals(new int[]{2, 2, 2, 2, -1}, leetCode503.nextGreaterElements(new int[]{1, 1, 1, 1, 2}));
        Assert.assertArrayEquals(new int[]{-1, 5, 5, 5, 5}, leetCode503.nextGreaterElements(new int[]{5, 4, 3, 2, 1}));
        Assert.assertArrayEquals(new int[]{2, -1, 2}, leetCode503.nextGreaterElements(new int[]{1, 2, 1}));
    }
}