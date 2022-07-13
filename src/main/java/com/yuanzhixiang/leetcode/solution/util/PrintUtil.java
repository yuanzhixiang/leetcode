package com.yuanzhixiang.leetcode.solution.util;

/**
 * @author yuanzhixiang
 */
public class PrintUtil {

    public static void print(char[][] content) {
        System.out.println("    0 1 2 3 4 5 6 7 8");
        System.out.println("    ------------------");
        for (int i = 0; i < content.length; i++) {
            char[] chars = content[i];
            StringBuilder builder = new StringBuilder();

            builder.append(i).append(" | ");
            for (char ch : chars) {
                builder.append(ch).append(" ");
            }
            System.out.println(builder.toString());
        }
    }

}
