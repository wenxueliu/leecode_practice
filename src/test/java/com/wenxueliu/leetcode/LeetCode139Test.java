package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode139Test {

    @Test
    public void wordBreak() {
        LeetCode139 leetCode139 = new LeetCode139();
        String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> list = new ArrayList(Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));
        Assert.assertEquals(false, leetCode139.wordBreak(str, list));;
        Assert.assertEquals(true, leetCode139.wordBreak("applepenapple", new ArrayList<>(Arrays.asList("apple", "pen"))));;
        Assert.assertEquals(true, leetCode139.wordBreak("leetcode", new ArrayList<>(Arrays.asList("leet", "code"))));;
        Assert.assertEquals(false, leetCode139.wordBreak("catsandog", new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"))));;
    }
}