package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode567Test {

    @Test
    public void checkInclusion() {
        LeetCode567 leetCode567 = new LeetCode567();
        Assert.assertEquals(true, leetCode567.checkInclusion("ab", "ba"));
        Assert.assertEquals(false, leetCode567.checkInclusion("ab", "ca"));
        Assert.assertEquals(true, leetCode567.checkInclusion("ab", "eidbaooo"));
        Assert.assertEquals(false, leetCode567.checkInclusion("ab", "eidboaoo"));
        Assert.assertEquals(true, leetCode567.checkInclusion("trinitrophenylmethylnitramine", "dinitrophenylhydrazinetrinitrophenylmethylnitramine"));
        Assert.assertEquals(true, leetCode567.checkInclusion("trinitrophenylmethylnitramine", "dinitrophenylhydrazinetrinitrophenylmethylnitramine"));
    }

    @Test
    public void checkInclusion1() {
        LeetCode567 leetCode567 = new LeetCode567();
        Assert.assertEquals(true, leetCode567.checkInclusion("ab", "ba"));
        Assert.assertEquals(false, leetCode567.checkInclusion("ab", "ca"));
        Assert.assertEquals(true, leetCode567.checkInclusion("ab", "eidbaooo"));
        Assert.assertEquals(false, leetCode567.checkInclusion("ab", "eidboaoo"));
        Assert.assertEquals(true, leetCode567.checkInclusion1("trinitrophenylmethylnitramine", "dinitrophenylhydrazinetrinitrophenylmethylnitramine"));
    }
}