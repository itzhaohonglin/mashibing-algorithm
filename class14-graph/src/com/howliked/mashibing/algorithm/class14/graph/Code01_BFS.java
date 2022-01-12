package com.howliked.mashibing.algorithm.class14.graph;

import java.util.*;

/**
 * 图的宽度优先遍历
 */
public class Code01_BFS {
    public static List<Integer> bfs(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Set<Node> sets = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        sets.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            result.add(node.value);
            for (Node next : node.nodes) {
                if (!sets.contains(node)) {
                    sets.add(node);
                    queue.offer(next);
                }
            }
        }
        return result;
    }
}
