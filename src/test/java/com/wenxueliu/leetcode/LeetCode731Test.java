package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode731Test {

    @Test
    public void book() {
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        Assert.assertEquals(true, myCalendarTwo.book(10, 20));
        Assert.assertEquals(true, myCalendarTwo.book(50, 60));
        Assert.assertEquals(true, myCalendarTwo.book(10, 40));
        Assert.assertEquals(false, myCalendarTwo.book(5, 15));
        Assert.assertEquals(true, myCalendarTwo.book(5, 10));
        Assert.assertEquals(true, myCalendarTwo.book(25, 55));

    }
}