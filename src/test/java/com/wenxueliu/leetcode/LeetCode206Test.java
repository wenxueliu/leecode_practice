package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode206Test {

    @Test
    public void reverseList() {
        Assert.assertArrayEquals(new int[]{4, 3, 2, 1}, reverseList(new int[]{1, 2, 3, 4}));
        Assert.assertArrayEquals(new int[]{}, reverseList(new int[]{}));
        Assert.assertArrayEquals(new int[]{1}, reverseList(new int[]{1}));
        Assert.assertArrayEquals(new int[]{1,2}, reverseList(new int[]{2,1}));
    }

    int[] reverseList(int[]source) {
        LeetCode206 leetCode206 = new LeetCode206();
        ListNode head = ListNodeUtils.fromArray(source);
        ListNode reverse = leetCode206.reverseList(head);
        return ListNodeUtils.toArray(reverse);
    }

}