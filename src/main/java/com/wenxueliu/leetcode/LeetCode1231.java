package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/12/02 23:13
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode1231
 * @modifiedBy ：
 *
 *
 * 你有一大块巧克力，它由一些甜度不完全相同的小块组成。我们用数组 sweetness 来表示每一小块的甜度。
 *
 * 你打算和 K 名朋友一起分享这块巧克力，所以你需要将切割 K 次才能得到 K+1 块，每一块都由一些 连续 的小块组成。
 *
 * 为了表现出你的慷慨，你将会吃掉 总甜度最小 的一块，并将其余几块分给你的朋友们。
 *
 * 请找出一个最佳的切割策略，使得你所分得的巧克力 总甜度最大，并返回这个 最大总甜度。
 *
 * 示例 1：
 *
 * 输入：sweetness = [1,2,3,4,5,6,7,8,9], K = 5
 * 输出：6
 * 解释：你可以把巧克力分成 [1,2,3], [4,5], [6], [7], [8], [9]。
 * 示例 2：
 *
 * 输入：sweetness = [5,6,7,8,9,1,2,3,4], K = 8
 * 输出：1
 * 解释：只有一种办法可以把巧克力分成 9 块。
 * 示例 3：
 *
 * 输入：sweetness = [1,2,2,1,2,2,1,2,2], K = 2
 * 输出：5
 * 解释：你可以把巧克力分成 [1,2,2], [1,2,2], [1,2,2]。
 *  
 *
 * 提示：
 *
 * 0 <= K < sweetness.length <= 10^4
 * 1 <= sweetness[i] <= 10^5
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-chocolate
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode1231 {

    /**
     * 思路：二分法
     * 实现：刚开始理解错了，还以为可以排序
     * @param sweetness
     * @param K
     * @return
     */
    public int maximizeSweetness(int[] sweetness, int K) {
        int sum = 0;
        for (int sweet : sweetness) {
            sum += sweet;
        }
        if (K == 0) {
            return sum;
        }
        //二分法的经典套路
        int left = 0;
        int right = sum / K + 1;
        int res = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (findK(sweetness, mid, K)) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    /**
     * 将 sweetness  分为 K + 1 组，每组不少于 mid，是否成立
     */
    boolean findK(int[] sweetness, int sum, int K) {
        int batchSum = 0;
        int findNum = 0;
        for (int index = 0; index < sweetness.length; index++) {
            batchSum += sweetness[index];
            if (batchSum >= sum) {
                findNum++;
                batchSum = 0;
            }
        }
        return findNum >= K + 1;
    }
}
