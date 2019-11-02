package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode13Test {

    @Test
    public void romanToInt() {
        LeetCode13 leetCode13 = new LeetCode13();
        Assert.assertEquals(leetCode13.romanToInt(""), 0);
        Assert.assertEquals(leetCode13.romanToInt("III"), 3);
        Assert.assertEquals(leetCode13.romanToInt("IV"), 4);
        Assert.assertEquals(leetCode13.romanToInt("VII"), 7);
        Assert.assertEquals(leetCode13.romanToInt("IX"), 9);
        Assert.assertEquals(leetCode13.romanToInt("X"), 10);
        Assert.assertEquals(leetCode13.romanToInt("XI"), 11);
        Assert.assertEquals(leetCode13.romanToInt("XV"), 15);
        Assert.assertEquals(leetCode13.romanToInt("XVI"), 16);
        Assert.assertEquals(leetCode13.romanToInt("XLVI"), 46);
        Assert.assertEquals(leetCode13.romanToInt("L"), 50);
        Assert.assertEquals(leetCode13.romanToInt("LX"), 60);
        Assert.assertEquals(leetCode13.romanToInt("XC"), 90);
        Assert.assertEquals(leetCode13.romanToInt("C"), 100);
        Assert.assertEquals(leetCode13.romanToInt("CX"), 110);
        Assert.assertEquals(leetCode13.romanToInt("CXL"), 140);
        Assert.assertEquals(leetCode13.romanToInt("CLX"), 160);
        Assert.assertEquals(leetCode13.romanToInt("CXC"), 190);
        Assert.assertEquals(leetCode13.romanToInt("CDXC"), 490);
        Assert.assertEquals(leetCode13.romanToInt("DX"), 510);
        Assert.assertEquals(leetCode13.romanToInt("CMX"), 910);
        Assert.assertEquals(leetCode13.romanToInt("MX"), 1010);
        Assert.assertEquals(leetCode13.romanToInt("MMX"), 2010);
    }
}