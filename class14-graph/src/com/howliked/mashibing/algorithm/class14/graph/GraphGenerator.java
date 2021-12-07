package com.howliked.mashibing.algorithm.class14.graph;

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
        int N = matrix.length;
        //拿到每一条边
        for (int i = 0; i < N; i++) {
            int weight = matrix[i][0];
            int fromVal = matrix[i][1];
            int toVal = matrix[i][2];
            if (!graph.nodes.containsKey(fromVal)) {
                graph.nodes.put(fromVal, new Node(fromVal));
            }
            if (!graph.nodes.containsKey(toVal)) {
                graph.nodes.put(toVal, new Node(toVal));
            }
            Node fromNode = graph.nodes.get(fromVal);
            Node toNode = graph.nodes.get(toVal);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            Edge edge = new Edge(weight, fromNode, toNode);
            fromNode.edges.add(edge);
            graph.edges.add(edge);
        }
        return graph;
    }

}
