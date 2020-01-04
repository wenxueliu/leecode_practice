package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class LeetCode729Test {

    @Test
    public void book() {
        MyCalendar myCalendar = new MyCalendar();
        Assert.assertEquals(true, myCalendar.book(10, 20));
        Assert.assertEquals(false, myCalendar.book(15, 25));
        Assert.assertEquals(true, myCalendar.book(20, 30));
    }
}