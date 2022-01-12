package com.howliked.mashibing.algirhtom.class24.kmp;

/**
 * KMP:解决字符串匹配问题
 * 例:str1:"aabaabaaf",str2:"aabaaf"
 * str1中是否包含str2的内容,如果存在则返回索引下标位置,否则返回-1
 */
public class Code01_KMP {

    public static void main(String[] args) {
        String str1 = "aabaabaaf";
        String str2 = "aabaaf";
        System.out.println(KMP(str1, str2));
    }

    public static int KMP(String str1, String str2) {
        if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0 || str1.length() < str2.length()) {
            return -1;
        }
        int j = -1;
        int[] next = getNextArray(str2);
        for (int i = 0; i < str1.length(); i++) {
            while (j >= 0 && str1.charAt(i) != str2.charAt(j + 1)) {
                j = next[j];
            }

            if (str1.charAt(i) == str2.charAt(j + 1)) {
                j++;
            }
            if (j == str2.length() - 1) {
                return i - str2.length() + 1;
            }
        }
        return -1;
    }

    private static int[] getNextArray(String word) {
        int[] nextArray = new int[word.length()];
        int j = -1;
        nextArray[0] = j;
        for (int i = 1; i < word.length(); i++) {
            while (j >= 0 && word.charAt(j + 1) != word.charAt(i)) {
                j = nextArray[j];
            }

            if (word.charAt(j + 1) == word.charAt(i)) {
                j++;
            }
            nextArray[i] = j;
        }
        return nextArray;
    }
}
