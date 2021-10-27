package com.howliked.mashibing.algorithm.class07;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 线段最大重合
 * 示例:[2,5],[3,4],[4,5],[4,6],长度>=1则有效
 * 返回: 2  ([3,4],[4,5])
 */
public class Code01_CoverMax {
    public static void main(String[] args) {
        int[][] m = new int[][]{{2, 5}, {3, 4}, {4, 5}, {7, 10}};
        System.out.println(maxCover(m));
    }

    /**
     * 思路：
     * 1.将数组进行升序排序
     * 2.使用小根堆，依次把数组线段开始区间，在堆中比线段小的弹出,留下每一条线段的结尾数值
     * 4.堆的大小就是最大重合部分
     *
     * @param m
     * @return
     */
    public static int maxCover(int[][] m) {
        Line[] lines = new Line[m.length];
        for (int i = 0; i < m.length; i++) {
            lines[i] = new Line(m[i][0], m[i][1]);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int max = 0;
        for (int i = 0; i < lines.length; i++) {
            while (!heap.isEmpty() && heap.peek() <= lines[i].start) {
                heap.poll();
            }
            heap.add(lines[i].end);
            max = Math.max(max, heap.size());
        }
        return max;
    }

    private static class Line {
        private int start;
        private int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static class StartComparator implements Comparator<Line> {

        @Override
        public int compare(Line o1, Line o2) {
            return o1.start - o2.start;
        }
    }
}
