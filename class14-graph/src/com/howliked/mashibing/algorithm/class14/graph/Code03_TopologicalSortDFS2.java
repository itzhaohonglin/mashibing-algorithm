package com.howliked.mashibing.algorithm.class14.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * 拓扑排序:https://www.lintcode.com/problem/topological-sorting
 * 点次
 */
public class Code03_TopologicalSortDFS2 {
    // 不要提交这个类
    public static class DirectedGraphNode {
        public int label;
        public ArrayList<DirectedGraphNode> neighbors;

        public DirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<DirectedGraphNode>();
        }
    }

    private static class Record {
        private DirectedGraphNode graphNode;
        private int deep;

        public Record(DirectedGraphNode graphNode, int deep) {
            this.graphNode = graphNode;
            this.deep = deep;
        }
    }

    public static class MyComparator implements Comparator<Record> {

        @Override
        public int compare(Record o1, Record o2) {
            return o2.deep - o1.deep;
        }
    }

    public static ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        HashMap<DirectedGraphNode, Record> hashMap = new HashMap<>();
        for (DirectedGraphNode graphNode : graph) {
            f(graphNode, hashMap);
        }
        ArrayList<DirectedGraphNode> result = new ArrayList<>();

        return result;
    }

    private static Record f(DirectedGraphNode graphNode, HashMap<DirectedGraphNode, Record> hashMap) {
        return null;
    }


}
