package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode9Test {

    @Test
    public void isPalindrome() {
        LeetCode9 leetCode9 = new LeetCode9();
        Assert.assertEquals(true, leetCode9.isPalindrome(0));
        Assert.assertEquals(true, leetCode9.isPalindrome(1));
        Assert.assertEquals(true, leetCode9.isPalindrome(121));
        Assert.assertEquals(false, leetCode9.isPalindrome(123));
        Assert.assertEquals(true, leetCode9.isPalindrome(1221));
        Assert.assertEquals(false, leetCode9.isPalindrome(1222));
    }

    @Test
    public void isPalindrome1() {
        LeetCode9 leetCode9 = new LeetCode9();
        Assert.assertEquals(true, leetCode9.isPalindrome1(0));
        Assert.assertEquals(true, leetCode9.isPalindrome1(1));
        Assert.assertEquals(true, leetCode9.isPalindrome1(121));
        Assert.assertEquals(false, leetCode9.isPalindrome1(123));
        Assert.assertEquals(true, leetCode9.isPalindrome1(1221));
        Assert.assertEquals(false, leetCode9.isPalindrome1(1222));
    }
}