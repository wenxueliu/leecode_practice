package com.wenxueliu.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
* @author liuwenxue
* @date 2020-05-26
*/
public class LeetCode990 {

    public boolean equationsPossible(String[] equations) {

        Set<String> set = new HashSet<>();
        for (String equation : equations) {
            set.add(String.valueOf(equation.charAt(0)));
            set.add(String.valueOf(equation.charAt(3)));
        }
        int len = set.size();
        UnionVector unionVector= new UnionVector(set);
        for (String equation : equations) {
            if (equation.contains("==")) {
                unionVector.union(String.valueOf(equation.charAt(0)), String.valueOf(equation.charAt(3)));
            }
        }
        for (String equation : equations) {
            if (equation.contains("!=")) {
                if (unionVector.isConnect(String.valueOf(equation.charAt(0)), String.valueOf(equation.charAt(3)))) {
                    return false;
                }
            }
        }
        return true;
    }
}
