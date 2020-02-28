package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode994Test {

    @Test
    public void orangesRotting() {
        LeetCode994 leetCode994 = new LeetCode994();
        Assert.assertEquals(-1, leetCode994.orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
        Assert.assertEquals(4, leetCode994.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        Assert.assertEquals(-1, leetCode994.orangesRotting(new int[][]{{1, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        Assert.assertEquals(0, leetCode994.orangesRotting(new int[][]{{0, 2}}));
        Assert.assertEquals(1, leetCode994.orangesRotting(new int[][]{{2,2},{1,1},{0,0},{2,0}}));

    }
}