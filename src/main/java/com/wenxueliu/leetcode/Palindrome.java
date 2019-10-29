package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/10/10 23:52
 * @description :
 * @path : PACKAGE_NAME.com.wenxueliu.leetcode.Palindrome
 * @modifiedBy ：
 * LeeCode : 234. Palindrome Linked List
 */
public class Palindrome {

    /**
     * @author : liuwenxue
     * @date : 2019-10-10 23:59
     * @description：
     * @param head
     * @return
     * @throws
     *
     * aa
     * ab
     * aba
     * abba
     * abcd
     * abcdef
     * abccba
    **/
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        if (head.next != null && head.next.next == null) {
            if (head.val == head.next.val) {
                return true;
            } else {
                return false;
            }
        }

        ListNode slow = head;
        ListNode fast = head;


        //奇数 1 2 3 slow=3 fast=3
        //偶数 1 2 3 4  slow = 3 fast = 4
        while (slow != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null && fast.next != null) {
                fast = fast.next;
            } else {
                break;
            }
        }
        System.out.println("slow = " + slow.val);

        ListNode mark = slow;
        ListNode right = reverseNode(slow);
        ListNode left = head;

        while (left != null && right != null) {
            if (left.val == right.val) {
                right = right.next;
                left = left.next;
            }
            else
            {
                return false;
            }
        }
        return true;
    }

    public ListNode reverseNode(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode left, right;
        //a
        left = head;
        //b
        head = head.next;
        //b
        right = head;
        //c
        head = head.next;
        //ba
        right.next = left;
        left.next = null;

        while (head!=null) {
            //b
            left = right;
            //c
            right = head;
            //d
            head = head.next;
            //cba
            right.next = left;
        }
        return right;
    }

    public void travel(ListNode head) {
        StringBuilder stringBuilder = new StringBuilder();
        while (head != null) {
            stringBuilder.append(head.val);
            head = head.next;
        }
        System.out.println(stringBuilder.toString());
    }
}
