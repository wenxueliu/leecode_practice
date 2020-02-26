package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode395Test {

    @Test
    public void longestSubstring() {
        LeetCode395 leetCode395 = new LeetCode395();
        Assert.assertEquals(3, leetCode395.longestSubstring("aaabb", 3));
        Assert.assertEquals(5, leetCode395.longestSubstring("ababbc", 2));
    }
}