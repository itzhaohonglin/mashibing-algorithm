package com.howliked.mashibing.algorithm.class13.unionfind;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * 并查集：并查集就是将N个不同元素分成一组不想交的集合，开始时，每个元素就是一个集合，然后按规律将两个集合进行合并。
 * 主要用于解决一些元素分组的问题。它管理一系列不相交的集合，并支持两种操作：
 * <p>
 * 合并（Union）：把两个不相交的集合合并为一个集合。
 * 查询（Find）：查询两个元素是否在同一个集合中。
 * 路径压缩：每一个集合可能包括了很多对象，有些对象可能存在一条很长的关系线，这时候把该集合所有对象的父节点转化为该集合的父节点，这就是路径压缩。
 */
public class Code01_UnionFind {


    private static class Node<V> {
        private V value;

        public Node(V value) {
            this.value = value;
        }
    }

    public static class UnionFindHashMap<V> {
        private HashMap<V, Node<V>> nodes;
        private HashMap<Node<V>, Node<V>> parents;
        private HashMap<Node<V>, Integer> sizeMap;

        public UnionFindHashMap(List<V> values) {
            nodes = new HashMap<>();
            parents = new HashMap<>();
            sizeMap = new HashMap<>();

            for (V value : values) {
                Node<V> node = new Node<>(value);
                nodes.put(value, node);
                parents.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        public boolean isSameSet(V a, V b) {
            return findParent(nodes.get(a)) == findParent(nodes.get(b));
        }

        private Node<V> findParent(Node<V> node) {
            Stack<Node<V>> stack = new Stack<>();
            while (node != parents.get(node)) {
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
                //小的连接大的
                int aSize = sizeMap.get(aHead);
                int bSize = sizeMap.get(bHead);
                Node<V> bigHead = aSize > bSize ? aHead : bHead;
                Node<V> smallHead = bigHead == aHead ? bHead : aHead;
                parents.put(smallHead, bigHead);
                sizeMap.put(bigHead, aSize + bSize);
                sizeMap.remove(smallHead);
            }
        }
    }

    public static class UnionFindArray {
        private int[] parent;
        private int[] size;
        private int[] help;
        private int sets;

        public UnionFindArray(int N) {
            parent = new int[N];
            size = new int[N];
            sets = 0;
            for (int i = 0; i < N; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public boolean isSameSet(int a, int b) {
            return findParent(a) == findParent(b);
        }

        private int findParent(int val) {
            int hi = 0;
            while (val != parent[val]) {
                help[hi++] = val;
                val = parent[val];
            }
            for (hi--; hi > 0; hi--) {
                parent[help[hi]] = val;
            }
            return val;
        }

        public void union(int a, int b) {
            int aHead = findParent(a);
            int bHead = findParent(b);

            if (aHead != bHead) {
                int aSize = size[a];
                int bSize = size[b];
                int bigHead = aSize > bSize ? aHead : bHead;
                int smallHead = aHead == bigHead ? bHead : aHead;
                parent[smallHead] = bigHead;
                size[bigHead] = aSize + bSize;
                sets--;
            }
        }

        public int sets() {
            return sets;
        }
    }

}


