package com.howliked.mashibing.algorithm.class25.manacher;

/**
 * Manacher(马拉车)算法:最长回文子串问题
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class Code01_Manacher {
    public static void main(String[] args) {
        String s = "babad";
        Code01_Manacher manacher = new Code01_Manacher();
        System.out.println(manacher.longestPalindrome(s));
    }

    public int longestPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return -1;
        }
        //1。预处理字符串:#1#2#3 ....
        String str = preProcess(s);
        //pArr:半径数组,记录每一个元素的最大回文半径
        int[] pArr = new int[s.length()];
        //R:最右边界
        int R = -1;
        //C:最右边界的中点
        int C = -1;
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            pArr[i] = R > i ? Math.min(2 * C - i, R - i) : 1;
            while (i + pArr[i] < s.length() && i - pArr[i] > -1) {
                if (str.charAt(i + pArr[i]) == str.charAt(i - pArr[i])) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max - 1;
    }

    private String preProcess(String s) {
        StringBuffer buffer = new StringBuffer("#");
        for (int i = 0; i < s.length(); i++) {
            buffer.append(s.charAt(i)).append("#");
        }
        return buffer.toString();
    }
}
