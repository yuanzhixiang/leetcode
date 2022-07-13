package com.yuanzhixiang.leetcode.solution.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yuanzhixiang
 */
public class DecodeUtil {

    /**
     * Convert [[1,2,3][12,32,1]] to java int[][] type.
     *
     * @param string array string
     * @return int[][] type result
     */
    public static int[][] twoDimensionalInt(String string) {
        List<List<String>> convertList = convertToTwoDimensional(string);

        int[][] res = new int[convertList.size()][];

        for (int i = 0; i < convertList.size(); i++) {
            List<String> subList = convertList.get(i);
            int[] intArr = new int[subList.size()];

            for (int j = 0; j < subList.size(); j++) {
                intArr[j] = Integer.parseInt(subList.get(j));
            }

            res[i] = intArr;
        }

        return res;
    }


    /**
     * Convert [[1,2,3][12,32,1]] to java int[][] type.
     *
     * @param string array string
     * @return char[][] type result
     */
    public static char[][] twoDimensionalChar(String string) {
        List<List<String>> convertList = convertToTwoDimensional(string);

        char[][] res = new char[convertList.size()][];

        for (int i = 0; i < convertList.size(); i++) {
            List<String> subList = convertList.get(i);
            char[] array = new char[subList.size()];

            for (int j = 0; j < subList.size(); j++) {
                if (".".equals(subList.get(j))) {
                    array[j] = '.';
                } else {
                    array[j] = (char) (Integer.parseInt(subList.get(j)) + (int) '0');
                }
            }

            res[i] = array;
        }

        return res;
    }

    private static List<List<String>> convertToTwoDimensional(String string) {
        string = string.trim();
        string = string.replaceAll("\"", "");

        int start, end;
        start = end = 0;
        List<List<String>> result = new ArrayList<>();

        for (int i = 1; i < string.length() - 1; i++) {
            if (string.charAt(i) == '[') {
                start = i;
            }

            if (string.charAt(i) == ']') {
                end = i;

                String[] splitArray = string.substring(start + 1, end).split(",");

                result.add(new ArrayList<>(Arrays.asList(splitArray)));
            }
        }

        return result;
    }

}
