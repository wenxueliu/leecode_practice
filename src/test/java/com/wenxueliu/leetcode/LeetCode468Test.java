package com.wenxueliu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.junit.Assert.*;

public class LeetCode468Test {

    @Test
    public void validIPAddress() {
        Map<String, String> map = new HashMap<>();
        map.put("172.16.254.254","IPv4");
        map.put("172.16.254.256","Neither");
        map.put("172.16.254.01","Neither");
        map.put("172..254.1","Neither");
        map.put("172.1.254.1.","Neither");
        map.put(".172.1.254.1.","Neither");
        map.put("2001:0db8:85a3:0000:0000:8a2e:0370:7334", "IPv6");
        map.put("2001:0db8:85a3:0:0000:8a2e:0370:7334", "IPv6");
        map.put("2001:0db8:85a3:0:0000:8a2e:0370:4", "IPv6");
        map.put("2001:0db8:85a3:0::8a2e:0370:4","Neither");
        map.put("2001:db8:85a3:0:0:8A2E:0370:7334","IPv6");
        map.put("2001:0db8:85a3:0:0:8A2E:0370:7334:","Neither");
        map.put("2001:0db8:85a3:0::0:8A2E:0370:","Neither");
        map.put(":2001:0db8:85a3:0:1:8A2E:0370","Neither");
        map.put("20EE:FGb8:85a3:0:0:8A2E:0370:7334","Neither");
        LeetCode468 leetCode468 = new LeetCode468();
        for (String key : map.keySet()) {
            Assert.assertEquals(map.get(key), leetCode468.validIPAddress(key));
        }
    }
}