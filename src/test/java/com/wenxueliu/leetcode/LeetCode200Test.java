package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode200Test {

    @Test
    public void numIslands() {
        LeetCode200 leetCode200 = new LeetCode200();
        Assert.assertEquals(1, leetCode200.numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}}));
        Assert.assertEquals(3, leetCode200.numIslands(new char[][]{{'1', '1', '0', '0', '0'},{'1', '1', '0', '0', '0'},{'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}}));
    }
}