package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2020/01/20 23:58
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode978
 * @modifiedBy ：
 */
public class LeetCode978 {
    /**
     * 思路：
     * 实现：情况比较难以考虑全面，思路不难，实现准确很难。
     * @param A
     * @return
     */
    public int maxTurbulenceSize(int[] A) {
        int len = A.length;
        if (len == 1) {
            return 1;
        }
        if (len == 2) {
            if (A[0] != A[1]) {
                return 2;
            } else {
                return 1;
            }
        }
        int[] diff = new int[len - 1];
        for (int index = 0; index < len - 1; index++) {
            diff[index] = A[index + 1] - A[index];
        }
        int diffLen = diff.length;
        int maxLen = 1;
        int left = 0;
        for (int right = 1; right < diffLen; right++) {
            int diffValue = diff[right] * diff[right-1];
            if (diffValue < 0) {
                maxLen = Math.max(maxLen, right - left + 2);
            } else if (diff[right] == 0 &&  diff[right-1] == 0) {
                maxLen = Math.max(right - left, maxLen);
                left = right;
            } else {
                maxLen = Math.max(right - left + 1, maxLen);
                left = right;
            }
        }
        return maxLen;
    }

    /**
     *
     * @param A
     * @return
     */
    public int maxTurbulenceSize1(int[] A) {
        int N = A.length;
        int maxLen = 1;
        int left = 0;

        for (int right = 1; right < N; ++right) {
            int c = Integer.compare(A[right-1], A[right]);
            if (right == N-1 || c * Integer.compare(A[right], A[right+1]) != -1) {
                if (c != 0) {
                    maxLen = Math.max(maxLen, right - left + 1);
                }
                left = right;
            }
        }

        return maxLen;
    }

    /**
     * 思路：动态规划
     * @param A
     * @return
     */
    public int maxTurbulenceSize2(int[] A) {
        if (A.length < 2) {
            return A.length;
        }

        int N=A.length;
        int []dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
        }

        dp[0]=1;
        dp[1]=(A[1]!=A[0])?2:1;
        int result = Math.max(dp[0],dp[1]);
        for (int i=2; i<N; ++i) {
            // 瑞流成立
            if (compare(A[i-2],A[i-1]) * compare(A[i-1],A[i]) == -1) {
                dp[i] = dp[i-1] + 1;
                // 更新result
                result= Math.max(result,dp[i]);
            } else if (compare(A[i-1],A[i]) != 0) {
                // 瑞流不成立且两数不相等，dp[i]=2
                dp[i] = 2;
            }
        }
        return result;
    }

    int compare(int a,int b){
        return (a>b)?1:(a==b)?0:-1;
    }
}
