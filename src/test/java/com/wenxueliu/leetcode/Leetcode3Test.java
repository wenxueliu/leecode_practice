package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Leetcode3Test {


    @Test
    public void lengthOfLongestSubstring() {
        Leetcode3 leetCode3 = new Leetcode3();
        Assert.assertEquals(3, leetCode3.lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals(3, leetCode3.lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals(1, leetCode3.lengthOfLongestSubstring("bbbbbb"));
        Assert.assertEquals(3, leetCode3.lengthOfLongestSubstring("pwwkew"));
        Assert.assertEquals(2, leetCode3.lengthOfLongestSubstring("au"));
        Assert.assertEquals(2, leetCode3.lengthOfLongestSubstring("abba"));

        Assert.assertEquals(3, leetCode3.lengthOfLongestSubstring1("abcabcbb"));
        Assert.assertEquals(3, leetCode3.lengthOfLongestSubstring1("abcabcbb"));
        Assert.assertEquals(1, leetCode3.lengthOfLongestSubstring1("bbbbbb"));
        Assert.assertEquals(3, leetCode3.lengthOfLongestSubstring1("pwwkew"));
        Assert.assertEquals(2, leetCode3.lengthOfLongestSubstring1("au"));
        Assert.assertEquals(2, leetCode3.lengthOfLongestSubstring1("abba"));

        Assert.assertEquals(3, leetCode3.lengthOfLongestSubstring2("abcabcbb"));
        Assert.assertEquals(3, leetCode3.lengthOfLongestSubstring2("abcabcbb"));
        Assert.assertEquals(1, leetCode3.lengthOfLongestSubstring2("bbbbbb"));
        Assert.assertEquals(3, leetCode3.lengthOfLongestSubstring2("pwwkew"));
        Assert.assertEquals(2, leetCode3.lengthOfLongestSubstring2("au"));
        Assert.assertEquals(2, leetCode3.lengthOfLongestSubstring2("abba"));
    }
}