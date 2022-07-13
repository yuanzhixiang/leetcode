package com.yuanzhixiang.leetcode.solution.p0001_0100.p0037_sudoku_solver;

import java.util.List;

import com.yuanzhixiang.leetcode.solution.util.DecodeUtil;
import com.yuanzhixiang.leetcode.solution.util.PrintUtil;
import com.yuanzhixiang.leetcode.solution.util.TestCaseUtil;

/**
 * @author yuanzhixiang
 */
class Solution {

    public static void main(String[] args) {

        List<String> load = TestCaseUtil.load();

        char[][] ints = DecodeUtil.twoDimensionalChar(load.get(0));

        Solution solution = new Solution();

        solution.solveSudoku(ints);

        System.out.println();
    }

    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    private static final int ZERO_CHAR = '0';

    private boolean end = false;

    private void backtrack(char[][] board, int row, int col) {

        if (end) {
            return;
        }

        if (row == 9) {
            end = true;
            return;
        }

        if (board[row][col] != '.') {
            if (col + 1 == 9) {
                backtrack(board, row + 1, 0);
            } else {
                backtrack(board, row, col + 1);
            }
            return;
        }

        for (int i = 1; i < 10; i++) {

            if (end) {
                return;
            }

            board[row][col] = (char) (i + ZERO_CHAR);

            if (!valid(board, row, col)) {
                board[row][col] = '.';
                continue;
            }

            if (col + 1 == 9) {
                backtrack(board, row + 1, 0);
            } else {
                backtrack(board, row, col + 1);
            }

            if (!end) {
                board[row][col] = '.';
            }
        }
    }

    private boolean valid(char[][] board, int row, int col) {
        for (int i = 0; i < 9; i++) {
            if (col == i) {
                continue;
            }
            if (board[row][col] == board[row][i]) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (row == i) {
                continue;
            }
            if (board[row][col] == board[i][col]) {
                return false;
            }
        }

        int rowUp;
        int rowDown;
        if (row <= 2) {
            rowUp = 0;
            rowDown = 2;
        } else if (row <=5) {
            rowUp = 3;
            rowDown = 5;
        } else {
            rowUp = 6;
            rowDown = 8;
        }

        int colLeft;
        int colRight;
        if (col <=2) {
            colLeft = 0;
            colRight = 2;
        } else if (col <= 5) {
            colLeft = 3;
            colRight = 5;
        } else {
            colLeft = 6;
            colRight = 8;
        }

        for (int i = rowUp; i <= rowDown; i++) {
            for (int j = colLeft; j <= colRight; j++) {
                if (row == i && col == j) {
                    continue;
                }

                if (board[i][j] == board[row][col]) {
                    return false;
                }
            }
        }

        return true;
    }
}
