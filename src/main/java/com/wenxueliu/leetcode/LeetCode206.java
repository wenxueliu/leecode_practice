package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/11/16 11:31
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode206
 * @modifiedBy ：
 */
public class LeetCode206 {
    /**
     * 思路：利用三个指针，前两个用于翻转，最后一个用于标记
     * 实现：参考思路
     * 用时：20 分钟
     * @param head 链表头
     * @return 翻转链表头
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        ListNode third = second.next;
        head.next = null;
        if (third == null) {
            second.next = first;
            return second;
        }
        while (third != null) {
            //2->1
            //3->2
            second.next = first;
            //2
            first = second;
            //3
            second = third;
            //4
            third = third.next;
        }
        second.next = first;
        return second;
    }
}
