package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/12/03 00:14
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode651
 * @modifiedBy ：
 *
 * 假设你有一个特殊的键盘包含下面的按键：
 *
 * Key 1: (A)：在屏幕上打印一个 'A'。
 *
 * Key 2: (Ctrl-A)：选中整个屏幕。
 *
 * Key 3: (Ctrl-C)：复制选中区域到缓冲区。
 *
 * Key 4: (Ctrl-V)：将缓冲区内容输出到上次输入的结束位置，并显示在屏幕上。
 *
 * 现在，你只可以按键 N 次（使用上述四种按键），请问屏幕上最多可以显示几个 'A'呢？
 *
 * 样例 1:
 *
 * 输入: N = 3
 * 输出: 3
 * 解释:
 * 我们最多可以在屏幕上显示三个'A'通过如下顺序按键：
 * A, A, A
 *  
 *
 * 样例 2:
 *
 * 输入: N = 7
 * 输出: 9
 * 解释:
 * 我们最多可以在屏幕上显示九个'A'通过如下顺序按键：
 * A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V
 *  
 *
 * 注释:
 *
 * 1 <= N <= 50
 * 结果不会超过 32 位有符号整数范围。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4-keys-keyboard
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode651 {

    /**
     * 思路：刚开始用数学递推，但是由于考虑的场景为 nA + (N-2-n)A 这种最简单的场景，在 N = 11 的时候出错。
     * 实现: 用动态规划的方式
     * 算法复杂度 O(N^2)
     * 空间复杂度 O(N)
     * @param N
     * @return
     */
    public int maxA(int N) {
        if (N <= 5) {
            return N;
        }
        int[] arr = new int[N+1];
        arr[0] = 0;
        for(int i=1; i<=N; i++) {
            arr[i] = arr[i-1] + 1;
            for(int j=2; j+1<i; j++) {
                arr[i] = Math.max(arr[i], arr[j-1]*(i-j));
            }
        }
        return arr[N];
    }
}
