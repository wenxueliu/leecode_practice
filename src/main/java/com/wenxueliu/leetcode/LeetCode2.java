package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/10/30 00:24
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode2
 * @modifiedBy ：
 *
 * 10-29
 * 思路：正常的整数加法
 * 实现：用时 1 个小时。 主要是结果列表无法正确串联花费了不少时间调试。
 * 考虑的因素：
 * 1. 两个都是空；[] []
 * 2. 一个空，一个非空； [5] [] 或 [] [5]
 * 3. 长度一样有进位 [1, 2, 5] [2, 3, 6]
 * 3. 长度一样无进位 [1, 2, 5] [2, 3, 3]
 * 4. 长度不一样，较长列表有进位 [1, 2, 5] [2, 3, 6, 8]
 * 5. 长度不一样，较长列表有进位 [1, 2, 5] [2, 3, 6, 9]
 *
 */
public class LeetCode2 {
    /*
     * 10.29:
     * 无哨兵解法解法
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode p3 = null;
        ListNode head = null;
        int carry = 0;
        int i = 0;
        while (p1 != null && p2 != null) {
            int sum = p1.val + p2.val + carry;
            carry = sum / 10;
            int val = sum % 10;
            ListNode p = new ListNode(val);
            p.next = null;
            if (i == 0) {
                head = p;
                p3 = p;
            } else {
                p3.next = p;
                p3 = p3.next;
            }
            i++;

            p1 = p1.next;
            p2 = p2.next;
        }

        while (p1 != null) {
            int sum = p1.val + carry;
            carry = sum / 10;
            int val = sum % 10;
            ListNode p = new ListNode(val);

            if (p3 != null) {
                p3.next = p;
                p3 = p3.next;
            } else {
                p3 = p;
            }

            p1 = p1.next;
        }

        while (p2 != null) {
            int sum = p2.val + carry;
            carry = sum / 10;
            int val = sum % 10;
            ListNode p = new ListNode(val);
            p.next = null;

            if (p3 != null) {
                p3.next = p;
                p3 = p3.next;
            } else {
                p3 = p;
            }


            p2 = p2.next;
        }

        if (carry != 0) {
            ListNode p = new ListNode(carry);
            p.next = null;
            p3.next = p;
            p3 = p3.next;
        }
        return head;

    }


    /*
     * 10.29:
     * 有哨兵解法
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode p3 = new ListNode(0);
        ListNode head = p3;
        int carry = 0;
        int i = 0;
        while (p1 != null && p2 != null) {
            int sum = p1.val + p2.val + carry;
            carry = sum / 10;
            int val = sum % 10;
            ListNode p = new ListNode(val);
            p.next = null;
            p3.next = p;
            p3 = p3.next;

            p1 = p1.next;
            p2 = p2.next;
        }

        while (p1 != null) {
            int sum = p1.val + carry;
            carry = sum / 10;
            int val = sum % 10;
            ListNode p = new ListNode(val);
            p3.next = p;
            p3 = p3.next;

            p1 = p1.next;
        }

        while (p2 != null) {
            int sum = p2.val + carry;
            carry = sum / 10;
            int val = sum % 10;
            ListNode p = new ListNode(val);
            p.next = null;

            p3.next = p;
            p3 = p3.next;

            p2 = p2.next;
        }

        if (carry != 0) {
            ListNode p = new ListNode(carry);
            p.next = null;
            p3.next = p;
            p3 = p3.next;
        }
        return head.next;
    }

    /*
     * 10.29:
     * 仅仅减少了一次空赋值，算法时间 就由超过 80% 变为 99.98
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode p3 = new ListNode(0);
        ListNode head = p3;
        int carry = 0;
        int i = 0;
        while (p1 != null && p2 != null) {
            int sum = p1.val + p2.val + carry;
            carry = sum / 10;
            int val = sum % 10;
            ListNode p = new ListNode(val);
            p3.next = p;
            p3 = p3.next;

            p1 = p1.next;
            p2 = p2.next;
        }

        while (p1 != null) {
            int sum = p1.val + carry;
            carry = sum / 10;
            int val = sum % 10;
            ListNode p = new ListNode(val);
            p3.next = p;
            p3 = p3.next;

            p1 = p1.next;
        }

        while (p2 != null) {
            int sum = p2.val + carry;
            carry = sum / 10;
            int val = sum % 10;
            ListNode p = new ListNode(val);

            p3.next = p;
            p3 = p3.next;

            p2 = p2.next;
        }

        if (carry != 0) {
            ListNode p = new ListNode(carry);
            p3.next = p;
        }
        return head.next;

    }
}
