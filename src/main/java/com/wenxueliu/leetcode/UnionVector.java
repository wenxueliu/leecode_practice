package com.wenxueliu.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
* @author liuwenxue
* @date 2020-05-26
*/
public class UnionVector {
    Map<String, String> map = new HashMap<>();
    int count;

    UnionVector(Set<String> set) {
        count = set.size();
        for (String ele : set) {
            map.put(ele,  ele);
        }
    }

    void union(String lvalue, String rvalue) {
        String left = find(lvalue);
        String right = find(rvalue);
        if (!left.equals(right)) {
            count--;
            map.put(right, left);
        }
    }

    // 1,2  2,3  3,3
    //
    String find(String value) {
        while (!map.get(value).equals(value)) {
            value = map.get(map.get(value));
        }
        return map.get(value);
    }

    boolean isConnect(String left, String right) {
        return find(left).equals(find(right));
    }
}
