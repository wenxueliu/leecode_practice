package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class LeetCode310Test {

    @Test
    public void findMinHeightTrees() {
        //Assert.assertTrue(new LeetCode310().findMinHeightTrees(4, new int[][]{{1,0},{1,2},{1,3}}).equals(Arrays.asList(1)));
        Assert.assertTrue(new LeetCode310().findMinHeightTrees(6, new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}}).equals(Arrays.asList(3, 4)));
    }
}