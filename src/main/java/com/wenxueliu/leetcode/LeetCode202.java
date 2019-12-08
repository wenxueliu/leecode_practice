package com.wenxueliu.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ： liuwenxue
 * @date ：2019/12/08 14:03
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode202
 * @modifiedBy ：
 *
 * 编写一个算法来判断一个数是不是“快乐数”。
 *
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例: 
 *
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode202 {

    /**
     * 思路：快慢指针
     * 算法复杂度：未知
     * 空间复杂度：O(1)
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = nextNum(slow);
            fast = nextNum(fast);
            fast = nextNum(fast);
        } while (slow != fast);
        return slow == 1;
    }

    int nextNum(int num) {
        int sum = 0;
        while (num > 0) {
            int singleNum = num % 10;
            sum += singleNum * singleNum;
            num /= 10;
        }
        return sum;
    }

    /**
     * 思路：将访问过的数记录在哈希表
     * @param n
     * @return
     */
    public boolean isHappy1(int n) {
        Set<Integer> visited = new HashSet<Integer>();
        int num = n;
        do {
            num = nextNum(num);
            if (!visited.contains(num)) {
                visited.add(num);
            } else {
                return false;
            }

        } while (num != 1);
        return true;
    }
}
