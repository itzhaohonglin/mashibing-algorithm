package com.howliked.mashibing.algorithm.class12;

import java.util.PriorityQueue;

/**
 * 分金问题
 * 一块金条切成两半，是需要花费和长度数值一样的铜板的。比如长度为20的金条，不管怎么切，都要花费20个铜板。
 * 一群人想整分整块金条，怎么分最省铜板?
 * 例如,给定数组{10,20,30}，代表一共三个人，整块金条长度为60，金条要分成10，20，30三个部分。如果先把长度60的金条分成10和50，花费60;
 * 再把长度50的金条分成20和30，花费50;一共花费110铜板。但如果先把长度60的金条分成30和30，花费60;再把长度30金条分成10和20，
 * 花费30;一共花费90铜板。
 * 输入一个数组，返回分割的最小代价。
 */
public class Code04_LessMoneySplitGold {

    public static int lessMoney(int[] arr) {
        int res = 0;
        PriorityQueue<Integer> queue = new PriorityQueue();
        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
        }
        while (queue.size() > 1) {
            int count = queue.poll() + queue.poll();
            res += count;
            queue.offer(count);
        }
        return res;
    }
}
