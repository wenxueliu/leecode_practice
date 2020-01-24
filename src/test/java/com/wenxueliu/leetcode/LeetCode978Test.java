package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode978Test {

    @Test
    public void maxTurbulenceSize() {
        LeetCode978 leetCode978 = new LeetCode978();
        Assert.assertEquals(1, leetCode978.maxTurbulenceSize(new int[]{1}));
        Assert.assertEquals(2, leetCode978.maxTurbulenceSize(new int[]{1, 2}));
        Assert.assertEquals(2, leetCode978.maxTurbulenceSize(new int[]{2, 1}));
        Assert.assertEquals(1, leetCode978.maxTurbulenceSize(new int[]{2, 2}));
        //0, 0
        Assert.assertEquals(1, leetCode978.maxTurbulenceSize(new int[]{2, 2, 2}));
        //1, -1
        Assert.assertEquals(3, leetCode978.maxTurbulenceSize(new int[]{2, 3, 2}));
        //1, 1
        Assert.assertEquals(2, leetCode978.maxTurbulenceSize(new int[]{2, 3, 4}));
        //-1, -1
        Assert.assertEquals(2, leetCode978.maxTurbulenceSize(new int[]{4, 3, 2}));
        //0, 0, 0
        Assert.assertEquals(1, leetCode978.maxTurbulenceSize(new int[]{2, 2, 2, 2}));
        //0, 0, 1
        Assert.assertEquals(2, leetCode978.maxTurbulenceSize(new int[]{2, 2, 2, 3}));
        //0, 0, -1
        Assert.assertEquals(2, leetCode978.maxTurbulenceSize(new int[]{2, 2, 2, 1}));
        //0, 1, 0
        Assert.assertEquals(2, leetCode978.maxTurbulenceSize(new int[]{2, 2, 3, 3}));
        //0, 1, -1
        Assert.assertEquals(3, leetCode978.maxTurbulenceSize(new int[]{2, 2, 3, 2}));
        //0, 1, 1
        Assert.assertEquals(2, leetCode978.maxTurbulenceSize(new int[]{2, 2, 3, 4}));
        //0, -1, 0
        Assert.assertEquals(2, leetCode978.maxTurbulenceSize(new int[]{2, 2, 1, 1}));
        //0, -1, 1
        Assert.assertEquals(3, leetCode978.maxTurbulenceSize(new int[]{2, 2, 1, 2}));
        //0, -1, -1
        Assert.assertEquals(2, leetCode978.maxTurbulenceSize(new int[]{3, 3, 2, 1}));
        //1, -1, -1
        Assert.assertEquals(3, leetCode978.maxTurbulenceSize(new int[]{2, 3, 2, 1}));
    }
}