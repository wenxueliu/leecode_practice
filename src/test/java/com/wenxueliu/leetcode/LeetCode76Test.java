package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode76Test {

    @Test
    public void minWindow() {
        LeetCode76 leetCode76 = new LeetCode76();
        Assert.assertEquals("BANC", leetCode76.minWindow("ADOBECODEBANC", "ABC"));
    }
}