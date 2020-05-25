package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode990Test {

    @Test
    public void equationsPossible() {
        LeetCode990 leetCode990 = new LeetCode990();
        Assert.assertFalse(leetCode990.equationsPossible(new String[] {"a==b","b!=a"}));
        Assert.assertTrue(leetCode990.equationsPossible(new String[] {"a==b","b-=a"}));
        Assert.assertTrue(leetCode990.equationsPossible(new String[] {"a==b","b==c","a==c"}));
        Assert.assertFalse(leetCode990.equationsPossible(new String[] {"a==b","b!=c","c==a"}));
        Assert.assertTrue(leetCode990.equationsPossible(new String[] {"c==c","b==d","x!=z"}));
    }
}