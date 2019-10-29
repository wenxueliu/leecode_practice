package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/10/29 01:34
 * @description :
 * @path : com.wenxueliu.leetcode.PalindromeLinkedList
 * @modifiedBy ：
 *
 * 10-28
 * 思路：参考自别人
 * 实现：用时 1 个小时。第一次提交，将 head == null 判断为 false。第二次提交通过。
 *
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;

        int i = 1;
        while(fast.next != null) {
            fast = fast.next;
            if (i % 2 == 0) {
                slow = slow.next;
            }
            i++;
        }

        if (i == 1) {
            return slow.val == fast.val;
        }

        //slow = 2
        slow = slow.next;

        ListNode start = reverse(slow);
        ListNode begin = head;

        while (start != null && begin != null) {
            if (start.val != begin.val) {
                return false;
            }
            start = start.next;
            begin = begin.next;
        }
        return true;
    }

    ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            ListNode first = head;
            ListNode second = head.next;
            second.next = first;
            first.next = null;
            return second;
        }
        ListNode first = head;
        ListNode second = first.next;

        first.next = null;
        ListNode third = second.next;
        second.next = first;

        while (third != null) {
            first = third;
            third = first.next;
            first.next = second;
            second = first;
        }
        return first;
    }
}
