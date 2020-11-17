package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class LeetCode213Test {

    @Test
    public void rob1() {
        Assert.assertEquals(new LeetCode213().rob(new int[]{2, 3, 2}), 3);
        Assert.assertEquals(new LeetCode213().rob(new int[]{1, 2, 3, 1}), 4);
        Assert.assertEquals(new LeetCode213().rob(new int[]{1, 1, 2, 1}), 3);
        Assert.assertEquals(new LeetCode213().rob(new int[]{1, 3, 1, 3, 100}), 103);
    }

}