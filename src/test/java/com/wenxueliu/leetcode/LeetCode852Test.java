package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode852Test {

    @Test
    public void peakIndexInMountainArray() {
        Assert.assertEquals(1, new LeetCode852().peakIndexInMountainArray(new int[]{0,1,0}));
        Assert.assertEquals(3, new LeetCode852().peakIndexInMountainArray(new int[]{0, 1, 2, 5, 3, 1}));
        Assert.assertEquals(2, new LeetCode852().peakIndexInMountainArray(new int[]{1,2,3}));
        Assert.assertEquals(0, new LeetCode852().peakIndexInMountainArray(new int[]{3,2,1}));
        Assert.assertEquals(1, new LeetCode852().peakIndexInMountainArray(new int[]{3,5,3,2,0}));
    }
}