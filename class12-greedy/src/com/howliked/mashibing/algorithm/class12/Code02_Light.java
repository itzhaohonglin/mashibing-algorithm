package com.howliked.mashibing.algorithm.class12;

/**
 * 给定一个字符串str，只由‘X’和‘.’两种字符构成。‘X’表示墙，不能放灯，也不需要点亮‘.’表示居民点，可以放灯，需要点亮如果灯放在i位置，可以让i-1，i和i+1三个位置被点亮返回如果点亮str中所有需要点亮的位置，至少需要几盏灯
 */
public class Code02_Light {
    public static int minLight(String road) {
        char[] chars = road.toCharArray();
        int light = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'X') {
                i++;
            } else {
                light++;
                if (i + 1 == road.length()) {
                    return light;
                }
                if (chars[i + 1] == 'X') {
                    i = i + 2;
                } else {
                    i = i + 3;
                }
            }
        }
        return light;
    }
}
