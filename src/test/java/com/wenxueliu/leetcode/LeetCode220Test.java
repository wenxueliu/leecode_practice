package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode220Test {

    @Test
    public void containsNearbyAlmostDuplicate() {
        LeetCode220 leetCode220 = new LeetCode220();
        Assert.assertEquals(false, leetCode220.containsNearbyAlmostDuplicate(new int[] {-3, 3}, 2, 4));
        Assert.assertEquals(false, leetCode220.containsNearbyAlmostDuplicate(new int[] {1, 5, 9, 1, 5, 9}, 2, 3));
    }
}