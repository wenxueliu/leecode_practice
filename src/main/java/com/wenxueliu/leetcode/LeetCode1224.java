package com.wenxueliu.leetcode;

import java.util.*;

/**
 * @author ： liuwenxue
 * @date ：2019/12/20 23:57
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode1224
 * @modifiedBy ：
 */
public class LeetCode1224 {
    /**
     * 思路：计算每个元素出现的频率，每个频率的元素。从后往前遍历，每删除一个元素，检查是否满足条件。 如果满足条件，返回当前元素个数
     * 实现：各种情况比较难一次考虑周全
     * 算法复杂度：O(n)
     * 空间复杂度: O(n)
     * @param nums
     * @return
     */
    public int maxEqualFreq(int[] nums) {
        Map<Integer, Integer> numToCount = valueToCount(nums);
        Map<Integer, Set<Integer>> map = countToValues(numToCount);

        int length = nums.length;
        if (isInitMatch(map)) {
            return length;
        }
        for (int index = length - 1; index >= 0; index--) {
            int key = nums[index];
            int count = numToCount.get(key);

            if (count > 1) {
                numToCount.put(key, count - 1);
            } else {
                numToCount.remove(key);
            }

            Set<Integer> values = map.get(count);
            values.remove(key);
            if (values.isEmpty()) {
                map.remove(count);
            } else {
                map.put(count, values);
            }

            if (count > 1) {
                if (map.containsKey(count - 1)) {
                    Set<Integer> existValues = map.get(count - 1);
                    existValues.add(key);
                    map.put(count - 1, existValues);
                } else {
                    Set<Integer> newValues = new HashSet<>();
                    newValues.add(key);
                    map.put(count - 1, newValues);
                }
            }

            if (isMatch(map)) {
                if (map.keySet().size() == 1) {
                    return index+1;
                } else {
                    return index;
                }
            }
        }
        return 0;
    }

    Map<Integer, Integer> valueToCount(int[] nums) {
        Map<Integer, Integer> numToCount = new HashMap<>();
        for (int num : nums) {
            if (numToCount.containsKey(num)) {
                numToCount.put(num, numToCount.get(num) + 1);
            } else {
                numToCount.put(num, 1);
            }
        }
        return numToCount;
    }

    Map<Integer, Set<Integer>> countToValues(Map<Integer, Integer> numToCount) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int key : numToCount.keySet()) {
            int count = numToCount.get(key);
            if (map.containsKey(count)) {
                Set<Integer> values = map.get(count);
                values.add(key);
                map.put(count, values);
            } else {
                Set<Integer> newValues = new HashSet<>();
                newValues.add(key);
                map.put(count, newValues);
            }
        }
        return map;
    }

    boolean isMatch(Map<Integer, Set<Integer>> map) {
        Set<Integer> keySet = map.keySet();
        if (keySet.size() > 2) {
            return false;
        } else if (keySet.size() == 2) {
            return isInitMatch(map);
        } else {
            return true;
        }
    }

    boolean isInitMatch(Map<Integer, Set<Integer>> map) {
        Set<Integer> keySet = map.keySet();
        if (keySet.size() == 2) {
            List<Integer> keys = new ArrayList<>(keySet);
            if (map.get(keys.get(1)).size() == 1 && keys.get(1) - keys.get(0) == 1) {
                return true;
            } else if (map.get(keys.get(0)).size() == 1 && keys.get(0) - keys.get(1) == 1) {
                return true;
            } else if (map.containsKey(1) && map.get(1).size() == 1) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * 解法二
     * @param nums
     * @return
     */
    public int maxEqualFreq2(int[] nums) {
        int len = nums.length;
        int []sub = new int[100001];
        int []pre = new int[100001];
        int res = 0;
        int cur = 0;
        for(int i=0;i<len;i++){
            pre[++sub[nums[i]]]++;
            cur = Math.max(sub[nums[i]],cur);
            if(pre[cur]==1 && pre[cur-1] * (cur-1)+1 == (i+1) || (pre[cur]*cur+1==i+1)){
                res=i+1;
            }
        }
        if(cur == 1) return nums.length;
        return res;
    }
}
