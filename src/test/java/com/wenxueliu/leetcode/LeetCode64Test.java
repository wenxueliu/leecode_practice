package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode64Test {

    @Test
    public void minPathSum() {
        LeetCode64 leetCode64 = new LeetCode64();
        Assert.assertEquals(leetCode64.minPathSum(new int[][]{}), 0);
        Assert.assertEquals(leetCode64.minPathSum(new int[][]{{1}}), 1);
        Assert.assertEquals(leetCode64.minPathSum(new int[][]{{1, 2, 3}}), 6);
        Assert.assertEquals(leetCode64.minPathSum(new int[][]{{1}, {2}, {3}}), 6);
        Assert.assertEquals(leetCode64.minPathSum(new int[][]{{1, 2}, {1, 2}}), 4);
    }
}