package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/11/16 18:14
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode369
 * @modifiedBy ：
 *
 * 用一个 非空 单链表来表示一个非负整数，然后将这个整数加一。
 *
 * 你可以假设这个整数除了 0 本身，没有任何前导的 0。
 *
 * 这个整数的各个数位按照 高位在链表头部、低位在链表尾部 的顺序排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 依赖题目: 206
 */
public class LeetCode369 {

    /**
     * 思路：链表翻转，之后利用加法运行
     * 实现：链表翻转
     * 用时：1 小时。在链表翻转之后的加法操作阻塞。
     * @param head
     * @return
     */
    public ListNode plusOne(ListNode head) {
        return plusNum(head, 1);
    }

    public ListNode plusNum(ListNode head, int n) {
        ListNode tail = reverse(head);
        ListNode reverseHead = tail;
        int carry = 0;
        int sum = tail.val + n + carry;
        tail.val = sum % 10;
        carry = sum >= 10 ? 1 : 0;
        while (tail.next != null) {
            tail = tail.next;
            sum = tail.val + carry;
            tail.val = sum % 10;
            carry = sum >= 10 ? 1 : 0;
            if (carry == 0) {
                break;
            }
        }
        if (carry == 1) {
            ListNode node = new ListNode(1);
            tail.next = node;
            return reverse(reverseHead);
        } else {
            return reverse(reverseHead);
        }
    }

    ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head != null && head.next == null) {
            return head;
        }

        ListNode first = head;
        ListNode second = first.next;
        ListNode third = second.next;
        first.next = null;

        while (third != null) {
            second.next = first;
            first = second;
            second = third;
            third = second.next;
        }
        second.next = first;
        return second;
    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public ListNode plusNum1(ListNode head, int n) {
        //从右往左指向第一个非 9 的值
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (fast.val != 9) {
                slow = fast;
            }
            fast = fast.next;
        }

        if (slow == head && slow.val == 9) {
            ListNode node = new ListNode(0);
            slow = node;
            slow.next = head;
        }

        slow.val += 1;
        //slow 后的每个节点加 1 后变为 0
        ListNode cur = slow.next;
        while (cur != null) {
            if (cur.next == null) {
                cur.val = (cur.val + n) % 10;
            } else {
                cur.val = 0;
            }
            cur = cur.next;
        }
        return slow.next == head ? slow : head;
    }
}
