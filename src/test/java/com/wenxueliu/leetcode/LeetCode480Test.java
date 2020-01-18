package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode480Test {

    @Test
    public void medianSlidingWindow() {
        LeetCode480 leetCode480 = new LeetCode480();
        Assert.assertArrayEquals(new double[]{1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000}, leetCode480.medianSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3), 5);
        Assert.assertArrayEquals(new double[]{2.50000}, leetCode480.medianSlidingWindow(new int[] {1,4,2,3}, 4), 5);
        Assert.assertArrayEquals(new double[]{1,4,2,3}, leetCode480.medianSlidingWindow(new int[] {1,4,2,3}, 1), 5);
        Assert.assertArrayEquals(new double[] {2147483647.00000}, leetCode480.medianSlidingWindow(new int[] {2147483647,2147483647}, 2), 5);
        Assert.assertArrayEquals(new double[] {-2147483648.00000,-2147483648.00000,-2147483648.00000,-2147483648.00000,-2147483648.00000,2147483647.00000,2147483647.00000,2147483647.00000,2147483647.00000,2147483647.00000,-2147483648.00000},
                leetCode480.medianSlidingWindow(new int[] {-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648}, 3), 5);
    }

    @Test
    public void medianSlidingWindow1() {
        LeetCode480 leetCode480 = new LeetCode480();
        Assert.assertArrayEquals(new double[]{1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000}, leetCode480.medianSlidingWindow1(new int[] {1,3,-1,-3,5,3,6,7}, 3), 5);
        Assert.assertArrayEquals(new double[]{2.50000}, leetCode480.medianSlidingWindow1(new int[] {1,4,2,3}, 4), 5);
        Assert.assertArrayEquals(new double[]{1,4,2,3}, leetCode480.medianSlidingWindow1(new int[] {1,4,2,3}, 1), 5);
        Assert.assertArrayEquals(new double[] {2147483647.00000}, leetCode480.medianSlidingWindow1(new int[] {2147483647,2147483647}, 2), 5);
        Assert.assertArrayEquals(new double[] {-2147483648.00000,-2147483648.00000,-2147483648.00000,-2147483648.00000,-2147483648.00000,2147483647.00000,2147483647.00000,2147483647.00000,2147483647.00000,2147483647.00000,-2147483648.00000},
                leetCode480.medianSlidingWindow1(new int[] {-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648}, 3), 5);
    }

    @Test
    public void medianSlidingWindow2() {
        LeetCode480 leetCode480 = new LeetCode480();
        Assert.assertArrayEquals(new double[]{1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000}, leetCode480.medianSlidingWindow2(new int[] {1,3,-1,-3,5,3,6,7}, 3), 5);
        Assert.assertArrayEquals(new double[]{2.50000}, leetCode480.medianSlidingWindow2(new int[] {1,4,2,3}, 4), 5);
        Assert.assertArrayEquals(new double[]{1,4,2,3}, leetCode480.medianSlidingWindow2(new int[] {1,4,2,3}, 1), 5);
        Assert.assertArrayEquals(new double[] {2147483647.00000}, leetCode480.medianSlidingWindow2(new int[] {2147483647,2147483647}, 2), 5);
        Assert.assertArrayEquals(new double[] {-2147483648.00000,-2147483648.00000,-2147483648.00000,-2147483648.00000,-2147483648.00000,2147483647.00000,2147483647.00000,2147483647.00000,2147483647.00000,2147483647.00000,-2147483648.00000},
                leetCode480.medianSlidingWindow2(new int[] {-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648}, 3), 5);
    }

    @Test
    public void medianSlidingWindow3() {
        LeetCode480 leetCode480 = new LeetCode480();
        Assert.assertArrayEquals(new double[]{1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000}, leetCode480.medianSlidingWindow3(new int[] {1,3,-1,-3,5,3,6,7}, 3), 5);
        Assert.assertArrayEquals(new double[]{2.50000}, leetCode480.medianSlidingWindow3(new int[] {1,4,2,3}, 4), 5);
        Assert.assertArrayEquals(new double[]{1,4,2,3}, leetCode480.medianSlidingWindow3(new int[] {1,4,2,3}, 1), 5);
        Assert.assertArrayEquals(new double[] {2147483647.00000}, leetCode480.medianSlidingWindow3(new int[] {2147483647,2147483647}, 2), 5);
        Assert.assertArrayEquals(new double[] {-2147483648.00000,-2147483648.00000,-2147483648.00000,-2147483648.00000,-2147483648.00000,2147483647.00000,2147483647.00000,2147483647.00000,2147483647.00000,2147483647.00000,-2147483648.00000},
                leetCode480.medianSlidingWindow3(new int[] {-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648}, 3), 5);
    }
}