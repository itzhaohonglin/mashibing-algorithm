package com.howliked.mashibing.algorithm.class14.graph;

import java.util.*;

public class GraphGenerator {

    // matrix 所有的边
    // N*3 的矩阵
    // [weight, from节点上面的值，to节点上面的值]
    //
    // [ 5 , 0 , 7]
    // [ 3 , 0,  1]
    //
    public static Graph createGraph(int[][] matrix) {
        Graph graph = new Graph();
        int length = matrix.length;
        //Map<Integer, Node> nodeMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int weight = matrix[i][0];
            int from = matrix[i][1];
            int to = matrix[i][2];
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(from, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            fromNode.nodes.add(toNode);
            fromNode.out++;
            toNode.in++;
            Edge edge = new Edge(weight, fromNode, toNode);
            fromNode.edges.add(edge);
            graph.edges.add(edge);
        }

        return graph;
    }

}
