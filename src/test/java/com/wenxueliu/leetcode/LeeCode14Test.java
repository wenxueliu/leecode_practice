package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeeCode14Test {

    @Test
    public void longestCommonPrefix() {
        LeetCode14 leetCode14 = new LeetCode14();
        Assert.assertEquals(
                leetCode14.longestCommonPrefix(new String[] {"flower","flow","flight"}),
                "fl");
    }
}