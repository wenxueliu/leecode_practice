package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode154Test {

    @Test
    public void findMin() {
        LeetCode154 leetCode154 = new LeetCode154();
        Assert.assertEquals(leetCode154.findMin(new int[]{1}), 1);
        Assert.assertEquals(leetCode154.findMin(new int[]{1,3}), 1);
        Assert.assertEquals(leetCode154.findMin(new int[]{3,1}), 1);
        Assert.assertEquals(leetCode154.findMin(new int[]{3,1,3}), 1);
        Assert.assertEquals(leetCode154.findMin(new int[]{1,3,1}), 1);
        Assert.assertEquals(leetCode154.findMin(new int[]{1, 2, 1, 1, 1}), 1);
        Assert.assertEquals(leetCode154.findMin(new int[]{1, 2, 2, 2, 1}), 1);
        Assert.assertEquals(leetCode154.findMin(new int[]{2, 2, 2, 1, 1, 2}), 1);
        Assert.assertEquals(leetCode154.findMin(new int[]{2, 1, 1, 2, 2, 2}), 1);
        Assert.assertEquals(leetCode154.findMin(new int[]{2, 2, 2, 3, 4, 1, 1, 2}), 1);
        Assert.assertEquals(leetCode154.findMin(new int[]{2, 1, 1, 2, 2, 2}), 1);
    }
}