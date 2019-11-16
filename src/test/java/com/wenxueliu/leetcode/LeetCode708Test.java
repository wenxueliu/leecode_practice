package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class LeetCode708Test {

    @Test
    public void insert() {
        test(new int[]{1, 2, 4, 5}, 3, new int[]{1, 2, 3, 4, 5});
        test(new int[]{1, 2, 4, 5}, 0, new int[]{1, 2, 4, 5, 0});
        test(new int[]{1, 2, 4, 5}, 6, new int[]{1, 2, 4, 5, 6});
        test(new int[]{3, 3, 3, 3}, 3, new int[]{3, 3, 3, 3, 3});
        test(new int[]{3, 3, 3, 3}, 0, new int[]{3, 3, 3, 3, 0});
        test(new int[]{3, 3, 3, 3}, 5, new int[]{3, 3, 3, 3, 5});
    }

    void test(int[] source, int insertVal, int[]target) {
        LeetCode708 leetCode708 = new LeetCode708();
        Node head = NodeUtils.fromArray(source);
        int [] res = NodeUtils.toArray(leetCode708.insert(head, insertVal));
        Arrays.sort(res);
        Arrays.sort(target);
        Assert.assertArrayEquals(res, target);
    }
}