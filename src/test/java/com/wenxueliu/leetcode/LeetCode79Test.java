package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode79Test {

    @Test
    public void exist() {
        Assert.assertTrue(new LeetCode79().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "AB"));
        Assert.assertTrue(new LeetCode79().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "AS"));
        Assert.assertTrue(new LeetCode79().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ASF"));
        Assert.assertTrue(new LeetCode79().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABFS"));
        Assert.assertTrue(new LeetCode79().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABFC"));
        Assert.assertTrue(new LeetCode79().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCC"));
        Assert.assertTrue(new LeetCode79().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCE"));
        Assert.assertTrue(new LeetCode79().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
        Assert.assertTrue(new LeetCode79().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCEE"));
        Assert.assertTrue(new LeetCode79().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCF"));
        Assert.assertTrue(new LeetCode79().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCFS"));
        Assert.assertTrue(new LeetCode79().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEE"));
        Assert.assertTrue(new LeetCode79().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEEDASFCCBA"));
    }
}