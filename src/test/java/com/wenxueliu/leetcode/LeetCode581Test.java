package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode581Test {

    @Test
    public void findUnsortedSubarray() {
        Assert.assertTrue(new LeetCode581().findUnsortedSubarray(new int[]{1,2,4,5,3}) == 3);
        Assert.assertTrue(new LeetCode581().findUnsortedSubarray(new int[]{2,6,6,6,4,8,10,9,9,9,15}) == 9);
        Assert.assertTrue(new LeetCode581().findUnsortedSubarray(new int[]{2,3,3,2,4}) == 3);
        Assert.assertTrue(new LeetCode581().findUnsortedSubarray(new int[]{5,4,3,2,1}) == 5);
        Assert.assertTrue(new LeetCode581().findUnsortedSubarray(new int[]{1,2,5,3,4}) == 3);
        Assert.assertTrue(new LeetCode581().findUnsortedSubarray(new int[]{1,3,5,4,2}) == 4);
        Assert.assertTrue(new LeetCode581().findUnsortedSubarray(new int[]{1,2,3,4,5}) == 0);
    }
}