package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LeetCode39Test {

    @Test
    public void combinationSum() {
        LeetCode39 leetCode39 = new LeetCode39();
        List<List<Integer>> res = leetCode39.combinationSum(new int[]{2,3,6,7}, 7);
        Assert.assertEquals(Arrays.asList(2, 2, 3), res.get(0));
        Assert.assertEquals(Arrays.asList(7), res.get(1));
        res = leetCode39.combinationSum(new int[]{2,3,5}, 8);
        Assert.assertEquals(Arrays.asList(2, 2, 2, 2), res.get(0));
        Assert.assertEquals(Arrays.asList(2, 3, 3), res.get(1));
        Assert.assertEquals(Arrays.asList(3, 5), res.get(2));
    }

    @Test
    public void combinationSum1() {
        LeetCode39 leetCode39 = new LeetCode39();
        List<List<Integer>> res = leetCode39.combinationSum(new int[]{2,3,6,7}, 7);
        Assert.assertEquals(Arrays.asList(2, 2, 3), res.get(0));
        Assert.assertEquals(Arrays.asList(7), res.get(1));
        res = leetCode39.combinationSum(new int[]{2,3,5}, 8);
        Assert.assertEquals(Arrays.asList(2, 2, 2, 2), res.get(0));
        Assert.assertEquals(Arrays.asList(2, 3, 3), res.get(1));
        Assert.assertEquals(Arrays.asList(3, 5), res.get(2));
    }

    @Test
    public void combinationSum2() {
        LeetCode39 leetCode39 = new LeetCode39();
        List<List<Integer>> res = leetCode39.combinationSum(new int[]{2,3,6,7}, 7);
        Assert.assertEquals(Arrays.asList(2, 2, 3), res.get(0));
        Assert.assertEquals(Arrays.asList(7), res.get(1));
        res = leetCode39.combinationSum(new int[]{2,3,5}, 8);
        Assert.assertEquals(Arrays.asList(2, 2, 2, 2), res.get(0));
        Assert.assertEquals(Arrays.asList(2, 3, 3), res.get(1));
        Assert.assertEquals(Arrays.asList(3, 5), res.get(2));
    }
}