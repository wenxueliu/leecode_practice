package com.wenxueliu.leetcode;

import java.util.PriorityQueue;

/**
 * @author ： liuwenxue
 * @date ：2019/12/08 11:20
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode1167
 * @modifiedBy ：
 *
 * 为了装修新房，你需要加工一些长度为正整数的棒材 sticks。
 *
 * 如果要将长度分别为 X 和 Y 的两根棒材连接在一起，你需要支付 X + Y 的费用。 由于施工需要，你必须将所有棒材连接成一根。
 *
 * 返回你把所有棒材 sticks 连成一根所需要的最低费用。注意你可以任意选择棒材连接的顺序。
 *
 * 示例 1：
 *
 * 输入：sticks = [2,4,3]
 * 输出：14
 * 解释：先将 2 和 3 连接成 5，花费 5；再将 5 和 4 连接成 9；总花费为 14。
 * 示例 2：
 *
 * 输入：sticks = [1,8,3,5]
 * 输出：30
 *  
 *
 * 提示：
 *
 * 1 <= sticks.length <= 10^4
 * 1 <= sticks[i] <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-cost-to-connect-sticks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class LeetCode1167 {

    /**
     * 思路：贪婪算法，优先级队列。每次计算最小的两个元素，将元素之和重新加入队列
     * 实现：刚开始题目理解错了。 以为就是将元素排序， 从头到尾两两相加。实际上，不是这么回事，
     * 比如 5+8+9+11， 第一次计算之后，整个数组变为 13, 9, 11，显然应该是 9 + 11，而不是 13 + 9
     * 原因在于数组的顺序随时间变化。因此需要重新排序。而此时，基于树的优先级队列最合适不过。
     * 用时： 理解题目意思了，10分钟就够了
     * 算法复杂度 O(N*Log(N))
     * 空间复杂度 O(N)
     * @param sticks
     * @return
     */
    public int connectSticks(int[] sticks) {
        int len = sticks.length;
        if (len <= 1 ) {
            return 0;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (int stick : sticks) {
            queue.offer(stick);
        }
        int sum = 0;
        while (!queue.isEmpty() && queue.size() > 1) {
            int first = queue.poll();
            int second = queue.poll();
            int stick = first + second;
            queue.offer(stick);
            sum += stick;
        }

        return sum;
    }
}
