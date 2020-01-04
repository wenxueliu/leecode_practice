package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;


public class LeetCode732Test {

    @Test
    public void book() {
        MyCalendarThree myCalendarThree = new MyCalendarThree();
        Assert.assertEquals(1, myCalendarThree.book(10, 20));
        Assert.assertEquals(1, myCalendarThree.book(50, 60));
        Assert.assertEquals(2, myCalendarThree.book(10, 40));
        Assert.assertEquals(3, myCalendarThree.book(5, 15));
        Assert.assertEquals(3, myCalendarThree.book(5, 10));
        Assert.assertEquals(3, myCalendarThree.book(25, 55));
    }
}