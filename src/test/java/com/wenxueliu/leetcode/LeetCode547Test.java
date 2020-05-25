package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode547Test {

    @Test
    public void findCircleNum() {
        LeetCode547 leetCode547 = new LeetCode547();
        Assert.assertEquals(1, leetCode547.findCircleNum(new int[][] {{1}}));
        Assert.assertEquals(1, leetCode547.findCircleNum(new int[][] {{1, 1},{1,1}}));
        Assert.assertEquals(1, leetCode547.findCircleNum(new int[][] {{1, 1},{1,1}}));
        Assert.assertEquals(2, leetCode547.findCircleNum(new int[][] {{1, 0},{0,1}}));
        Assert.assertEquals(3, leetCode547.findCircleNum(new int[][] {{1,0,0},{0,1,0},{0,0,1}}));
        Assert.assertEquals(2, leetCode547.findCircleNum(new int[][] {{1,1,0},{1,1,0},{0,0,1}}));
        Assert.assertEquals(1, leetCode547.findCircleNum(new int[][] {{1,1,0},{1,1,1},{0,1,1}}));
        Assert.assertEquals(1, leetCode547.findCircleNum(new int[][] {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}}));
        /**
         * [1, 0, 0, 1]
         * [0, 1, 1, 0]
         * [0, 1, 1, 1]
         * [1, 0, 1, 1]
         * [[0]]
         * [[0,3]]
         * [[0,3],[1,2,3]]
         *
         *
         * [0,2,3]
         * [1,2]
         *
         */
    }

    @Test
    public void findCircleNum3() {
        LeetCode547 leetCode547 = new LeetCode547();
        Assert.assertEquals(1, leetCode547.findCircleNum3(new int[][] {{1}}));
        Assert.assertEquals(1, leetCode547.findCircleNum3(new int[][] {{1, 1},{1,1}}));
        Assert.assertEquals(1, leetCode547.findCircleNum3(new int[][] {{1, 1},{1,1}}));
        Assert.assertEquals(2, leetCode547.findCircleNum3(new int[][] {{1, 0},{0,1}}));
        Assert.assertEquals(3, leetCode547.findCircleNum3(new int[][] {{1,0,0},{0,1,0},{0,0,1}}));
        Assert.assertEquals(2, leetCode547.findCircleNum3(new int[][] {{1,1,0},{1,1,0},{0,0,1}}));
        Assert.assertEquals(1, leetCode547.findCircleNum3(new int[][] {{1,1,0},{1,1,1},{0,1,1}}));
        Assert.assertEquals(1, leetCode547.findCircleNum3(new int[][] {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}}));
    }
}