package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.junit.Assert.*;

public class LeetCode20Test {

    @Test
    public void isValid() {

        LeetCode20 leetCode20 = new LeetCode20();
        Map<String, Boolean> map = new HashMap<>();
        map.put("", true);
        map.put("()", true);
        map.put("()()()", true);
        map.put("(())", true);
        map.put("(())()", true);
        map.put("())", false);
        map.put("(()", false);
        map.put("(()))()", false);
        map.put("((())())", true);
        map.put(")(", false);
        map.put("))(()(", false);
        map.put("(()))(", false);
        for (String key : map.keySet()) {
            Assert.assertTrue(leetCode20.isValid(key) == map.get(key));
        }
    }
}