package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/11/16 14:47
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode708
 * @modifiedBy ：
 *
 * 给定循环升序列表中的一个点，写一个函数向这个列表中插入一个新元素，使这个列表仍然是循环升序的。给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。
 *
 * 如果有多个满足条件的插入位置，你可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。
 *
 * 如果列表为空（给定的节点是 null），你需要创建一个循环有序列表并返回这个点。否则。请返回原先给定的节点。
 *
 * 下面的例子可以帮你更好的理解这个问题：
 *
 *  1 ------------
 *  |             |
 *  |             |
 *  4 ----------- 3 -- HEAD
 *
 * 在上图中， 有一个包含三个元素的循环有序列表，你获得值为 3 的节点的指针，我们需要向表中插入元素 2。
 *
 *  1 ----------- 2
 *  |             |
 *  |             |
 *  4 ----------- 3 -- HEAD
 *
 * 新插入的节点应该在 1 和 3 之间，插入之后，整个列表如上图所示，最后返回节点 3。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-into-a-cyclic-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode708 {

    /**
     * 思路：考虑各种情况
     * 实现：见下
     * 用时：一个小时，没有考虑到重复元素的情况
     * 1. 空链表
     * 2. 只有一个元素
     * 3. 有两个元素
     * 4. 有三个元素
     *      1. 比所有元素都大
     *      2. 比所有元素都小
     *      3. 在最大和最小之间
     *      4. 所有元素都一样，插入元素比所有元素小
     *      5，所有元素都一样，插入元素比元素大的
     */
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            head = new Node();
            head.val = insertVal;
            head.next = head;
            return head;
        }
        if (head.next == head) {
            Node newNode = new Node(insertVal, head);
            head.next = newNode;
            return head;
        }

        Node first = head;
        Node second = first.next;
        while (true) {
            // 1 2 4 5  插入 2 或 3
            if (first.val <= insertVal && insertVal < second.val) {
                Node newNode = new Node(insertVal, second);
                first.next = newNode;
                return head;
                // 1 2 4 5  插入 4 或 3
            } else if (first.val < insertVal && insertVal <= second.val) {
                Node newNode = new Node(insertVal, second);
                first.next = newNode;
                return head;
                // 1 2 4 5  插入 6 或 0
            } else if (first.val > second.val && (insertVal < second.val || insertVal > first.val)) {
                Node newNode = new Node(insertVal, second);
                first.next = newNode;
                return head;
                // 1 2 3 3 插入 3
            } else if (first.val == second.val && second.val == insertVal) {
                Node newNode = new Node(insertVal, second);
                first.next = newNode;
                return head;
                // 3 3 3 插入 5 或 0
            } else if (second == head && first.val == second.val) {
                Node newNode = new Node(insertVal, second);
                first.next = newNode;
                return head;
            } else {
                first = first.next;
                second = first.next;
            }
        }
    }
}
