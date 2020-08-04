package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode939Test {

    @Test
    public void minAreaRect() {
        Assert.assertEquals(new LeetCode939().minAreaRect(new int[][]{{1,1},{1,3},{3,1},{1,6},{2,2}}), 0);
        Assert.assertEquals(new LeetCode939().minAreaRect(new int[][]{{1,1},{1,3},{3,1},{3,3},{2,2}}), 4);
        Assert.assertEquals(new LeetCode939().minAreaRect(new int[][]{{1,1},{1,3},{3,1},{3,3},{2,1}, {2,3}}), 2);
        Assert.assertEquals(new LeetCode939().minAreaRect(new int[][]{{1,1},{1,3},{3,1},{3,3},{4,1}, {4,3}}), 2);
    }
}