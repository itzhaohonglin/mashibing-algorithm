package com.howliked.mashibing.algorithm.class13.unionfind;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 并查集：并查集就是将N个不同元素分成一组不想交的集合，开始时，每个元素就是一个集合，然后按规律将两个集合进行合并。
 * 主要用于解决一些元素分组的问题。它管理一系列不相交的集合，并支持两种操作：
 * <p>
 * 合并（Union）：把两个不相交的集合合并为一个集合。
 * 查询（Find）：查询两个元素是否在同一个集合中。
 *  路径压缩：每一个集合可能包括了很多对象，有些对象可能存在一条很长的关系线，这时候把该集合所有对象的父节点转化为该集合的父节点，这就是路径压缩。
 */
public class Code01_UnionFind {
    public static class Node<V> {
        private V value;

        public Node(V value) {
            this.value = value;
        }
    }

    /**
     * 使用HashMap实现
     *
     * @param <V>
     */
    public static class UnionFindHashMap<V> {
        private Map<V, Node<V>> nodes;
        private Map<Node<V>, Node<V>> parent;
        private Map<Node<V>, Integer> sizeMap;

        public UnionFindHashMap(List<V> list) {
            nodes = new HashMap<>();
            parent = new HashMap<>();
            sizeMap = new HashMap<>();

            for (V value : list) {
                Node<V> vNode = new Node<>(value);
                nodes.put(value, vNode);
                parent.put(vNode, vNode);
                sizeMap.put(vNode, 1);
            }
        }

        /**
         * 查找顶级节点(包含路径压缩)
         *
         * @param cur
         * @return
         */
        private Node<V> findTopNode(Node<V> cur) {
            Stack<Node<V>> stack = new Stack<>();
            //如果cur不是当前parent的节点,压入栈中
            while (cur != parent.get(cur)) {
                stack.push(cur);
                //依次去取cur的parent
                cur = parent.get(cur);
            }
            //路径压缩:只要栈不为空,则应该把栈中的数据(也就是从最开始的cur节点依次到顶级节点之前所经过的节点)指向父类节点,可以简化查询的次数
            while (!stack.isEmpty()) {
                parent.put(stack.pop(), cur);
            }

            return cur;
        }

        public boolean isSameSet(V a, V b) {
            return findTopNode(nodes.get(a)) == findTopNode(nodes.get(b));
        }

        public void union(V a, V b) {
            Node<V> aHead = findTopNode(nodes.get(a));
            Node<V> bHead = findTopNode(nodes.get(b));
            /**
             * 当前的两个节点的顶级节点是否相等
             * 1.相等:则不需要做任何处理,已经合并过了
             * 2.不相等,说明需要进行合并
             */
            //两List进行合并
            if (aHead != bHead) {
                //取出两个list的size,小的连接大的
                int aSize = sizeMap.get(aHead);
                int bSize = sizeMap.get(bHead);
                Node<V> bigNode = aSize > bSize ? aHead : bHead;
                Node<V> smallNode = aHead == bigNode ? bHead : aHead;
                //将小的list的父节点，指向大大
                parent.put(smallNode, bigNode);
                //将两个list的list进行合并
                sizeMap.put(bigNode, aSize + bSize);
                //移除小的节点
                sizeMap.remove(smallNode);
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
            help = new int[N];
            sets = N;
            for (int i = 0; i < N; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public boolean find(int i, int j) {
            return findTop(i) == findTop(j);
        }

        private int findTop(int k) {
            int hi = 0;
            while (k != parent[k]) {
                help[hi++] = k;
                k = parent[k];
            }
            //路径压缩
            for (; hi >= 0; hi--) {
                parent[help[hi]] = k;
            }
            return k;
        }

        public void union(int i, int j) {
            int iHead = findTop(i);
            int jHead = findTop(i);
            if (iHead != jHead) {
                int iSize = size[i];
                int jSize = size[j];
                if (iSize > jSize) {
                    size[i] += size[j];
                    parent[j] = i;
                } else {
                    size[j] += size[i];
                    parent[i] = j;
                }
            }
            sets--;
        }

        public int sets() {
            return sets;
        }
    }
}


