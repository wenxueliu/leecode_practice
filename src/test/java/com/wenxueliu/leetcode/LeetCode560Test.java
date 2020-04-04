package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode560Test {

    @Test
    public void subarraySum() {
        LeetCode560 leetCode560 = new LeetCode560();
        Assert.assertEquals(0, leetCode560.subarraySum(new int[]{1}, 0));
        Assert.assertEquals(1, leetCode560.subarraySum(new int[]{1}, 1));

        Assert.assertEquals(0, leetCode560.subarraySum(new int[]{1, 2}, 0));
        Assert.assertEquals(1, leetCode560.subarraySum(new int[]{1, -1}, 0));
        Assert.assertEquals(1, leetCode560.subarraySum(new int[]{1, 1}, 2));
        Assert.assertEquals(2, leetCode560.subarraySum(new int[]{1, 1}, 1));

        Assert.assertEquals(0, leetCode560.subarraySum(new int[]{1, 1, 1}, 4));
        Assert.assertEquals(2, leetCode560.subarraySum(new int[]{1, 1, 1}, 2));
        Assert.assertEquals(3, leetCode560.subarraySum(new int[]{1, -1, 1}, 1));
        Assert.assertEquals(1, leetCode560.subarraySum(new int[]{-1, -1, 1}, 0));
    }
}