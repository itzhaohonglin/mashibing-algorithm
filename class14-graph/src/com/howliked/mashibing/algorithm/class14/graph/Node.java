package com.howliked.mashibing.algorithm.class14.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 节点
 */
public class Node {
    //节点上的值
    public int value;
    //有多少节点指向
    public int in;
    //指向多少节点
    public int out;
    //有哪些邻居节点
    public List<Node> nexts;
    //有哪些边
    public List<Edge> edges;


    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
