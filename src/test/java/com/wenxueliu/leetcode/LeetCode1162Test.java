package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode1162Test {

    @Test
    public void maxDistance() {
        Assert.assertEquals(2, new LeetCode1162().maxDistance(new int[][]{{1,0,1},{0,0,0},{1,0,1}}));
        Assert.assertEquals(4, new LeetCode1162().maxDistance(new int[][]{{1,0,0},{0,0,0},{0,0,0}}));
        Assert.assertEquals(6, new LeetCode1162().maxDistance(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,0,0}, {0,0,0,0}}));
        Assert.assertEquals(2, new LeetCode1162().maxDistance(new int[][]{{0,0,0,0},{0,1,1,0},{0,1,1,0}, {0,0,0,0}}));
        Assert.assertEquals(-1, new LeetCode1162().maxDistance(new int[][]{{0,0,0},{0,0,0},{0,0,0}}));
        Assert.assertEquals(-1, new LeetCode1162().maxDistance(new int[][]{{1,1,1},{1,1,1},{1,1,1}}));
    }

    @Test
    public void maxDistance1() {
        Assert.assertEquals(2, new LeetCode1162().maxDistance1(new int[][]{{1,0,1},{0,0,0},{1,0,1}}));
        Assert.assertEquals(4, new LeetCode1162().maxDistance1(new int[][]{{1,0,0},{0,0,0},{0,0,0}}));
        Assert.assertEquals(6, new LeetCode1162().maxDistance1(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,0,0}, {0,0,0,0}}));
        Assert.assertEquals(2, new LeetCode1162().maxDistance1(new int[][]{{0,0,0,0},{0,1,1,0},{0,1,1,0}, {0,0,0,0}}));
        Assert.assertEquals(-1, new LeetCode1162().maxDistance1(new int[][]{{0,0,0},{0,0,0},{0,0,0}}));
        Assert.assertEquals(-1, new LeetCode1162().maxDistance1(new int[][]{{1,1,1},{1,1,1},{1,1,1}}));
    }

    @Test
    public void maxDistance2() {
        Assert.assertEquals(2, new LeetCode1162().maxDistance2(new int[][]{{1,0,1},{0,0,0},{1,0,1}}));
        Assert.assertEquals(4, new LeetCode1162().maxDistance2(new int[][]{{1,0,0},{0,0,0},{0,0,0}}));
        Assert.assertEquals(6, new LeetCode1162().maxDistance2(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,0,0}, {0,0,0,0}}));
        Assert.assertEquals(2, new LeetCode1162().maxDistance2(new int[][]{{0,0,0,0},{0,1,1,0},{0,1,1,0}, {0,0,0,0}}));
        Assert.assertEquals(-1, new LeetCode1162().maxDistance2(new int[][]{{0,0,0},{0,0,0},{0,0,0}}));
        Assert.assertEquals(-1, new LeetCode1162().maxDistance2(new int[][]{{1,1,1},{1,1,1},{1,1,1}}));
    }
}