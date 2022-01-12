package com.howliked.mashibing.algorithm.class14.graph;

import java.util.ArrayList;

/**
 * 拓扑排序:https://www.lintcode.com/problem/topological-sorting
 */
public class Code03_TopologicalSortDFS1 {
    // 不要提交这个类
    public static class DirectedGraphNode {
        public int label;
        public ArrayList<DirectedGraphNode> neighbors;

        public DirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<DirectedGraphNode>();
        }
    }

}
