package com.howliked.mashibing.algorithm.class13;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 并合集
 */
public class Code01_UnionFind {


    private static class Node<V> {
        private V value;

        public Node(V value) {
            this.value = value;
        }
    }

    public static class UnionFind<V> {
        private Map<V, Node<V>> nodes;
        private Map<Node<V>, Node<V>> parents;
        private Map<Node<V>, Integer> sizeMap;

        public UnionFind(List<V> values) {
            nodes = new HashMap<>();
            parents = new HashMap<>();
            sizeMap = new HashMap<>();
            for (V value : values) {
                Node<V> vNode = new Node<>(value);
                nodes.put(value, vNode);
                parents.put(vNode, vNode);
                sizeMap.put(vNode, 1);
            }
        }

        public boolean isSameSet(V a, V b) {
            return false;
        }

        private Node<V> findParent(Node<V> node) {
            Stack<Node<V>> stack = new Stack<>();
            while (parents.get(node) != node) {
                stack.push(node);
                node = parents.get(node);
            }
            while (!stack.isEmpty()) {
                parents.put(stack.pop(), node);
            }
            return node;
        }


        public void union(V a, V b) {
            Node<V> aHead = findParent(nodes.get(a));
            Node<V> bHead = findParent(nodes.get(b));
            if (aHead != bHead) {
                int aSize = sizeMap.get(aHead);
                int bSize = sizeMap.get(bHead);
                Node<V> bigHead = aSize > bSize ? aHead : bHead;
                Node<V> smallHead = aHead == bigHead ? bHead : aHead;
                parents.put(smallHead, bigHead);
                sizeMap.put(bigHead, aSize + bSize);
                sizeMap.remove(smallHead);
            }
        }
    }
}
