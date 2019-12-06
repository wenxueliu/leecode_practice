package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/12/06 22:28
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode1055
 * @modifiedBy ：
 *
 * 对于任何字符串，我们可以通过删除其中一些字符（也可能不删除）来构造该字符串的子序列。
 *
 * 给定源字符串 source 和目标字符串 target，找出源字符串中能通过串联形成目标字符串的子序列的最小数量。如果无法通过串联源字符串中的子序列来构造目标字符串，则返回 -1。
 *
 * 示例 1：
 *
 * 输入：source = "abc", target = "abcbc"
 * 输出：2
 * 解释：目标字符串 "abcbc" 可以由 "abc" 和 "bc" 形成，它们都是源字符串 "abc" 的子序列。
 * 示例 2：
 *
 * 输入：source = "abc", target = "acdbc"
 * 输出：-1
 * 解释：由于目标字符串中包含字符 "d"，所以无法由源字符串的子序列构建目标字符串。
 * 示例 3：
 *
 * 输入：source = "xyz", target = "xzyxz"
 * 输出：3
 * 解释：目标字符串可以按如下方式构建： "xz" + "y" + "xz"。
 *  
 *
 * 提示：
 *
 * source 和 target 两个字符串都只包含 "a"-"z" 的英文小写字母。
 * source 和 target 两个字符串的长度介于 1 和 1000 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-way-to-form-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode1055 {
    /**
     * 思路：从 source 找 target，每次遍历完 source，计算遍历次数即可。如果某次没有与target任一字符匹配，返回-1
     * 实现：参考思路
     * 算法复杂度 O(m*n) 其中 m 为 source 长度，n 为 target 长度
     * 空间复杂度 O(1)
     * @param source
     * @param target
     * @return
     */
    public int shortestWay(String source, String target) {
        int index = 0;
        int count = 0;
        while (index < target.length()) {
            int newIndex = subStr(source, target.substring(index));
            if (newIndex == 0) {
                return -1;
            } else {
                index = index + newIndex;
                count++;
            }
        }
        return count;
    }

    int subStr(String source, String target) {
        int sourceIndex = 0;
        int targetIndex = 0;
        while (sourceIndex < source.length() && targetIndex < target.length()) {
            char src = source.charAt(sourceIndex);
            char dst = target.charAt(targetIndex);
            if (src == dst) {
                sourceIndex++;
                targetIndex++;
            } else {
                sourceIndex++;
            }
        }
        return targetIndex;
    }
}
