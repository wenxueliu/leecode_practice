package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/11/08 00:16
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode69
 * @modifiedBy ：
 */
public class LeetCode69 {

    /**
     * 思路：使用二分法搜索，这个问题可以转化为找到比 n 的平方小于等于 x
     * 实现：溢出问题通过 long 来解决
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 1 ||  x == 0) {
            return x;
        }
        long low = 0;
        long high = x / 2 + 1;

        while (low <= high) {
            long mid = low + ((high - low) >> 1);
            long value = mid * mid;
            if (value > x) {
                high = mid - 1;
            } else if (value < x) {
                if (value + 2 * mid + 1 > x) {
                    return (int)mid;
                }
                low = mid + 1;
            } else {
                return (int)mid;
            }
        }
        //这里为什么选 high
        return (int)high;
    }

    /**
     * 通过除法避免进行类型转换
     * @param x
     * @return
     */
    public int mySqrt1(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int left = 0;
        // 对于一个非负数n，它的平方根不会大于（n/2+1）
        int right = x / 2 + 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (mid < x / mid) {
                //mid*mid < x 但是 (mid+1)*(mid+1) > x，此时 mid 就满足条件
                if (mid + 1 > x / (mid + 1)) {
                    return mid;
                }
                left = mid + 1;
            } else if (mid > x / mid) {

                right = mid - 1;
            } else {
                return mid;
            }
        }
        return right;
    }

    /**
     * 该实现方案比二分法好
     * 牛顿迭代法: 由导数 公式推导
     * cur = 1
     * 用 * cur = cur - (cur * cur - x) / (2 * cur) 不断迭代
     *
     * 具体参考 https://www.zhihu.com/question/20690553
     * @param x
     * @return
     */
    public int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        double cur = x;
        double last = 0;
        //由于是整数，所以这里为 cur - last < 1 时就迭代结束
        //如果需要更好的精确度，可以在这里控制
        while (Math.abs(cur - last) >= 1) {
            last = cur;
            cur = cur - (cur * cur - x) / (2 * cur);
        }
        return (int)cur;
    }
}
