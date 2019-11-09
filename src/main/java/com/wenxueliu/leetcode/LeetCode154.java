package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/11/09 19:28
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode154
 * @modifiedBy ：
 *
 * 注：解此题，可以先尝试 LeetCode153
 */
public class LeetCode154 {

    /**
     *
     * 思路
     * 遍历过程
     * 1. 如果 nums[mid] < num[right] 变化点在 [left,mid] 之间
     * 2. 如果 nums[mid] > num[right] 变化点在 [mid+1,right] 之间
     * 3. 如果 nums[mid] == num[right] : 与 153 对比难点在于此。
     * 需要考虑的情况如:
     * [1, 2, 1, 1, 1],  最小值在 mid 右边
     * [1, 2, 2, 2, 1],  最小值在 mid 左边和右边都存在
     * [2, 2, 2, 1, 1, 2] 最小值在 mid 右边
     * [2, 1, 1, 2, 2, 2] 最小值在 mid 左边
     * 等
     * 因此，如何解决这种情况是关键
     *
     * 一个非常精妙的思路是： end--。因为 mid 和 end 相等，所以我们直接把 end 抛弃一定不会影响结果的。
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = right - 1;
            }
        }
        return nums[left];
    }


    /**
     * 思路：将两边相同的值去掉，简化问题。
     * 实现：最初的思路是这样，但是没有成功实现。
     * 比如
     * 需要考虑的情况如:
     * [1, 2, 1, 1, 1],  变为 [1]
     * [1, 2, 2, 2, 3, 1],  变为 [2, 2, 2, 3]
     * [2, 2, 2, 3, 4, 4 1, 1, 2] 变为 [3, 4, 4 1, 1]
     * @param nums
     * @return
     */
    public int findMin1(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (nums[end] == nums[start] && end > start) {
            end--;
        }
        while (start < end) {
            int mid = (start + end) >>> 1;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else{
                end = mid;
            }
        }
        return nums[start];
    }
}
