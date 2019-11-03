package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode16Test {

    @Test
    public void threeSumClosest() {
        LeetCode16 leetCode16 = new LeetCode16();
        Assert.assertEquals(leetCode16.threeSumClosest(new int[] {-1,2,1,-4}, 1), 2);
        // 1
    }
}