package com.wenxueliu.leetcode;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LeetCode2Test {

    @Test
    public void addTwoNumbers() {
        LeetCode2 leetCode2 = new LeetCode2();

        assertTrue(listNodeEqual(
                leetCode2.addTwoNumbers( arrtyToListNode(new int[]{}), arrtyToListNode(new int[]{})),
                arrtyToListNode(new int[]{})
        ));

        assertTrue(listNodeEqual(
                leetCode2.addTwoNumbers( arrtyToListNode(new int[]{1, 2, 5}), arrtyToListNode(new int[]{2, 3, 6})),
                arrtyToListNode(new int[]{3, 5, 1, 1})
        ));

        assertTrue(listNodeEqual(
                leetCode2.addTwoNumbers( arrtyToListNode(new int[]{1, 2, 5}), arrtyToListNode(new int[]{2, 3, 3})),
                arrtyToListNode(new int[]{3, 5, 8})
        ));

        assertTrue(listNodeEqual(
                leetCode2.addTwoNumbers( arrtyToListNode(new int[]{1, 2, 5}), arrtyToListNode(new int[]{2, 3, 6, 8})),
                arrtyToListNode(new int[]{3, 5, 1, 9})
        ));

        assertTrue(listNodeEqual(
                leetCode2.addTwoNumbers( arrtyToListNode(new int[]{1, 2, 5}), arrtyToListNode(new int[]{2, 3, 6, 9})),
                arrtyToListNode(new int[]{3, 5, 1, 0, 1})
        ));
    }

    @Test
    public void addTwoNumbers1() {
        LeetCode2 leetCode2 = new LeetCode2();

        assertTrue(listNodeEqual(
                leetCode2.addTwoNumbers1( arrtyToListNode(new int[]{}), arrtyToListNode(new int[]{})),
                arrtyToListNode(new int[]{})
        ));

        assertTrue(listNodeEqual(
                leetCode2.addTwoNumbers1( arrtyToListNode(new int[]{1, 2, 5}), arrtyToListNode(new int[]{2, 3, 6})),
                arrtyToListNode(new int[]{3, 5, 1, 1})
        ));

        assertTrue(listNodeEqual(
                leetCode2.addTwoNumbers1( arrtyToListNode(new int[]{1, 2, 5}), arrtyToListNode(new int[]{2, 3, 3})),
                arrtyToListNode(new int[]{3, 5, 8})
        ));

        assertTrue(listNodeEqual(
                leetCode2.addTwoNumbers1( arrtyToListNode(new int[]{1, 2, 5}), arrtyToListNode(new int[]{2, 3, 6, 8})),
                arrtyToListNode(new int[]{3, 5, 1, 9})
        ));

        assertTrue(listNodeEqual(
                leetCode2.addTwoNumbers1( arrtyToListNode(new int[]{1, 2, 5}), arrtyToListNode(new int[]{2, 3, 6, 9})),
                arrtyToListNode(new int[]{3, 5, 1, 0, 1})
        ));
    }

    @Test
    public void addTwoNumbers2() {
        LeetCode2 leetCode2 = new LeetCode2();

        assertTrue(listNodeEqual(
                leetCode2.addTwoNumbers2( arrtyToListNode(new int[]{}), arrtyToListNode(new int[]{})),
                arrtyToListNode(new int[]{})
        ));

        assertTrue(listNodeEqual(
                leetCode2.addTwoNumbers2( arrtyToListNode(new int[]{1, 2, 5}), arrtyToListNode(new int[]{2, 3, 6})),
                arrtyToListNode(new int[]{3, 5, 1, 1})
        ));

        assertTrue(listNodeEqual(
                leetCode2.addTwoNumbers2( arrtyToListNode(new int[]{1, 2, 5}), arrtyToListNode(new int[]{2, 3, 3})),
                arrtyToListNode(new int[]{3, 5, 8})
        ));

        assertTrue(listNodeEqual(
                leetCode2.addTwoNumbers2( arrtyToListNode(new int[]{1, 2, 5}), arrtyToListNode(new int[]{2, 3, 6, 8})),
                arrtyToListNode(new int[]{3, 5, 1, 9})
        ));

        assertTrue(listNodeEqual(
                leetCode2.addTwoNumbers2( arrtyToListNode(new int[]{1, 2, 5}), arrtyToListNode(new int[]{2, 3, 6, 9})),
                arrtyToListNode(new int[]{3, 5, 1, 0, 1})
        ));
    }


    boolean listNodeEqual(ListNode left, ListNode right) {
        if (left == null && right == null) {
            return true;
        }
        while (left.next != null && right.next != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    ListNode arrtyToListNode(int[] values) {
        if (values.length == 0) {
            return null;
        }
        ListNode head = new ListNode(values[0]);
        ListNode p = head;
        for (int i = 1; i < values.length; i++) {
            ListNode node = new ListNode(values[i]);
            p.next = node;
            p = p.next;
        }
        return head;
    }
}