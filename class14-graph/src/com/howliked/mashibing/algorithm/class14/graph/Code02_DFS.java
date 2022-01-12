package com.howliked.mashibing.algorithm.class14.graph;

import java.util.*;

/**
 * 图的深度优先遍历
 */
public class Code02_DFS {
    public static List<Integer> bfs(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Set<Node> setNode = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        setNode.add(root);
        result.add(root.value);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            for (Node next : node.nodes) {
                if (!setNode.contains(next)) {
                    stack.push(node);   //要将当前node重新压进栈,原因是:
                    stack.push(next);
                    setNode.add(next);
                    result.add(root.value);
                    break;
                }
            }
        }
        return result;
    }
}
