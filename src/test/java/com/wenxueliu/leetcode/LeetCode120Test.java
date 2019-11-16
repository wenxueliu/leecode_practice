package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LeetCode120Test {

    @Test
    public void minimumTotal() {
        LeetCode120 leetCode120 = new LeetCode120();
        List<List<Integer>> input = new ArrayList<>();
        Assert.assertEquals(leetCode120.minimumTotal(input), 0);

        input.clear();
        input.add(Arrays.asList(new Integer[]{1}));
        Assert.assertEquals(leetCode120.minimumTotal(input), 1);

        input.clear();
        input.add(Arrays.asList(new Integer[]{1}));
        input.add(Arrays.asList(new Integer[]{1, 2}));
        input.add(Arrays.asList(new Integer[]{1, 2, 3}));
        Assert.assertEquals(leetCode120.minimumTotal(input), 3);

        input.clear();
        input.add(Arrays.asList(new Integer[]{1}));
        input.add(Arrays.asList(new Integer[]{2, 1}));
        input.add(Arrays.asList(new Integer[]{3, 2, 1}));
        Assert.assertEquals(leetCode120.minimumTotal(input), 3);

        input.clear();
        input.add(Arrays.asList(new Integer[]{1}));
        input.add(Arrays.asList(new Integer[]{1, 1}));
        input.add(Arrays.asList(new Integer[]{2, 1, 3}));
        Assert.assertEquals(leetCode120.minimumTotal(input), 3);
    }

    @Test
    public void minimumTotal1() {
    }
}