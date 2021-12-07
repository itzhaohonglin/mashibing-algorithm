package com.howliked.mashibing.algorithm.class12;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 会议室问题
 * 一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目的宣讲。给你每一个项目开始的时间和结束的时间你来安排宣讲的日程，要求会议室进行的宣讲的场次最多。返回最多的宣讲场次。 
 */
public class Code03_BestArrange {

    public static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // 会议的开始时间和结束时间，都是数值，不会 < 0
    public static int bestArrange2(Program[] programs) {
        PriorityQueue<Program> queue = new PriorityQueue(new MyComparator());
        int res = 0;
        int timeline = 0;
        for (int i = 0; i < programs.length; i++) {
            if (timeline <= programs[i].start) {
                res++;
                timeline = programs[i].end;
            }
        }
        return res;
    }

    /**
     * 按照结束时间排序
     */
    private static class MyComparator implements Comparator<Program> {

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }
}
