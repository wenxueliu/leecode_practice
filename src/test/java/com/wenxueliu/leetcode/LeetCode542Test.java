package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode542Test {

    @Test
    public void updateMatrix() {
        Assert.assertArrayEquals(new int[][]{{0,0,0},{0,1,0},{0,0,0}}, new LeetCode542().updateMatrix(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
        Assert.assertArrayEquals(new int[][]{{0,0,0},{0,1,0},{1,2,1}}, new LeetCode542().updateMatrix(new int[][]{{0,0,0},{0,1,0},{1,1,1}}));
        Assert.assertArrayEquals(new int[][]{{0,1,0},{0,1,0},{0,1,0},{0,1,0},{0,1,0}}, new LeetCode542().updateMatrix(new int[][]{{0,1,0},{0,1,0},{0,1,0},{0,1,0},{0,1,0}}));
    }

    @Test
    public void updateMatrix1() {
        Assert.assertArrayEquals(new int[][]{{0,0,0},{0,1,0},{0,0,0}}, new LeetCode542().updateMatrix1(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
        Assert.assertArrayEquals(new int[][]{{0,0,0},{0,1,0},{1,2,1}}, new LeetCode542().updateMatrix1(new int[][]{{0,0,0},{0,1,0},{1,1,1}}));
        Assert.assertArrayEquals(new int[][]{{0,1,0},{0,1,0},{0,1,0},{0,1,0},{0,1,0}}, new LeetCode542().updateMatrix1(new int[][]{{0,1,0},{0,1,0},{0,1,0},{0,1,0},{0,1,0}}));
    }
}