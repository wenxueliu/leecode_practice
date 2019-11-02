package com.wenxueliu.leetcode;

/**
 * @author ： liuwenxue
 * @date ：2019/11/02 10:26
 * @description :
 * @path : com.wenxueliu.leetcode.LeetCode6
 * @modifiedBy ：
 */
public class LeetCode6 {

    //58%
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }
        int length = s.length();
        int baseColums = length / (numRows + numRows - 2) * (numRows - 1);
        int left =  length - baseColums / (numRows - 1) * (numRows + numRows - 2);
        int colums = 0;
        if (left <= numRows) {
            colums = baseColums + 1;
        } else {
            colums += baseColums + + 1 + left - numRows;
        }
        int rows = numRows;

        char [][] matrix = new char[rows][colums] ;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < colums; col++) {
                matrix[row][col] = ' ';
            }
        }
        int index = 0;
        for (int col = 0; col < colums; col++) {
            if (col % (numRows - 1) == 0) {
                for (int row = 0; row < numRows; row++) {
                    if (index == length) {
                        break;
                    } else {
                        matrix[row][col]  = s.charAt(index);
                        index++;
                    }
                }
            } else {
                if (index == length) {
                    break;
                } else {
                    matrix[numRows - 1 - col % (numRows - 1)][col] = s.charAt(index);
                    index++;
                }
            }
        }

        StringBuilder ret = new StringBuilder();
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < colums; col++) {
                if (matrix[row][col] != ' ') {
                    ret.append(matrix[row][col]);
                }
            }
        }
        return ret.toString();
    }
}
