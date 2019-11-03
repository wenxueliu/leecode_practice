package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/11/03 10:11
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode468
 * @modifiedBy ：
 */
public class LeetCode468 {

    /**
     * 11-03
     * 思路：按照题目描述解析即可
     * 实现：没有考虑两种情况：
     * 1. String.split 方法，最后的分隔符不计数。比如 "172.1.254.1..".split("\\.").length 不是 6 而是 4
     * 2. 没有注意到 Ipv6 的字母是 a-f A-F 而不是 a-z, A-Z
     * 第三次提交成功，时间超过 100%
     * @param IP
     * @return
     */
    public String validIPAddress(String IP) {
        if (isIpv4(IP)) {
            return "IPv4";
        } else if (isIpv6(IP)) {
            return "IPv6";
        }
        else {
            return "Neither";
        }
    }

    boolean isIpv4(String Ip) {
        String[] ips = Ip.split("\\.");
        if (Ip.endsWith(".")) {
            return false;
        }
        //每个字符不为空
        if (ips.length != 4) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            String ip = ips[i];
            if (!isVaildIpNum(ip)) {
                return false;
            }
        }
        return true;
    }

    boolean isVaildIpNum(String ip) {
        int len = ip.length();
        //不超过 3 位数
        if (len > 3 || len == 0) {
            return false;
        }
        int value = 0;
        //长度大于 1，以 0 开头
        if (ip.charAt(0) == '0' && len > 1) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            //不是 0-9
            if (ip.charAt(i) > '9' || ip.charAt(i) < '0') {
                return false;
            }
            value += value*10 + ip.charAt(i) - '0';
        }
        //不大于 255
        if (Integer.valueOf(ip) > 255) {
            return false;
        }
        return true;
    }

    boolean isIpv6(String Ip) {
        if (Ip.endsWith(":")) {
            return false;
        }
        String[] ips = Ip.split(":");
        if (ips.length != 8) {
            return false;
        }
        for (int i = 0; i < 8; i++) {
            if (!isValidIpv6Num(ips[i])) {
                return false;
            }
        }
        return isValidIpv6Num(ips[0]);
    }

    boolean isValidIpv6Num(String ipv6) {
        int len = ipv6.length();
        if (len == 0 || len > 4) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (!isVaildChar(ipv6.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    boolean isVaildChar(char c) {
        boolean isNum = '0' <= c && c <= '9';
        boolean isLowerAlpha = 'a' <= c && c <= 'f';
        boolean isUpperAlpha = 'A' <= c && c <= 'F';
        if (isNum || isLowerAlpha || isUpperAlpha) {
            return true;
        } else {
            return false;
        }
    }

    String isIpv61(String Ip) {
        String[] ips = Ip.split(":");
        return String.valueOf(ips.length);
    }
}
