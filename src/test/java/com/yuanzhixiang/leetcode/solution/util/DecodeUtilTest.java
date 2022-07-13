package com.yuanzhixiang.leetcode.solution.util;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yuanzhixiang
 */
class DecodeUtilTest {

    @org.junit.jupiter.api.Test
    void twoDimensional() {

        String input = "[[1,2,3][12,32,1]]";
        int[][] ints = DecodeUtil.twoDimensionalInt(input);

        assertArrayEquals(new int[]{1, 2, 3}, ints[0]);
        assertArrayEquals(new int[]{12, 32, 1}, ints[1]);

    }
}
