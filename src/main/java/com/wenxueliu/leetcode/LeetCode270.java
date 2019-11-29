package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/11/27 00:15
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode270
 * @modifiedBy ：
 *
 * 给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的数值。
 *
 * 注意：
 *
 * 给定的目标值 target 是一个浮点数
 * 题目保证在该二叉搜索树中只会存在一个最接近目标值的数
 * 示例：
 *
 * 输入: root = [4,2,5,1,3]，目标值 target = 3.714286
 *
 *     4
 *    / \
 *   2   5
 *  / \
 * 1   3
 *
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/closest-binary-search-tree-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode270 {
    /**
     * 思路：遍历，然后检查每个值与 target 的距离，返回距离最小值
     * 实现：没有考虑溢出情况。
     * @param root
     * @param target
     * @return
     */
    public int closestValue(TreeNode root, double target) {
        return findNearst(root, target);
        //return findNearst1(root, target);
    }

    /**
     * 自己的解法，没有重复利用右子树比当前值大，左子树比当前值小的特点。
     * @param root
     * @param target
     * @return
     */
    int findNearst(TreeNode root, double target) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        double diff = Math.abs((double)root.val - target);
        double leftDiff = diff;
        int leftValue = findNearst(root.left, target);
        if (root.left != null) {
            leftDiff = Math.abs(leftValue - target);
        }
        double rightDiff = diff;
        int rightValue = findNearst(root.right, target);
        if (root.right != null) {
            rightDiff = Math.abs(rightValue - target);
        }
        if (diff <= leftDiff && diff <= rightDiff) {
            return root.val;
        } else if (leftDiff <= diff && leftDiff <= rightDiff) {
            return leftValue;
        } else if (rightDiff <= diff && rightDiff <= leftDiff) {
            return rightValue;
        } else {
            return Integer.MAX_VALUE;
        }
    }


    /**
     * 解法一：自己的解法太复杂了，思路一样，但是对特殊情况的处理不合理
     * @param root
     * @param target
     * @return
     */
    public int findNearst1(TreeNode root, double target) {
        int ans = root.val;
        // 如果比 target 大，那么最接近的值一定在左边，因为 root.right.val - targer 一定大于 root.val - target。
        if (root.val > target) {
            if (root.left == null) {
                return root.val;
            }
            ans = findNearst1(root.left, target);
        } else { //同理
            if (root.right == null) {
                return root.val;
            }
            ans = findNearst1(root.right, target);
        }
        ans = Math.abs(root.val-target) < Math.abs(ans-target) ? root.val : ans;
        return ans;
    }
}
