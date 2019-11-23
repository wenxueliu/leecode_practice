package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListNodeUtilsTest {

    @Test
    public void fromArray() {
        Assert.assertArrayEquals(toArray(new int[]{}), new int[]{});
        Assert.assertArrayEquals(toArray(new int[]{1}), new int[]{1});
        Assert.assertArrayEquals(toArray(new int[]{1,2,3,4}), new int[]{1,2,3,4});
    }

    public int[] toArray(int []source) {
        ListNode head = ListNodeUtils.fromArray(source);
        return ListNodeUtils.toArray(head);

    }


}