package com.howliked.mashibing.algorithm.class08;

/**
 * 前缀树:
 * pass 通过次数
 * end 结束次数
 */
public class Code01_TrieTree {
    public static void main(String[] args) {
        TrieTree trieTree = new TrieTree();
        trieTree.insert("abc");
        trieTree.insert("abcd");
        trieTree.insert("abde");
        trieTree.insert("bcd");
        System.out.println(trieTree.prefixNumber("ab"));
    }

    private static class Node {
        private int pass;
        private int end;
        private Node[] next;

        public Node() {
            this.pass = 0;
            this.end = 0;
            this.next = new Node[26];
        }
    }

    private static class TrieTree {
        private Node root;

        public TrieTree() {
            root = new Node();
        }

        public void insert(String word) {
            if (word == null || "".equals(word)) {
                return;
            }
            char[] chars = word.toCharArray();
            Node node = root;
            node.pass++;
            for (int i = 0; i < chars.length; i++) {
                int path = chars[i] - 'a';
                if (node.next[path] == null) {
                    node.next[path] = new Node();
                }
                node = node.next[path];
                node.pass++;
            }
            node.end++;
        }

        public void delete(String word) {
            if (search(word) != 0) {
                char[] chars = word.toCharArray();
                Node node = root;
                node.pass--;
                for (int i = 0; i < chars.length; i++) {
                    int path = chars[i] - 'a';
                    if (--node.next[path].pass == 0) {
                        node.next[path] = null;
                    }
                    node = node.next[path];
                }
                node.end--;
            }
        }

        public int search(String word) {
            if (word == null || "".equals(word)) {
                return 0;
            }
            char[] chars = word.toCharArray();
            Node node = root;
            for (int i = 0; i < chars.length; i++) {
                int path = chars[i] - 'a';
                if (node.next[path] == null) {
                    return 0;
                }
                node = node.next[path];
            }
            return node.end;
        }

        public int prefixNumber(String word) {
            if (word == null || "".equals(word)) {
                return 0;
            }
            char[] chars = word.toCharArray();
            Node node = root;
            for (int i = 0; i < chars.length; i++) {
                int path = chars[i] - 'a';
                if (node.next[path] == null) {
                    return 0;
                }
                node = node.next[path];
            }
            return node.pass;
        }
    }
}
