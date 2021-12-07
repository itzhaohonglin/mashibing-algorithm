package com.howliked.mashibing.algorithm.class14.graph;

/**
 * 边
 */
public class Edge {
    //权重
    public int weight;
    //从哪个节点开始
    public Node from;
    //到哪个节点结束
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
