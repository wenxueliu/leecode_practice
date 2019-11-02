package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LeetCode1Test {

    @Test
    public void twoSum() {

        LeetCode1 leetCode1 = new LeetCode1();
        Assert.assertArrayEquals(leetCode1.twoSum(new int[]{2, 11, 7, 15}, 9), new int[]{0, 2});
        Assert.assertArrayEquals(leetCode1.twoSum(new int[]{3, 2, 4}, 6), new int[]{1, 2});
        Assert.assertArrayEquals(leetCode1.twoSum(new int[]{3, 3}, 6), new int[]{0, 1});

        Assert.assertArrayEquals(leetCode1.twoSum2(new int[]{2, 11, 7, 15}, 9), new int[]{0, 2});
        Assert.assertArrayEquals(leetCode1.twoSum2(new int[]{3, 2, 4}, 6), new int[]{1, 2});
        Assert.assertArrayEquals(leetCode1.twoSum2(new int[]{3, 3}, 6), new int[]{0, 1});
    }

    static void dumpResult(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    static void dumpList(List<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            System.out.println(nums.get(i));
        }
    }
}