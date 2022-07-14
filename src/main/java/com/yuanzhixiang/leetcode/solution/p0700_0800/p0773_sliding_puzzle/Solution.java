package com.yuanzhixiang.leetcode.solution.p0700_0800.p0773_sliding_puzzle;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import com.yuanzhixiang.leetcode.solution.util.DecodeUtil;
import com.yuanzhixiang.leetcode.solution.util.PrintUtil;

/**
 * @author yuanzhixiang
 */
class Solution {

    public static void main(String[] args) {
        int[][] board = DecodeUtil.twoDimensionalInt("[[4,1,2],[5,0,3]]");

        Solution solution = new Solution();

        int i = solution.slidingPuzzle(board);

        System.out.println();
    }

    private static final int[][] TARGET = new int[][]{{1,2,3}, {4,5,0}};

    public int slidingPuzzle(int[][] board) {
        Queue<int[][]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(board);
        visited.add(boardToString(board));

        int step = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            step++;

            for (int i = 0; i < size; i++) {
                int[][] node = queue.poll();

                if (equalsBoard(node, TARGET)) {
                    return step;
                }

                int x = 0;
                int y = 0;
                while (x < node.length) {

                    y = 0;

                    while(y < node[x].length) {

                        if (node[x][y] == 0) {
                            break;
                        }

                        y++;
                    }

                    if (y != 3 && node[x][y] == 0) {
                        break;
                    }

                    x++;
                }

                // up down left right
                up(node, x, y, queue, visited);
                down(node, x, y, queue, visited);
                left(node, x, y, queue, visited);
                right(node, x, y, queue, visited);
            }
        }

        return -1;
    }

    private String boardToString(int[][] board) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                builder.append(board[i][j]);
            }
        }
        return builder.toString();
    }

    private boolean equalsBoard(int[][] current, int[][] target) {
        for (int i = 0; i < current.length; i++) {
            for (int j = 0; j < current[i].length; j++) {
                if (current[i][j] != target[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    private void up(int[][] board, int x, int y, Queue<int[][]> queue, Set<String> visited) {

        int newX = x - 1;
        if (newX < 0) {
            return;
        }

        swap(board, x, y, newX, y, queue, visited);
    }

    private void down(int[][] board, int x, int y, Queue<int[][]> queue, Set<String> visited) {

        int newX = x + 1;
        if (newX >= board.length) {
            return;
        }

        swap(board, x, y, newX, y, queue, visited);
    }

    private void left(int[][] board, int x, int y, Queue<int[][]> queue, Set<String> visited) {

        int newY = y - 1;
        if (newY < 0) {
            return;
        }

        swap(board, x, y, x, newY, queue, visited);
    }

    private void right(int[][] board, int x, int y, Queue<int[][]> queue, Set<String> visited) {

        int newY = y + 1;
        if (newY >= board[0].length) {
            return;
        }

        swap(board, x, y, x, newY, queue, visited);
    }

    private void swap(int[][] board, int x, int y, int newX, int newY, Queue<int[][]> queue, Set<String> visited) {

        int[][] newBoard = copy(board);

        int temp = newBoard[x][y];
        newBoard[x][y] = newBoard[newX][newY];
        newBoard[newX][newY] = temp;

        if (visited.contains(boardToString(newBoard))) {
            return;
        }

        queue.offer(newBoard);
        visited.add(boardToString(newBoard));
    }

    private int[][] copy(int[][] board) {
        int[][] newBoard = new int[board.length][];
        for (int i = 0; i < board.length; i++) {
            newBoard[i] = new int[board[i].length];
            for (int j = 0; j < board[i].length; j++) {
                newBoard[i][j] = board[i][j];
            }
        }
        return newBoard;
    }

}
