package com.wenxueliu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
* @author liuwenxue
* @date 2020-03-02
*/
public class LeetCode113 {

    List<List<Integer>> target = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();

    /**
     * 思路：递归
     * 实现：思路清晰了问题就好解决了。不断减 sum 的方法挺巧妙的。
     * 算法复杂度: O(n)
     * 空间复杂度: O(n)
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return target;
        }
        sum -= root.val;
        path.add(root.val);
        //第二遍少了该语句，没有注意题目中描述的 "从根节点到叶子节点路径总和等于给定目标和的路径。"
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                target.add(new ArrayList<>(path));
            }
        }
        if (root.left != null) {
            pathSum(root.left, sum);
        }
        if (root.right != null) {
            pathSum(root.right, sum);
        }
        path.remove(path.size() - 1);
        return target;
    }
}
