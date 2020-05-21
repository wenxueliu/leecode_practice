package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LeetCode721Test {

    @Test
    public void accountsMerge() {
        LeetCode721 leetCode721 = new LeetCode721();
        List<List<String>>  input = new ArrayList<>();
        input.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        input.add(Arrays.asList("John", "johnnybravo@mail.com"));
        input.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        input.add(Arrays.asList("Mary", "mary@mail.com"));
        List<List<String>> result = leetCode721.accountsMerge(input);
        Assert.assertTrue(result.get(0).equals(Arrays.asList("John", "johnnybravo@mail.com")));
        Assert.assertTrue(result.get(1).equals(Arrays.asList("John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com")));
        Assert.assertTrue(result.get(2).equals(Arrays.asList("Mary", "mary@mail.com")));
    }
}