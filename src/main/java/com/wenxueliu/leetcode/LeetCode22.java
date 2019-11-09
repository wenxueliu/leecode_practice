package com.wenxueliu.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ： liuwenxue
 * @date ：2019/11/05 01:07
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode22
 * @modifiedBy ：
 */
public class LeetCode22 {

    List<String> list = new ArrayList<String>();

    /**
     * 思路：递归，凡是涉及到每步的数量不定情况，都可以用递归解决
     * 实现：
     * 1. 终止条件
     * 2. 左边括号不能大于右边括号，因此当左边括号和右边括号相同的时候，以只能添加左边括号
     * 时间：超过 99%
     *
     * 扩展实现：用数组替代 StringBuilder
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return Collections.emptyList();
        }
        StringBuilder str = new StringBuilder();
        generate(str, 0, 0, 0, n * 2);
        return list;
    }

    void generate(StringBuilder str, int leftSize, int rightSize, int size,  int capicity) {
        if (leftSize + rightSize == capicity) {
            list.add(str.toString());
        } else {
            if (leftSize == rightSize) {
                str.append('(');
                generate(str, leftSize+1, rightSize, size + 1, capicity);
            } else if (leftSize < capicity / 2 && leftSize > rightSize) {
                int len = str.length();
                str.append('(');
                generate(str, leftSize + 1, rightSize, size + 1, capicity);

                str.delete(len, str.length());
                str.append(')');
                generate(str, leftSize, rightSize+1, size + 1, capicity);
            } else {
                str.append(')');
                generate(str, leftSize, rightSize+1, size + 1, capicity);
            }
        }
    }
}
