package com.wenxueliu.leetcode;

import java.util.*;

/**
 * @author ： liuwenxue
 * @date ：2019/12/07 23:41
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode1057
 * @modifiedBy ：
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
