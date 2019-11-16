package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/11/16 12:11
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode203
 * @modifiedBy ：
 */
public class LeetCode203 {

    /**
     * 思路：双指针删除元素
     * 实现：略
     * 用时：20 分钟
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        //开始元素等于
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return head;
        }
        ListNode first = head;
        ListNode prev = first;
        while (first != null) {
            if (first.val == val) {
                if (first.next != null) {
                    first.val = first.next.val;
                    first.next = first.next.next;
                } else {
                    first = null;
                    prev.next = null;
                }
            } else {
                prev = first;
                first = first.next;
            }
        }
        return head;
    }


    /**
     * 采用哑节点，代码更加简洁
     * @param head 链表头
     * @param val 待删除值
     * @return 删除后的链表头
     */
    public ListNode removeElements1(ListNode head, int val) {
        ListNode stub = new ListNode(0);
        stub.next = head;
        ListNode cur = stub;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return stub.next;
    }
}
