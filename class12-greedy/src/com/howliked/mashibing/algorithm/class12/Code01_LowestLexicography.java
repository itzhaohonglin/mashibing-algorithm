package com.howliked.mashibing.algorithm.class12;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个由字符串组成的数组strs，必须把所有的字符串拼接起来，返回所有可能的拼接结果中，字典序最小的结果
 */
public class Code01_LowestLexicography {
    private static class MyComparator implements Comparator<String> {

        public static void main(String[] args) {
            String[] strs = new String[]{"ba","b","ab"};
            System.out.println(lowestString(strs));
        }

        @Override
        public int compare(String o1, String o2) {
            return (o1 + o2).compareTo(o2 + o1);
        }
    }

    public static String lowestString(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        String result = "";
        Arrays.sort(strs, new MyComparator());
        for (int i = 0; i < strs.length; i++) {
            result += strs[i];
        }
        return result;
    }
}
