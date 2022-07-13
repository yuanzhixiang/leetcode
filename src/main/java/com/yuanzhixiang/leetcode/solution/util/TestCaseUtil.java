package com.yuanzhixiang.leetcode.solution.util;

import java.io.File;
import java.util.List;

import cn.hutool.core.io.FileUtil;

/**
 * @author yuanzhixiang
 */
public class TestCaseUtil {

    private static final String MAIN = "main";

    /**
     * Load testcase
     *
     * @return testcase
     */
    public static List<String> load() {

        // Get stack trace
        RuntimeException runtimeException = new RuntimeException();
        StackTraceElement[] stackTrace = runtimeException.getStackTrace();
        StackTraceElement stackTraceElement = stackTrace[stackTrace.length - 1];

        // Check is main start invoke
        if (!MAIN.equals(stackTraceElement.getMethodName())) {
            throw new RuntimeException("The invoke initialize method is not main.");
        }

        // Get path
        String className = stackTraceElement.getClassName();

        int start, end = -1;

        String firstPath = null;
        String secondPath = null;

        for (int i = className.length() - 1; i >= 0; i--) {
            if (end == -1 && '.' == className.charAt(i)) {
                end = i;
                continue;
            }

            if ('.' == className.charAt(i)) {
                start = i;

                if (firstPath == null) {
                    firstPath = className.substring(start + 1, end);
                } else if (secondPath == null) {
                    secondPath = className.substring(start + 1, end);
                } else {
                    break;
                }

                end = start;
            }
        }

        // Append path
        String testcase = append("testcase", secondPath, firstPath, "testcase.txt");

        // Get testcase
        return FileUtil.readUtf8Lines(testcase);
    }

    private static String append(String... strings) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < strings.length; i++) {
            builder.append(strings[i]);

            if (i + 1 != strings.length) {
                builder.append(File.separator);
            }
        }

        return builder.toString();
    }

}
