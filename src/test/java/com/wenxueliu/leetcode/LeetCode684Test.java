package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode684Test {

    @Test
    public void findRedundantConnection() {
        Assert.assertArrayEquals(new LeetCode684().findRedundantConnection(new int[][]{{1,2}, {1,3}, {2,3}}), new int[]{2, 3});
        Assert.assertArrayEquals(new LeetCode684().findRedundantConnection(new int[][]{{1,2}, {2,3}, {3,4}, {1,4}, {1,5}}), new int[]{1, 4});
    }
}