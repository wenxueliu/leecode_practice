package com.wenxueliu.leetcode;

import java.util.*;

/**
 * @author ： liuwenxue
 * @date ：2019/12/07 23:41
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode1057
 * @modifiedBy ：
 *
 *
 * 在由 2D 网格表示的校园里有 n 位工人（worker）和 m 辆自行车（bike），n <= m。所有工人和自行车的位置都用网格上的 2D 坐标表示。
 *
 * 我们需要为每位工人分配一辆自行车。在所有可用的自行车和工人中，我们选取彼此之间曼哈顿距离最短的工人自行车对  (worker, bike) ，并将其中的自行车分配給工人。如果有多个 (worker, bike) 对之间的曼哈顿距离相同，那么我们选择工人索引最小的那对。类似地，如果有多种不同的分配方法，则选择自行车索引最小的一对。不断重复这一过程，直到所有工人都分配到自行车为止。
 *
 * 给定两点 p1 和 p2 之间的曼哈顿距离为 Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|。
 *
 * 返回长度为 n 的向量 ans，其中 a[i] 是第 i 位工人分配到的自行车的索引（从 0 开始）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：workers = [[0,0],[2,1]], bikes = [[1,2],[3,3]]
 * 输出：[1,0]
 * 解释：
 * 工人 1 分配到自行车 0，因为他们最接近且不存在冲突，工人 0 分配到自行车 1 。所以输出是 [1,0]。
 *
 * 示例 2：
 *
 * 输入：workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
 * 输出：[0,2,1]
 * 解释：
 * 工人 0 首先分配到自行车 0 。工人 1 和工人 2 与自行车 2 距离相同，因此工人 1 分配到自行车 2，工人 2 将分配到自行车 1 。因此输出为 [0,2,1]。
 *  
 *
 * 提示：
 *
 * 0 <= workers[i][j], bikes[i][j] < 1000
 * 所有工人和自行车的位置都不相同。
 * 1 <= workers.length <= bikes.length <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/campus-bikes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode1057 {
    /**
     * 思路：计算所有自行车和工人之间的距离，按照距离、工人编号、自行车编号排序
     * 实现：赋值距离的时候，应该是 bikeIndex 结果为 distant，在 idea 调试才发现问题
     * 算法复杂度 O(N^2)
     * 空间复杂度 O(N)
     * @param workers 工人坐标
     * @param bikes 自行车坐标
     * @return
     */
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        if (workers.length == 0 || bikes.length == 0) {
            return new int[0];
        }
        int[] workerIndexes = new int[workers.length];
        for (int index = 0; index < workerIndexes.length; index++) {
            workerIndexes[index] = -1;
        }
        PriorityQueue<Distant> distantQueue = new PriorityQueue<>(
                (o1, o2) -> {
                    if (o1.distant != o2.distant) {
                        return o1.distant - o2.distant;
                    }
                    if (o1.workerIndex != o2.workerIndex) {
                        return o1.workerIndex - o2.workerIndex;
                    }
                    return o1.bikeIndex - o2.bikeIndex;
                });
        for (int bikeIndex = 0; bikeIndex < bikes.length; bikeIndex++) {
            int bikeRowIndex = bikes[bikeIndex][0];
            int bikeColIndex = bikes[bikeIndex][1];
            for (int workerIndex = 0; workerIndex < workers.length; workerIndex++) {
                int workerRowIndex = workers[workerIndex][0];
                int workerColIndex = workers[workerIndex][1];
                int distant = distant(workerRowIndex, workerColIndex, bikeRowIndex, bikeColIndex);
                Distant distantPair = new Distant(workerIndex, bikeIndex, distant);
                distantQueue.offer(distantPair);
            }
        }
        Set<Integer> visitedBikes = new HashSet<>();
        while (!distantQueue.isEmpty()) {
            Distant head = distantQueue.poll();
            if (workerIndexes[head.workerIndex] == -1 && !visitedBikes.contains(head.bikeIndex)) {
                workerIndexes[head.workerIndex] = head.bikeIndex;
                visitedBikes.add(head.bikeIndex);
            }

        }
        return workerIndexes;
    }

    /**
     * 这种方法超时
     * @param workers
     * @param bikes
     * @return
     */
    public int[] assignBikes1(int[][] workers, int[][] bikes) {
        if (workers.length == 0 || bikes.length == 0) {
            return new int[0];
        }
        int[] workerIndexes = new int[workers.length];
        for (int index = 0; index < workerIndexes.length; index++) {
            workerIndexes[index] = -1;
        }

        Distant []allDistants = new Distant[bikes.length * workers.length];
        for (int bikeIndex = 0; bikeIndex < bikes.length; bikeIndex++) {
            int bikeRowIndex = bikes[bikeIndex][0];
            int bikeColIndex = bikes[bikeIndex][1];
            for (int workerIndex = 0; workerIndex < workers.length; workerIndex++) {
                int workerRowIndex = workers[workerIndex][0];
                int workerColIndex = workers[workerIndex][1];
                int distant = distant(workerRowIndex, workerColIndex, bikeRowIndex, bikeColIndex);
                Distant distantPair = new Distant(workerIndex, bikeIndex, distant);
                allDistants[bikeIndex * workers.length + workerIndex ] = distantPair;
            }
        }
        Arrays.sort(allDistants, Comparator.comparing(Distant::getDistant).thenComparing(Distant::getWorkerIndex).thenComparing(Distant::getBikeIndex));
        Set<Integer> visitedBikes = new HashSet<>();
        for (Distant element : allDistants) {
            if (workerIndexes[element.workerIndex] == -1 && !visitedBikes.contains(element.bikeIndex)) {
                workerIndexes[element.workerIndex] = element.bikeIndex;
                visitedBikes.add(element.bikeIndex);
            }
        }
        return workerIndexes;
    }

    class Distant {
        int workerIndex;
        int bikeIndex;
        int distant;

        Distant(int workerIndex, int bikeIndex, int distant) {
            this.workerIndex = workerIndex;
            this.bikeIndex = bikeIndex;
            this.distant = distant;
        }

        int getDistant() {
            return distant;
        }

        int getBikeIndex() {
            return bikeIndex;
        }

        int getWorkerIndex() {
            return workerIndex;
        }
    }

    int distant(int workerRowIndex, int workerColIndex, int bikeRowIndex, int bikeColIndex) {
        return Math.abs(bikeRowIndex - workerRowIndex) + Math.abs(workerColIndex - bikeColIndex);
    }
}
