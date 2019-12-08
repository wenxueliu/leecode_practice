package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode1231Test {

    @Test
    public void maximizeSweetness() {
        LeetCode1231 leetCode1231 = new LeetCode1231();
        Assert.assertEquals(6, leetCode1231.maximizeSweetness(new int[]{1,2,3,4,5,6,7,8,9}, 5));
        Assert.assertEquals(1, leetCode1231.maximizeSweetness(new int[]{5,6,7,8,9,1,2,3,4}, 8));
        Assert.assertEquals(5, leetCode1231.maximizeSweetness(new int[]{1,2,2,1,2,2,1,2,2}, 2));
    }
}