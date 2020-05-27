package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LeetCode40Test {

    @Test
    public void combinationSum2() {
        LeetCode40 leetCode40 = new LeetCode40();
        List<List<Integer>> res = leetCode40.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        Assert.assertEquals(Arrays.asList(1, 1, 6), res.get(0));
        Assert.assertEquals(Arrays.asList(1, 2, 5), res.get(1));
        Assert.assertEquals(Arrays.asList(1, 7), res.get(2));
        Assert.assertEquals(Arrays.asList(2, 6), res.get(3));
        res = leetCode40.combinationSum2(new int[]{2,5,2,1,2}, 5);
        Assert.assertEquals(Arrays.asList(1, 2, 2), res.get(0));
        Assert.assertEquals(Arrays.asList(5), res.get(1));
    }
}