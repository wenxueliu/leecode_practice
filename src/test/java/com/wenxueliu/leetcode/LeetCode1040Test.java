package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode1040Test {

    @Test
    public void numMovesStonesII() {
        LeetCode1040 leetCode1040 = new LeetCode1040();
        Assert.assertArrayEquals(new int []{1, 2}, leetCode1040.numMovesStonesII(new int[]{7,4,9}));
        Assert.assertArrayEquals(new int []{2, 3}, leetCode1040.numMovesStonesII(new int[]{6,5,4,3,10}));
        Assert.assertArrayEquals(new int []{0, 0}, leetCode1040.numMovesStonesII(new int[]{100,101,104,102,103}));
        Assert.assertArrayEquals(new int []{2, 5}, leetCode1040.numMovesStonesII(new int[]{1,2,3,4,10}));
    }
}