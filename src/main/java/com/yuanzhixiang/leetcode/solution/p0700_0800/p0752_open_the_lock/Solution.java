package com.yuanzhixiang.leetcode.solution.p0700_0800.p0752_open_the_lock;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author yuanzhixiang
 */
class Solution {

    public static void main(String[] args) {

        String[] deadends = new String[]{"0201", "0101", "0102", "1212", "2002"};

        Solution solution = new Solution();
        int i = solution.openLock(deadends, "0202");

        System.out.println();
    }

    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> deadendSet = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();

        queue.offer("0000");

        int step = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            step++;

            for (int i = 0; i < size; i++) {
                String node = queue.poll();

                if (target.equals(node)) {
                    return step;
                }

                if (deadendSet.contains(node)) {
                    continue;
                }

                for (int j = 0; j < 4; j++) {
                    String plusLock = plusOne(node, j);
                    if (!visited.contains(plusLock)) {
                        queue.offer(plusLock);
                        visited.add(plusLock);
                    }

                    String minusLock = minusOne(node, j);
                    if (!visited.contains(minusLock)) {
                        queue.offer(minusLock);
                        visited.add(minusLock);
                    }

                }
            }
        }

        return -1;

    }

    private String plusOne(String lock, int index) {
        char[] lockCharArr = lock.toCharArray();

        if (lockCharArr[index] == '9') {
            lockCharArr[index] = '0';
        } else {
            lockCharArr[index] = (char) ((int) lockCharArr[index] + 1);
        }

        return new String(lockCharArr);
    }

    private String minusOne(String lock, int index) {
        char[] lockCharArr = lock.toCharArray();

        if (lockCharArr[index] == '0') {
            lockCharArr[index] = '9';
        } else {
            lockCharArr[index] = (char) ((int) lockCharArr[index] - 1);
        }

        return new String(lockCharArr);
    }
}
