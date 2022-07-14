package com.yuanzhixiang.leetcode.solution.p0001_0100.p0022_generate_parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuanzhixiang
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        char[] chars = new char[2 * n];
        List<String> result = new ArrayList<>();

        backtrack(chars, 0, n, n, result);

        return result;
    }

    private void backtrack(char[] chars, int index, int left, int right, List<String> result) {
        if (right < left) {
            return;
        }

        if (left == 0 && right == 0) {
            result.add(new String(chars));
            return;
        }

        if (left > 0) {
            chars[index] = '(';
            backtrack(chars, index + 1, left - 1, right, result);
        }

        if (right > 0) {
            chars[index] = ')';
            backtrack(chars, index + 1, left, right - 1, result);
        }
    }
}
