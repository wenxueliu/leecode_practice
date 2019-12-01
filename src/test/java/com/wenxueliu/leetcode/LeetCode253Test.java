package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode253Test {

    @Test
    public void minMeetingRooms() {
        LeetCode253 leetCode253 = new LeetCode253();
        Assert.assertEquals(1, leetCode253.minMeetingRooms(new int[][]{{13, 15}, {1, 13}}));
        Assert.assertEquals(2, leetCode253.minMeetingRooms(new int[][]{{0,30},{5,10},{15,20}}));

        Assert.assertEquals(1, leetCode253.minMeetingRooms1(new int[][]{{13, 15}, {1, 13}}));
        Assert.assertEquals(2, leetCode253.minMeetingRooms1(new int[][]{{0,30},{5,10},{15,20}}));

        Assert.assertEquals(1, leetCode253.minMeetingRooms2(new int[][]{{13, 15}, {1, 13}}));
        Assert.assertEquals(2, leetCode253.minMeetingRooms2(new int[][]{{0,30},{5,10},{15,20}}));
    }

}