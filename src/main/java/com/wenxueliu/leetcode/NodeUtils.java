package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/11/16 16:05
 * @description :
 * @path : com.wenxueliu.leetcode.NodeUtils
 * @modifiedBy ：
 */
public class NodeUtils {

    public static Node fromArray(int []nums) {
        if (nums.length == 0) {
            return null;
        }
        Node head = new Node(nums[0]);
        Node cur = head;
        for (int index = 1; index < nums.length; index++) {
            Node node = new Node(nums[index]);
            cur.next = node;
            cur = cur.next;
        }
        cur.next = head;
        return head;
    }

    public static int[] toArray(Node head) {
        if (head == null) {
            return new int[]{};
        }
        if (head == head.next) {
            return new int[]{head.val};
        }
        Node first = head.next;
        int count = 1;
        while (first != head) {
            count++;
            first = first.next;
        }
        int []nums = new int[count];
        nums[0] = head.val;
        int index = 1;
        first = head.next;
        while (first != head) {
            nums[index] = first.val;
            first = first.next;
            index++;
        }
        return nums;
    }
}
