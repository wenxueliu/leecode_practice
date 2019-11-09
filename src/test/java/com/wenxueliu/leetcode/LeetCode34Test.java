package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode34Test {

    @Test
    public void searchRange() {
        LeetCode34 leetCode34 = new LeetCode34();
        Assert.assertArrayEquals(leetCode34.searchRange(new int[] {5,7,7,8,8,10}, 8), new int[]{3,4});
        Assert.assertArrayEquals(leetCode34.searchRange(new int[] {5,5,7,7,8,8,10}, 5), new int[]{0,1});
        Assert.assertArrayEquals(leetCode34.searchRange(new int[] {5,5,7,7,8,8,10,10}, 5), new int[]{0,1});
        Assert.assertArrayEquals(leetCode34.searchRange(new int[] {5,5,5}, 5), new int[]{0,2});
    }
}