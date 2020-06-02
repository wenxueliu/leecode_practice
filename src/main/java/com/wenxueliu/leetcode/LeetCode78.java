package com.wenxueliu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
* @author liuwenxue
* @date 2020-06-02
*/
public class LeetCode78 {

    /**
     * 参考思考
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        int len = nums.length;
        List<String> indexs = new ArrayList<>();
        for (int index = 0; index < Math.pow(2, len); index++) {
            String str = Integer.toBinaryString(index);
            indexs.add(str);
        }
        for (String index : indexs) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = index.length() - 1; i >= 0; i--) {
                if (index.charAt(index.length() - 1 - i) == '1') {
                    tmp.add(nums[i]);
                }
            }
            res.add(tmp);
        }
        return res;
    }
}
