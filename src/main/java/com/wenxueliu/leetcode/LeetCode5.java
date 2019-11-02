package com.wenxueliu.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ： liuwenxue
 * @date ：2019/11/02 10:25
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode5
 * @modifiedBy ：
 */
public class LeetCode5 {

    //很早的一种解法 时间仅仅超过 9%
    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        List<String> source = StringToList(s);
        Set<String> targetSet = new HashSet<>(source);
        if (targetSet.size() == source.size()) {
            return source.get(0);
        } else if (targetSet.size() == 1) {
            return String.join("", source);
        }

        List<String> target = new ArrayList<>();
        int index = 0;
        while (index < source.size()) {
            List<String> tmpTarget = new ArrayList<>();
            index = subSetOfNoDuplicated(source, index, tmpTarget);
            if (tmpTarget.size() > target.size()) {
                target = tmpTarget;
            }
        }
        return String.join("", target);
    }

    private List<String> StringToList(String str) {
        List<String> strList = new ArrayList<>();
        for (char ch : str.toCharArray()) {
            char []charArray = new char[1];
            charArray[0] = ch;
            strList.add(String.valueOf(charArray));
        }
        return strList;
    }

    private int subSetOfNoDuplicated(final List<String> list, int startIndex, List<String> target) {
        int size = list.size();
        String startEle = list.get(startIndex);
        target.add(startEle);
        int validIndex = startIndex;
        for (int index = startIndex+1; index < size; index++) {
            String ele = list.get(index);
            target.add(ele);
            if (ele.equals(startEle)) {
                validIndex = index;
            }
        }
        target.subList(validIndex+1-startIndex, target.size()).clear();
        while (target.size() > 1) {
            if (!isPalindromic(target)) {
                target.subList(target.size()-1, target.size()).clear();
                //target.clear();
                //target.add(startEle);
            } else {
                break;
            }
        }
        return startIndex+1;
    }

    boolean isPalindromic(List<String> target) {
        int maxIndex = target.size() - 1;
        int mid = target.size()/2;
        for (int index = 0; index <= mid; index++) {
            if (!target.get(index).equals(target.get(maxIndex-index))) {
                return false;
            }
        }
        return true;
    }
}
