package com.howliked.mashibing.algorithm.class14.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * 图的深度优先遍历
 */
public class Code02_DFS {
    public static List<Integer> bfs(Node root) {
        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        HashSet<Node> nodeSet = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        nodeSet.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.value);
            for (Node next : node.nexts) {
                if (!nodeSet.contains(node)) {
                    stack.push(node);
                    stack.push(next);
                    nodeSet.add(next);
                    break;
                }
            }
        }
        return result;
    }
}
