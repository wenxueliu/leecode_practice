package com.wenxueliu.leetcode;

import java.util.*;

/**
 * @author ： liuwenxue
 * @date ：2019/11/13 00:18
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode1086
 * @modifiedBy ：
 *
 * 题目
 *
 * 给你一个不同学生的分数列表，请按 学生的 id 顺序 返回每个学生 最高的五科 成绩的 平均分。
 *
 * 对于每条 items[i] 记录， items[i][0] 为学生的 id，items[i][1] 为学生的分数。平均分请采用整数除法计算。
 *
 * 示例：
 *
 * 输入：[[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
 * 输出：[[1,87],[2,88]]
 * 解释：
 * id = 1 的学生平均分为 87。
 * id = 2 的学生平均分为 88.6。但由于整数除法的缘故，平均分会被转换为 88。
 *
 *
 * 提示：
 *
 * 1 <= items.length <= 1000
 * items[i].length == 2
 * 学生的 ID 在 1 到 1000 之间
 * 学生的分数在 1 到 100 之间
 * 每个学生至少有五个分数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/high-five
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode1086 {

    /**
     * 非常基本的题目。
     * 思路：保证正确性的情况下采用该方法
     * 实现：保存在 map 中，最后排序取 top5
     * 用时：20 分钟
     * @param items
     * @return
     */
    public int[][] highFive(int[][] items) {
        Map<Integer, List<Integer>> id2Scores = new HashMap<>(1000);
        for (int []item : items) {
            if (id2Scores.containsKey(item[0])) {
                id2Scores.get(item[0]).add(item[1]);
            } else {
                List<Integer> scores = new ArrayList<>();
                scores.add(item[1]);
                id2Scores.put(item[0], scores);
            }
        }
        int size = id2Scores.keySet().size();
        int [][] res = new int[size][2];
        List<Integer> ids = new ArrayList<>(id2Scores.keySet());
        Collections.sort(ids);
        for (int index = 0; index < ids.size(); index++) {
            List<Integer> scores = id2Scores.get(ids.get(index));
            int avgTop5 = averageScore(scores);
            res[index][0] = ids.get(index);
            res[index][1] = avgTop5;
        }
        return res;
    }

    int averageScore(List<Integer> scores) {
        Collections.sort(scores);
        int avgTop5 = 0;
        int size = scores.size();
        for (int i = size - 1; i > size - 6; i--) {
            avgTop5 += scores.get(i);
        }
        return avgTop5 / 5;
    }
}
