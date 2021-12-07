package com.howliked.mashibing.algorithm.class12;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 股票问题
 * 输入:正数数组costs、正数数组profits、正数K、正数M
 * costs[i]表示i号项目的花费
 * profits[i]表示i号项目在扣除花费之后还能挣到的钱(利润)
 * K表示你只能串行的最多做k个项目W表示你初始的资金说明:
 * 每做完一个项目，马上获得的收益，可以支持你去做下一个项目。不能并行的做项目。输出：你最后获得的最大钱数。
 */
public class Code05_IPO {
    // 最多K个项目
    // W是初始资金
    // Profits[] Capital[] 一定等长
    // 返回最终最大的资金

    public static class Program {
        public int p;
        public int c;

        public Program(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    /**
     * 思路:
     * 小根堆:按本金排序
     * 大根堆:按照排序
     * 每一个
     * @param K
     * @param W
     * @param Profits
     * @param Capital
     * @return
     */
    public static int findMaximizedCapital(int K, int W, int[] Profits, int[] Capital) {
        //小根堆:按照资金最小升序排序
        PriorityQueue<Program> cQueue = new PriorityQueue(new CapitalComparator());
        //大根堆:按照最大收益降序排序
        PriorityQueue<Program> pQueue = new PriorityQueue(new ProfitsComparator());
        for (int i = 0; i < Capital.length; i++) {
            cQueue.offer(new Program(Profits[i], Capital[i]));
        }
        for (int i = 0; i < K; i++) {
            while (!cQueue.isEmpty() && pQueue.peek().c <= W) {
                pQueue.add(pQueue.poll());
            }
            if (pQueue.isEmpty()) {
                return W;
            }
            W += pQueue.poll().p;
        }

        return W;
    }

    private static class ProfitsComparator implements Comparator<Program> {

        @Override
        public int compare(Program o1, Program o2) {
            return o2.p - o1.p;
        }
    }

    private static class CapitalComparator implements Comparator<Program> {

        @Override
        public int compare(Program o1, Program o2) {
            return o1.c - o2.c;
        }
    }
}
