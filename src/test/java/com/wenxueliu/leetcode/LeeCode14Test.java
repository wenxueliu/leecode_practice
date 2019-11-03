package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeeCode14Test {

    @Test
    public void longestCommonPrefix() {
        LeetCode14 leetCode14 = new LeetCode14();

        Assert.assertEquals(
                leetCode14.longestCommonPrefix(new String[] {}),
                "");

        Assert.assertEquals(
                leetCode14.longestCommonPrefix(new String[] {"flower"}),
                "flower");

        Assert.assertEquals(
                leetCode14.longestCommonPrefix(new String[] {"flower","flower","flower"}),
                "flower");

        //strs[0]是最短的
        Assert.assertEquals(
                leetCode14.longestCommonPrefix(new String[] {"fl","flow","flight"}),
                "fl");

        //strs[0]不是最短的
        Assert.assertEquals(
                leetCode14.longestCommonPrefix(new String[] {"flower","fl","fliht"}),
                "fl");


    }
}