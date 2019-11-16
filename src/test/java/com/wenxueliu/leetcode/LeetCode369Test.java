package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LeetCode369Test {

    @Test
    public void plusOne() {
        Assert.assertArrayEquals(plusOne(new int[]{1, 2, 3}), new int[] {1, 2, 4});
        Assert.assertArrayEquals(plusOne(new int[]{1, 2, 9}), new int[] {1, 3, 0});
        Assert.assertArrayEquals(plusOne(new int[]{1, 9, 9}), new int[] {2, 0, 0});
        Assert.assertArrayEquals(plusOne(new int[]{9, 9, 9}), new int[] {1, 0, 0, 0});
    }

    int[] plusOne(int[] sources) {
        LeetCode369 leetCode369 = new LeetCode369();
        ListNode head = leetCode369.plusOne(ListNodeUtils.fromArray(sources));
        return ListNodeUtils.toArray(head);
    }
}