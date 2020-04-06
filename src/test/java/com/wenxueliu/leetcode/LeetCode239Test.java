package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode239Test {

    @Test
    public void maxSlidingWindow() {
        LeetCode239 leetcode239 = new LeetCode239();
        Assert.assertArrayEquals(new int[] {3,3,5,5,6,7}, leetcode239.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3));
        Assert.assertArrayEquals(new int[] {-1, 1}, leetcode239.maxSlidingWindow(new int[]{-1, 1}, 1));
    }

    @Test
    public void maxSlidingWindow1() {
        LeetCode239 leetcode239 = new LeetCode239();
        Assert.assertArrayEquals(new int[] {3,3,5,5,6,7}, leetcode239.maxSlidingWindow1(new int[]{1,3,-1,-3,5,3,6,7}, 3));
        Assert.assertArrayEquals(new int[] {-1, 1}, leetcode239.maxSlidingWindow1(new int[]{-1, 1}, 1));
    }

    @Test
    public void maxSlidingWindow2() {
        LeetCode239 leetcode239 = new LeetCode239();
        Assert.assertArrayEquals(new int[] {3,3,5,5,6,7}, leetcode239.maxSlidingWindow2(new int[]{1,3,-1,-3,5,3,6,7}, 3));
        Assert.assertArrayEquals(new int[] {-1, 1}, leetcode239.maxSlidingWindow2(new int[]{-1, 1}, 1));
    }

    @Test
    public void maxSlidingWindow3() {
        LeetCode239 leetcode239 = new LeetCode239();
        Assert.assertArrayEquals(new int[] {3,3,5,5,6,7}, leetcode239.maxSlidingWindow3(new int[]{1,3,-1,-3,5,3,6,7}, 3));
        Assert.assertArrayEquals(new int[] {-1, 1}, leetcode239.maxSlidingWindow3(new int[]{-1, 1}, 1));
    }

    @Test
    public void maxSlidingWindow4() {
        LeetCode239 leetcode239 = new LeetCode239();
        Assert.assertArrayEquals(new int[] {3,3,5,5,6,7}, leetcode239.maxSlidingWindow4(new int[]{1,3,-1,-3,5,3,6,7}, 3));
        Assert.assertArrayEquals(new int[] {-1, 1}, leetcode239.maxSlidingWindow4(new int[]{-1, 1}, 1));
    }
}