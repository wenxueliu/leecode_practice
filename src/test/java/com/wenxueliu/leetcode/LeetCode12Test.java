package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode12Test {

    @Test
    public void intToRoman() {
        LeetCode12 leetCode12 = new LeetCode12();
        Assert.assertEquals(leetCode12.intToRoman(0), "");
        Assert.assertEquals(leetCode12.intToRoman(3), "III");
        Assert.assertEquals(leetCode12.intToRoman(4), "IV");
        Assert.assertEquals(leetCode12.intToRoman(7), "VII");
        Assert.assertEquals(leetCode12.intToRoman(9), "IX");
        Assert.assertEquals(leetCode12.intToRoman(10), "X");
        Assert.assertEquals(leetCode12.intToRoman(11), "XI");
        Assert.assertEquals(leetCode12.intToRoman(15), "XV");
        Assert.assertEquals(leetCode12.intToRoman(16), "XVI");
        Assert.assertEquals(leetCode12.intToRoman(46), "XLVI");
        Assert.assertEquals(leetCode12.intToRoman(50), "L");
        Assert.assertEquals(leetCode12.intToRoman(60), "LX");
        Assert.assertEquals(leetCode12.intToRoman(90), "XC");
        Assert.assertEquals(leetCode12.intToRoman(100), "C");
        Assert.assertEquals(leetCode12.intToRoman(110), "CX");
        Assert.assertEquals(leetCode12.intToRoman(140), "CXL");
        Assert.assertEquals(leetCode12.intToRoman(160), "CLX");
        Assert.assertEquals(leetCode12.intToRoman(190), "CXC");
        Assert.assertEquals(leetCode12.intToRoman(490), "CDXC");
        Assert.assertEquals(leetCode12.intToRoman(510), "DX");
        Assert.assertEquals(leetCode12.intToRoman(910), "CMX");
        Assert.assertEquals(leetCode12.intToRoman(1010), "MX");
        Assert.assertEquals(leetCode12.intToRoman(2010), "MMX");
    }
}