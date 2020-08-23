package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode1095Test {

    @Test
    public void findInMountainArray() {
        Assert.assertEquals(2, new LeetCode1095().findInMountainArray(3, new MountainArray(new int[]{1,2,3,4,5,3,1})));;
        Assert.assertEquals(1, new LeetCode1095().findInMountainArray(2, new MountainArray(new int[]{1,2,3,4,5,3,1})));;
        Assert.assertEquals(1, new LeetCode1095().findInMountainArray(2, new MountainArray(new int[]{1,2,2,3,4,5,3,1})));;
        Assert.assertEquals(5, new LeetCode1095().findInMountainArray(5, new MountainArray(new int[]{1,2,3,4,6,5,1})));;
        Assert.assertEquals(5, new LeetCode1095().findInMountainArray(5, new MountainArray(new int[]{1,2,3,4,6,5,5,1})));;
        Assert.assertEquals(-1, new LeetCode1095().findInMountainArray(3, new MountainArray(new int[]{0,1,2,4,2,1})));;
        Assert.assertEquals(3, new LeetCode1095().findInMountainArray(3, new MountainArray(new int[]{0,1,2,3,2,1})));;
        Assert.assertEquals(4, new LeetCode1095().findInMountainArray(0, new MountainArray(new int[]{3,5,3,2,0})));;
    }
}