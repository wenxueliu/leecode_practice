package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode33Test {

    @Test
    public void findMinIndex() {
        LeetCode33 leetCode33 = new LeetCode33();
        Assert.assertEquals(3, leetCode33.findMinIndex(new int[] {5,6,7,0,1,2,3,4}));
        Assert.assertEquals(4, leetCode33.findMinIndex(new int[] {4,5,6,7,0,1,2,3}));
        Assert.assertEquals(0, leetCode33.findMinIndex(new int[] {0,1,2,3,4,5,6,7}));
        Assert.assertEquals(7, leetCode33.findMinIndex(new int[] {1,2,3,4,5,6,7,0}));

        Assert.assertEquals(3, leetCode33.findMinIndex(new int[] {5,6,7,0,1,2,3}));
        Assert.assertEquals(4, leetCode33.findMinIndex(new int[] {4,5,6,7,0,1,2}));
        Assert.assertEquals(2, leetCode33.findMinIndex(new int[] {5,6,0,1,2,3,4}));
        Assert.assertEquals(0, leetCode33.findMinIndex(new int[] {0,1,2,3,4,5,6}));
        Assert.assertEquals(6, leetCode33.findMinIndex(new int[] {1,2,3,4,5,6,0}));
    }
}