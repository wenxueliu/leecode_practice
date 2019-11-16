package com.wenxueliu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ： liuwenxue
 * @date ：2019/11/16 11:38
 * @description :
 * @path : com.wenxueliu.leetcode.ListNodeUtils
 * @modifiedBy ：
 */
public class ListNodeUtils {

    public static ListNode fromArray(int []nums) {
        if (nums.length == 0) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;
        for (int index = 1; index < nums.length; index++) {
            ListNode node = new ListNode(nums[index]);
            cur.next = node;
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }

    public static int[] toArray(ListNode head) {
        ListNode first = head;
        int count = 0;
        while (first != null) {
            count++;
            first = first.next;
        }
        int []nums = new int[count];
        int index = 0;
        while (head != null) {
            nums[index] = head.val;
            head = head.next;
            index++;
        }
        return nums;
    }
}
