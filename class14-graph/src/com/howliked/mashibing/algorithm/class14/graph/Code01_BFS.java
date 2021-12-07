package com.howliked.mashibing.algorithm.class14.graph;

import java.util.*;

/**
 * 图的宽度优先遍历
 */
public class Code01_BFS {
    public static List<Integer> bfs(Node root) {
        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> nodeSet = new HashSet<>();
        queue.offer(root);
        nodeSet.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            result.add(node.value);
            for (Node next : node.nexts) {
                if (!nodeSet.contains(next)) {
                    queue.offer(next);
                    nodeSet.add(next);
                }
            }
        }
        return result;
    }
}
