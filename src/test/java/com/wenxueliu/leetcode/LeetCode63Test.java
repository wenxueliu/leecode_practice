package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode63Test {

    @Test
    public void uniquePathsWithObstacles() {
        LeetCode63 leetCode63 = new LeetCode63();
        Assert.assertEquals(leetCode63.uniquePathsWithObstacles(new int[][]{{}}), 0);
        Assert.assertEquals(leetCode63.uniquePathsWithObstacles(new int[][]{{0}}), 1);
        Assert.assertEquals(leetCode63.uniquePathsWithObstacles(new int[][]{{1}}), 0);
        Assert.assertEquals(leetCode63.uniquePathsWithObstacles(new int[][]{{1, 1},{1, 1}}), 0);
        Assert.assertEquals(leetCode63.uniquePathsWithObstacles(new int[][]{{1, 0},{0, 0}}), 0);
        Assert.assertEquals(leetCode63.uniquePathsWithObstacles(new int[][]{{1, 0},{0, 1}}), 0);
        Assert.assertEquals(leetCode63.uniquePathsWithObstacles(new int[][]{{0, 0},{0, 1}}), 0);
        Assert.assertEquals(leetCode63.uniquePathsWithObstacles(new int[][]{{1, 0},{0, 0}}), 0);
        Assert.assertEquals(leetCode63.uniquePathsWithObstacles(new int[][]{{0, 1},{0, 0}}), 1);
        Assert.assertEquals(leetCode63.uniquePathsWithObstacles(new int[][]{{0, 0},{0, 0}}), 2);
    }
}