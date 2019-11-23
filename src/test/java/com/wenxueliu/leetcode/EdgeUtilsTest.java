package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NodeUtilsTest {

    @Test
    public void fromArray() {
        toArray(new int[] {});
        toArray(new int[] {1});
        toArray(new int[] {1,2, 3, 4});

    }

    public void toArray(int[] source) {
        Node head = NodeUtils.fromArray(source);
        int[] target = NodeUtils.toArray(head);
        Assert.assertArrayEquals(target, source);
    }
}