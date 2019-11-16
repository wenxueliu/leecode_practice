package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode203Test {

    @Test
    public void removeElements() {
        Assert.assertArrayEquals(remove(new int[] {1}, 1), new int[]{});
        Assert.assertArrayEquals(remove(new int[] {1, 1}, 1), new int[]{});
        Assert.assertArrayEquals(remove(new int[] {1, 1, 2}, 1), new int[]{2});
        Assert.assertArrayEquals(remove(new int[] {1, 1, 2}, 2), new int[]{1, 1});
        Assert.assertArrayEquals(remove(new int[] {1, 1, 3, 4, 5}, 1), new int[]{3, 4, 5});
        Assert.assertArrayEquals(remove(new int[] {1, 1, 3, 5, 5}, 5), new int[]{1, 1, 3});
        Assert.assertArrayEquals(remove(new int[] {1, 1, 3, 5, 5}, 3), new int[]{1, 1, 5, 5});
    }

    int[] remove(int[]source, int val) {
        LeetCode203 leetCode203 = new LeetCode203();
        ListNode head = ListNodeUtils.fromArray(source);
        ListNode newHead = leetCode203.removeElements(head, val);
        int []target =ListNodeUtils.toArray(newHead);
        return target;
    }


}