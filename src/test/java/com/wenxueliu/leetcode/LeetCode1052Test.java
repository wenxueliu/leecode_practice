package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode1052Test {

    @Test
    public void maxSatisfied() {
        LeetCode1052 leetCode1052 = new LeetCode1052();
        Assert.assertEquals(16, leetCode1052.maxSatisfied(new int[]{1,0,1,2,1,1,7,5}, new int[]{0,1,0,1,0,1,0,1}, 3));
        Assert.assertEquals(24, leetCode1052.maxSatisfied(new int[]{4, 10, 10}, new int[]{1, 1, 0}, 2));
        Assert.assertEquals(18, leetCode1052.maxSatisfied(new int[]{10, 1, 7}, new int[]{0, 0, 0}, 2));
        Assert.assertEquals(1, leetCode1052.maxSatisfied(new int[]{1}, new int[]{0}, 1));
    }
}