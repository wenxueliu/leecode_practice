package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode81Test {

    @Test
    public void search() {
        LeetCode81 leetCode81 = new LeetCode81();
        Assert.assertEquals(leetCode81.search(new int[]{1, 2, 3, 4, 5, 6, 1}, 1), true);
        Assert.assertEquals(leetCode81.search(new int[]{1, 1, 2, 3, 4, 5, 6, 1, 1}, 1), true);
        Assert.assertEquals(leetCode81.search(new int[]{3, 4, 5, 6, 1, 1, 1, 2}, 1), true);
        Assert.assertEquals(leetCode81.search(new int[]{2, 3, 4, 5, 6, 1, 1, 1}, 1), true);
        Assert.assertEquals(leetCode81.search(new int[]{2, 3, 4, 5, 6, 1, 1, 1, 2, 2}, 1), true);
        Assert.assertEquals(leetCode81.search(new int[]{2, 1, 1, 1}, 1), true);
        Assert.assertEquals(leetCode81.search(new int[]{2, 1, 1, 1, 1}, 1), true);
        Assert.assertEquals(leetCode81.search(new int[]{1, 2, 1, 1, 1, 1}, 1), true);
        Assert.assertEquals(leetCode81.search(new int[]{1, 1, 2, 1, 1, 1, 1}, 1), true);
        Assert.assertEquals(leetCode81.search(new int[]{1}, 1), true);
        Assert.assertEquals(leetCode81.search(new int[]{1, 1}, 1), true);
        Assert.assertEquals(leetCode81.search(new int[]{1, 1, 1}, 1), true);
        Assert.assertEquals(leetCode81.search(new int[]{1, 2, 1}, 1), true);
        Assert.assertEquals(leetCode81.search(new int[]{1, 2, 2, 1}, 1), true);
        Assert.assertEquals(leetCode81.search(new int[]{1, 2, 2, 2, 1}, 1), true);
        Assert.assertEquals(leetCode81.search(new int[]{1, 2, 3, 3, 1}, 1), true);
        Assert.assertEquals(leetCode81.search(new int[]{3, 1, 1, 2, 2, 2, 3}, 1), true);
        Assert.assertEquals(leetCode81.search(new int[]{3, 3, 1, 1, 2, 2, 2, 3}, 1), true);
    }
}