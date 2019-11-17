package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode62Test {

    @Test
    public void uniquePaths() {
        LeetCode62 leetCode62 = new LeetCode62();
        Assert.assertEquals(leetCode62.uniquePaths(6, 1), 1);
        Assert.assertEquals(leetCode62.uniquePaths(1, 6), 1);
        Assert.assertEquals(leetCode62.uniquePaths(6, 2), 6);
    }

    @Test
    public void uniquePaths1() {
    }
}