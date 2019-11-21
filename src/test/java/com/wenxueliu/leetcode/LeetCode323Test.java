package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode323Test {

    @Test
    public void countComponents() {
        LeetCode323 leetcode323 = new LeetCode323();
        Assert.assertEquals(2, leetcode323.countComponents(5, new int[][] {{0, 1}, {1, 2}, {3, 4}}));
        Assert.assertEquals(1, leetcode323.countComponents(5, new int[][] {{0, 1}, {1, 2}, {2, 3}, {3, 4}}));
        Assert.assertEquals(1, leetcode323.countComponents(4, new int[][] {{0, 1}, {1, 2}, {2, 3}, {1, 3}}));
    }

    @Test
    public void countComponents1() {
        LeetCode323 leetcode323 = new LeetCode323();
        Assert.assertEquals(2, leetcode323.countComponents1(5, new int[][] {{0, 1}, {1, 2}, {3, 4}}));
        Assert.assertEquals(1, leetcode323.countComponents1(5, new int[][] {{0, 1}, {1, 2}, {2, 3}, {3, 4}}));
        Assert.assertEquals(1, leetcode323.countComponents1(4, new int[][] {{0, 1}, {1, 2}, {2, 3}, {1, 3}}));
    }
}