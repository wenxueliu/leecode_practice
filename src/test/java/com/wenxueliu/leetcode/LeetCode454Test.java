package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class LeetCode454Test {

    @Test
    public void fourSumCount() {
        LeetCode454 leetCode454 = new LeetCode454();
        Assert.assertEquals(2, leetCode454.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
    }
}