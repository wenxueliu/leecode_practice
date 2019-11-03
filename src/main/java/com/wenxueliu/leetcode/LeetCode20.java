package com.wenxueliu.leetcode;

import java.util.Stack;

/**
 * @author ： liuwenxue
 * @date ：2019/11/03 23:17
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode20
 * @modifiedBy ：
 */
public class LeetCode20 {


    /**
     * 11-03
     * 思路： 遇到左边压栈，遇到右边，检查左边字符是否是对应的开字符
     * 实现： 1. 左边比右边多； 2. 右边比左边多； 3. 左右一样但是不是正好对称；4. 左右对称
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            // 如果是左边字符入栈
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            }
            // 如果是右边字符入栈
            if (c == '}' || c == ')' || c == ']') {
                //栈空的话，说明没有对应的左字符
                if (stack.empty()) {
                    return false;
                }
                else {
                    //左字符是否与当前右字符匹配
                    char tmp = stack.pop();
                    if (c == '}' && tmp != '{') {
                        return false;
                    } else if (c == ')' && tmp != '(') {
                        return false;
                    } else if (c == ']' && tmp != '[') {
                        return false;
                    }
                }
            }
        }
        //如果左边不为空，说明右边缺失字符
        if (!stack.empty()) {
            return false;
        }
        return true;
    }
}
