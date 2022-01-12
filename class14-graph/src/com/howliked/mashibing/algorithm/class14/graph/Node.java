package com.howliked.mashibing.algorithm.class14.graph;

import java.util.List;

/**
 * 点结构
 */
public class Node {
    public int value;
    public int in;
    public int out;
    public List<Node> nodes;
    public List<Edge> edges;

    public Node(int value) {
        this.value = value;
    }
}
