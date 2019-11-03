package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/11/04 00:06
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode21
 * @modifiedBy ：
 */
public class LeetCode21 {

    //[1,2,4] [1,3,4] [1, 1, 2, 3, 4]
    //[] [] []
    //[1] [] [1]
    //[] [1] [1]
    //[1] [1] [1]
    //[1, 2] [1, 3] [1, 1, 2, 3]
    //[1, 2, 3] [1, 3] [1, 1, 2, 3, 3]
    //[1, 2, 3] [1, 3, 4, 5] [1,1,2,3,3,4,5]
    /**
     * 思路：归并
     * 实现：要考虑各种情况
     * 0. 第一个元素要特殊处理
     * 1. l1和l2分别为空
     * 2. l1和l2都为空
     * 3. l1为空和l2不为空
     * 4. l1不为空和l2为空
     * 5. l1不为空和l2不为空, l1 的长度比 l2 的长度长
     * 6. l1不为空和l2不为空, l2 的长度比 l1 的长度长
     * 7. l1不为空和l2不为空, l2 的长度和 l1 的长度一样长
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode node = null;
        ListNode head = null;
        if (l1.val > l2.val) {
            node = new ListNode(l2.val);
            l2 = l2.next;
        } else {
            node = new ListNode(l1.val);
            l1 = l1.next;
        }
        head = node;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                node.next = l2;
                node = node.next;
                l2 = l2.next;
            } else {
                node.next = l1;
                node = node.next;
                l1 = l1.next;
            }
        }
        if (l1 == null) {
            node.next = l2;
        }
        if (l2 == null) {
            node.next = l1;
        }
        return head;
    }
}
