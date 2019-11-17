package com.wenxueliu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ： liuwenxue
 * @date ：2019/11/17 15:57
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode256
 * @modifiedBy ：
 *
 *
 * 假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 *
 * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的矩阵来表示的。
 *
 * 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。请你计算出粉刷完所有房子最少的花费成本。
 *
 * 注意：
 *
 * 所有花费均为正整数。
 *
 * 示例：
 *
 * 输入: [[17,2,17],[16,16,5],[14,3,19]]
 * 输出: 10
 * 解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。
 *      最少花费: 2 + 5 + 3 = 10。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/paint-house
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode256 {

    public int minCost0(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        int len = costs.length;
        //每行第一个元素为当前行的索引，第二个元素为值
        int [][]dp = new int[len][2];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            dp[0][0] = i;
            dp[0][1] = costs[0][i];

            for (int roomIndex = 1; roomIndex < len; roomIndex++) {
                int lastIndex = dp[roomIndex-1][0];
                List<Integer> indexes = new ArrayList<>(Arrays.asList(0, 1, 2));
                indexes.remove(lastIndex);
                int[] room = costs[roomIndex];
                dp[roomIndex][0] = room[indexes.get(0)] > room[indexes.get(1)] ? indexes.get(1) : indexes.get(0);
                dp[roomIndex][1] = dp[roomIndex-1][1] + room[dp[roomIndex][0]];
            }
            min = Math.min(min, dp[len-1][1]);
        }
        return min;
    }

    public int minCost1(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        int len = costs.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i<3; i++) {
            min = Math.min(min, minCost(costs, i, 0));
        }
        return min;
    }

    /**
     * 考虑重复元素，比如前 n 个一样，最后一个不一样。回溯算法。
     */
    int minCost(int[][]costs, int lastIndex, int roomIndex) {
        int []room = costs[roomIndex];
        List<Integer> indexes = new ArrayList<>(Arrays.asList(0, 1, 2));
        indexes.remove(lastIndex);
        if (roomIndex == costs.length - 1) {
            int cur = room[indexes.get(0)] >= room[indexes.get(1)] ?  room[indexes.get(1)] : room[indexes.get(0)];
            return cur;
        }
        if (room[indexes.get(0)] == room[indexes.get(1)]) {
            int v1 = minCost(costs, indexes.get(0), roomIndex+1) + costs[roomIndex][indexes.get(0)];
            int v2 = minCost(costs, indexes.get(1), roomIndex+1) + costs[roomIndex][indexes.get(1)];
            return Math.min(v1, v2);
        } else {
            int index = room[indexes.get(0)] > room[indexes.get(1)] ?  indexes.get(1) : indexes.get(0);
            return minCost(costs, index, roomIndex+1) + room[index];
        }
    }


    /**
     * 参考别人解法，自己的解法，回溯和动态规划都有问题。
     * @param costs
     * @return
     */
    public int minCost2(int[][] costs) {
        int N = costs.length;
        if (N == 0) {
            return 0;
        }
        int dp[][] = new int[N][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for(int i=1; i<N; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + costs[i][2];
        }
        return Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2]));
    }
}
