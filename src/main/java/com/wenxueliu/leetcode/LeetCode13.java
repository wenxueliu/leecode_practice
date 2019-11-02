package com.wenxueliu.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ： liuwenxue
 * @date ：2019/11/01 23:48
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode13
 * @modifiedBy ：
 *
 * refer: https://leetcode-cn.com/problems/roman-to-integer/
 * 11-01
 * 思路：显然没有在 leetcode12 的基础上想出这个这个办法
 * 实现：思路确定，实现很简单。问题在于执行效率不高，仅仅超过 50%
 *
 * 备注：这里面的各种解法充分说明了 String, HashMap 是性能杀手，要有好的性能，避免使用 String 和 HashMap 等高级数据结构
 */
public class LeetCode13 {
    public int romanToInt(String s) {
        Map<String, Integer> romanToInt = new HashMap<>();
        romanToInt.put("I", 1);
        romanToInt.put("IV", 4);
        romanToInt.put("V", 5);
        romanToInt.put("IX", 9);
        romanToInt.put("X", 10);
        romanToInt.put("XL", 40);
        romanToInt.put("L", 50);
        romanToInt.put("XC", 90);
        romanToInt.put("C", 100);
        romanToInt.put("CD", 400);
        romanToInt.put("D", 500);
        romanToInt.put("CM", 900);
        romanToInt.put("M", 1000);

        int res = 0;
        for (int i = 0; i < s.length();) {
            if (i + 1 < s.length() && romanToInt.containsKey(s.substring(i, i+2))) {
                res += romanToInt.get(s.substring(i, i+2));
                i += 2;
            } else {
                res += romanToInt.get(s.substring(i, i+1));
                i += 1;
            }
        }
        return res;
    }

    /*
     * 在可读性没有下降很多的情况下，时间超过 91%
     */
    public int romanToInt2(String s) {
        int len = s.length();
        int romanInt = 0;
        for (int i=0; i<len; i++ ) {
            switch(s.charAt(i)) {
                case 'I' : romanInt += 1; break;
                case 'V' : romanInt += 5; break;
                case 'X' : romanInt += 10; break;
                case 'L' : romanInt += 50; break;
                case 'C' : romanInt += 100; break;
                case 'D' : romanInt += 500; break;
                case 'M' : romanInt += 1000; break;
            }

            //这里通过补偿的机制，非常巧妙
            if (i != 0) {
                String twoChar = s.substring(i-1, i+1);
                if (twoChar.equals("IV") || twoChar.equals("IX")) {
                    romanInt -= 1 * 2;
                }
                if (twoChar.equals("XL") || twoChar.equals("XC")) {
                    romanInt -= 10 * 2;
                }
                if (twoChar.equals("CD") || twoChar.equals("CM")) {
                    romanInt -= 100 * 2;
                }
            }
        }
        return romanInt;
    }

    /*
     * 将 romanInt2 的 String 替换为 char，超过 97%，终于满意了
     */
    public int romanToInt6(String s) {
        int len = s.length();
        int romanInt = 0;
        for (int i=0; i<len; i++ ) {
            switch(s.charAt(i)) {
                case 'I' : romanInt += 1; break;
                case 'V' : romanInt += 5; break;
                case 'X' : romanInt += 10; break;
                case 'L' : romanInt += 50; break;
                case 'C' : romanInt += 100; break;
                case 'D' : romanInt += 500; break;
                case 'M' : romanInt += 1000; break;
            }

            //这里通过补偿的机制，非常巧妙
            if (i != 0) {
                char firstChar = s.charAt(i-1);
                char secondChar = s.charAt(i);
                if (firstChar == 'I' && (secondChar == 'V' || secondChar == 'X')) {
                    romanInt -= 2;
                }
                if (firstChar == 'X' && (secondChar == 'L' || secondChar == 'C')) {
                    romanInt -= 20;
                }
                if (firstChar == 'C' && (secondChar == 'D' || secondChar == 'M')) {
                    romanInt -= 200;
                }
            }
        }
        return romanInt;
    }

    /*
     * romanToInt1 的 HashMap 转为 switch，时间提高到 91%，这里减少了一次遍历
     * 可读性略差
     */
    public int romanToInt3(String s) {
        int res = 0;
        for (int i = 0; i < s.length();) {
            boolean isTwoChar = true;
            if (i + 1 < s.length()) {
                switch (s.substring(i, i + 2)) {
                    case "IV":
                        res += 4;
                        break;
                    case "IX":
                        res += 9;
                        break;
                    case "XL":
                        res += 40;
                        break;
                    case "XC":
                        res += 90;
                        break;
                    case "CD":
                        res += 400;
                        break;
                    case "CM":
                        res += 900;
                        break;
                    default:
                        isTwoChar = false;
                }
                if (isTwoChar) {
                    i += 2;
                }
            } else {
                isTwoChar = false;
            }
            if (!isTwoChar) {
                switch (s.charAt(i)) {
                    case 'I': res += 1; break;
                    case 'V': res += 5; break;
                    case 'X': res += 10; break;
                    case 'L': res += 50; break;
                    case 'C': res += 100; break;
                    case 'D': res += 500; break;
                    case 'M': res += 1000; break;
                }
                i += 1;
            }
        }
        return res;
    }

    /*
     *  将 romanToInt 的 hashMap 变为数组，性能给 83%，显然算法复杂度比 romanInt2 仍然略高
     */
    public int romanToInt4(String s) {
        int res = 0;
        for (int i = 0; i < s.length();) {
            if (i + 1 < s.length() && getRomanToInt(s.substring(i, i+2)) != 0) {
                res += getRomanToInt(s.substring(i, i+2));
                i += 2;
            } else {
                res += getRomanToInt(s.substring(i, i+1));
                i += 1;
            }
        }
        return res;
    }

    /*
     *  时间 87%
     */
    public int getRomanToInt1(String roman) {
        int ret = 0;
        switch (roman) {
            case "I": ret = 1; break;
            case "IV": ret = 4; break;
            case "V": ret = 5; break;
            case "IX": ret = 9; break;
            case "X": ret = 10; break;
            case "XL": ret = 40; break;
            case "L": ret = 50; break;
            case "XC": ret = 90; break;
            case "C": ret = 100; break;
            case "CD": ret = 400; break;
            case "D": ret = 500; break;
            case "CM": ret = 900; break;
            case "M": ret = 1000; break;
        }
        return ret;
    }

    /*
     *  时间 82%
     */
    public int getRomanToInt(String roman) {
        String[] romans = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] ints = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        int len = romans.length;
        for (int i = 0; i < len; i++) {
            if (romans[i].equals(roman)) {
                return ints[i];
            }
        }
        return 0;
    }

    /*
     * romamToInt2 的 switch 转为数组
     */
    public int romanToInt5(String s) {
        int len = s.length();
        int romanInt = 0;
        for (int i=0; i<len; i++ ) {
            String str = s.substring(i, i+1);
            romanInt += getRomanToInt5(str);
            //这里通过补偿的机制，非常巧妙
            if (i != 0) {
                String twoChar = s.substring(i-1, i+1);
                romanInt -= getRomanToInt5(twoChar);
            }
        }
        return romanInt;
    }

    public int getRomanToInt5(String roman) {
        String[] romans = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] ints = {1, 2, 5, 2, 10, 20, 50, 20, 100, 200, 500, 200, 1000};
        int len = romans.length;
        for (int i = 0; i < len; i++) {
            if (romans[i].equals(roman)) {
                return ints[i];
            }
        }
        return 0;
    }

    /*
     * 仅仅将 romanToInt3 的 String 用 char 替换，97%
     */
    public int romanToInt7(String s) {
        int res = 0;
        for (int i = 0; i < s.length();) {
            boolean isTwoChar = true;
            if (i + 1 < s.length()) {
                char firstChar = s.charAt(i-1);
                char secondChar = s.charAt(i);
                if (firstChar == 'I' && secondChar == 'V') {
                    res += 4;
                } else if (firstChar == 'I' && secondChar == 'X') {
                    res += 9;
                } else if (firstChar == 'X' && secondChar == 'L') {
                    res += 40;
                } else if (firstChar == 'X' && secondChar == 'C') {
                    res += 90;
                } else if (firstChar == 'C' && secondChar == 'D') {
                    res += 400;
                } else if (firstChar == 'C' && secondChar == 'M') {
                    res += 900;
                } else {
                    isTwoChar = false;
                }
                if (isTwoChar) {
                    i += 2;
                }
            } else {
                isTwoChar = false;
            }
            if (!isTwoChar) {
                switch (s.charAt(i)) {
                    case 'I': res += 1; break;
                    case 'V': res += 5; break;
                    case 'X': res += 10; break;
                    case 'L': res += 50; break;
                    case 'C': res += 100; break;
                    case 'D': res += 500; break;
                    case 'M': res += 1000; break;
                }
                i += 1;
            }
        }
        return res;
    }
}
