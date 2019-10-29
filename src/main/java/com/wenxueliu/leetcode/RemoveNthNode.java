package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/10/30 00:58
 * @description :
 * @path : com.wenxueliu.leetcode.RemoveNthNode
 * @modifiedBy ：
 * 10-29
 * 思路： 一个快指针，一个慢指针
 * 实现：用时 20 分钟。
 * 考虑情况
 * 1. [1] 1
 * 2. [1, 2] 1
 * 3. [1, 2] 2
 * 4. [1, 2, 3] 1
 * 4. [1, 2, 3] 2
 * 4. [1, 2, 3] 3
 */
public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return head.next;
        }
        ListNode slow = head;
        ListNode fast = head;
        // n = 3 1
        // n = 2 2
        // n = 1 4
        // n = 0 null

        //n = 1 1
        //n = 0 2
        while (n > 0 && fast != null) {
            n--;
            fast = fast.next;
        }
        if (n != 0) {
            return head;
        }
        if (fast == null && n == 0) {
            return head.next;
        }
        if (fast != null) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
