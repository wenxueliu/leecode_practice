package com.wenxueliu.leetcode;

import java.util.Stack;

/**
 * @author liuwenxue
 * @date 2020-09-08
 *
 * 09-18 再次通过，本题 done
 */
public class LeetCode901 {
    Stack<Integer> prices, weights;

    public LeetCode901() {
        prices = new Stack();
        weights = new Stack();
    }

    public int next(int price) {
        int w = 1;
        while (!prices.isEmpty() && prices.peek() <= price) {
            prices.pop();
            w += weights.pop();
        }

        prices.push(price);
        weights.push(w);
        return w;
    }
}
