package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode209Test {

    @Test
    public void minSubArrayLen() {
        LeetCode209 leetCode209 = new LeetCode209();
        Assert.assertEquals(0, leetCode209.minSubArrayLen(7, new int[]{}));
        Assert.assertEquals(0, leetCode209.minSubArrayLen(7, new int[]{2,1,3}));
        Assert.assertEquals(3, leetCode209.minSubArrayLen(6, new int[]{2,1,3}));
        Assert.assertEquals(1, leetCode209.minSubArrayLen(3, new int[]{2,1,3}));
        Assert.assertEquals(2, leetCode209.minSubArrayLen(2, new int[]{1,1,1}));
        Assert.assertEquals(3, leetCode209.minSubArrayLen(3, new int[]{1,1,1}));
        Assert.assertEquals(2, leetCode209.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}