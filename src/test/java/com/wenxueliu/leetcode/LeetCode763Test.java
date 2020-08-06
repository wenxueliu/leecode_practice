package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class LeetCode763Test {

    @Test
    public void partitionLabels() {
        Assert.assertTrue(new LeetCode763().partitionLabels("").equals(Arrays.asList()));
        Assert.assertTrue(new LeetCode763().partitionLabels("a").equals(Arrays.asList(1)));
        Assert.assertTrue(new LeetCode763().partitionLabels("ab").equals(Arrays.asList(1,1)));
        Assert.assertTrue(new LeetCode763().partitionLabels("abc").equals(Arrays.asList(1,1,1)));
        Assert.assertTrue(new LeetCode763().partitionLabels("abcb").equals(Arrays.asList(1,3)));
        Assert.assertTrue(new LeetCode763().partitionLabels("abca").equals(Arrays.asList(4)));
        Assert.assertTrue(new LeetCode763().partitionLabels("abcab").equals(Arrays.asList(5)));
        Assert.assertTrue(new LeetCode763().partitionLabels("abcabc").equals(Arrays.asList(6)));
        Assert.assertTrue(new LeetCode763().partitionLabels("abcabcd").equals(Arrays.asList(6, 1)));
        Assert.assertTrue(new LeetCode763().partitionLabels("abcabcde").equals(Arrays.asList(6, 1, 1)));
        Assert.assertTrue(new LeetCode763().partitionLabels("abcabcdde").equals(Arrays.asList(6, 2, 1)));
        Assert.assertTrue(new LeetCode763().partitionLabels("abcabcdded").equals(Arrays.asList(6, 4)));
        Assert.assertTrue(new LeetCode763().partitionLabels("abcabcfdded").equals(Arrays.asList(6, 1, 4)));
        Assert.assertTrue(new LeetCode763().partitionLabels("ababcbacadefegdehijhklij").equals(Arrays.asList(9,7,8)));
    }
}