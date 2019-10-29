package com.wenxueliu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ： liuwenxue
 * @date ：2019/10/22 22:26
 * @description :
 * @path : com.wenxueliu.leetcode.Nqueen
 * @modifiedBy ：
 * 没有完成
 */
public class Nqueen {

    public static void main(String[] args) {
        Nqueen cal8queen = new Nqueen();
        for (List<String> oneSolution : cal8queen.solveNQueens(3)) {
            for (String ele : oneSolution) {
                System.out.println(ele);
            }
        };
    }

    public List<List<String>> solveNQueens(int n) {
        List<String> initMatrix = init(n);
        List<List<String>> finalResult = new ArrayList<List<String>>();
        cal8Queen(initMatrix, 0, finalResult);
        return finalResult;
    }

    public boolean cal8Queen(List<String> result, int row, List<List<String>> finalResult) {
        int n = result.size();
        if (row < n-1) {
            for (int column = 0; column < n; column++) {
                if (isOk(result, row, column)) {
                    setValue(result, row, column, 'Q');
                    row++;
                    if (cal8Queen(result, row, finalResult)) {
                        row--;
                        if (row == 0) {
                            result = init(n);
                            continue;
                        }
                        return true;
                    } else {
                        row--;
                        setValue(result, row, column, '.');
                    }
                }
            }
            return false;
        }
        if (row == n-1) {
            for (int column = 0; column < n; column++) {
                if (isOk(result, row, column)) {
                    setValue(result, row, column, 'Q');
                    finalResult.add(result);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isOk(List<String> result, int row, int column) {
        int n = result.size();
        //colum
        for (int rowIndex = 0; rowIndex < n; rowIndex++) {
            if (getValue(result, rowIndex, column).equals("Q")) {
                return false;
            }
        }
        //row
        for (int columnIndex = 0; columnIndex < n; columnIndex++) {
            if (getValue(result, row, columnIndex).equals("Q")) {
                return false;
            }
        }
        if (!isLeftDownToRightUpOk(result, row, column)) {
            return false;
        }
        if (!isLeftUpToRightdownOk(result, row, column)) {
            return false;
        }
        return true;
    }

    boolean isLeftDownToRightUpOk(List<String> result, int row, int column) {
        int n = result.size();
        int columnStart = column > (n - 1 - row) ? column - (n - 1 - row) : 0;
        int columnStop = row > (n - 1 - column) ? n-1 : column + row;
        int rowStart = column > (n - 1 - row) ? n-1 : row + column - (n - 1 - row);
        int rowStop = row > (n - 1 - column) ? row - (n - 1 - column) : 0;
        while (columnStart < columnStop && rowStart > rowStop) {
            if (getValue(result, rowStart, columnStart).equals("Q")) {
                return false;
            }
            columnStart++;
            rowStart--;
        }
        return true;
    }

    boolean isLeftUpToRightdownOk(List<String> result, int row, int column) {
        int n = result.size();
        int columnStart = column > row ? column - row : 0;
        int columnStop = n - 1 - column > (n - 1 - row) ? column + (n - 1 - row) : n;
        int rowStart = column > row ? 0 : row - column;
        int rowStop = n - 1 - row > (n - 1 - column) ? row + (n - 1 - column) : 0;
        while (columnStart < columnStop && rowStart < rowStop) {
            if (getValue(result, rowStart, columnStart).equals("Q")) {
                return false;
            }
            columnStart++;
            rowStart++;
        }
        return true;
    }

    void setValue(List<String> result, int row, int column, char value) {
        char[] bytes = result.get(row).toCharArray();
        bytes[column] = value;
        result.set(row, String.valueOf(bytes));
    }

    String getValue(List<String> result, int row, int column) {
        char[] bytes = result.get(row).toCharArray();
        return String.valueOf(bytes[column]);
    }

    private List<String> init(int n) {
        List<String> one = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            StringBuilder ele = new StringBuilder();
            for (int j = 0; j < n; j++) {
                ele.append(".");
            }
            one.add(ele.toString());
        }
        return one;
    }

}
