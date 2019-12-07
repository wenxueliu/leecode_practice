package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode1057Test {

    @Test
    public void assignBikes() {
        LeetCode1057 leetCode1057 = new LeetCode1057();
        Assert.assertArrayEquals(new int[]{0, 2, 1}, leetCode1057.assignBikes(new int[][]{{0,0},{1,1},{2,0}}, new int[][]{{1,0},{2,2},{2,1}}));
        Assert.assertArrayEquals(new int[]{1, 0}, leetCode1057.assignBikes(new int[][]{{0,0},{2,1}}, new int[][]{{1,2},{3,3}}));

        Assert.assertArrayEquals(new int[]{0, 2, 1}, leetCode1057.assignBikes1(new int[][]{{0,0},{1,1},{2,0}}, new int[][]{{1,0},{2,2},{2,1}}));
        Assert.assertArrayEquals(new int[]{1, 0}, leetCode1057.assignBikes1(new int[][]{{0,0},{2,1}}, new int[][]{{1,2},{3,3}}));
    }
}