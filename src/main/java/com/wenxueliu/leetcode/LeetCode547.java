package com.wenxueliu.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ： liuwenxue
 * @date ：2019/11/14 00:02
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode547
 * @modifiedBy ：
 *
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 *
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/friend-circles
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode547 {

    /**
     * 思路：将新的合并到已有的集合
     * 实现：略
     * 用时：1 小时
     * 仅仅超过 5%
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {
        List<Set<Integer>> res = new ArrayList<>();
        for (int row = 0; row < M[0].length; row++) {
            for (int col = row; col < M[0].length; col++) {
                if (M[row][col] == 1) {
                    res = contains(res, row, col);
                }
            }
        }
        return res.size();
    }

    private List<Set<Integer>> contains(List<Set<Integer>> elements, int row, int col) {
        List<Set<Integer>> needMerge = new ArrayList<>();
        for (int index = 0; index < elements.size(); index++) {
            Set<Integer> ele = elements.get(index);
            if (ele.contains(row) || ele.contains(col)) {
                needMerge.add(ele);
            }
        }
        if (needMerge.isEmpty()) {
            Set<Integer> ele = new HashSet<>();
            ele.add(row);
            ele.add(col);
            elements.add(ele);
            return elements;
        } else {
            Set<Integer> newSet =  new HashSet<>();
            newSet.add(row);
            newSet.add(col);
            for (Set<Integer> ele: needMerge) {
                newSet.addAll(ele);
                elements.remove(ele);
            }
            elements.add(newSet);
            return elements;
        }
    }
}
