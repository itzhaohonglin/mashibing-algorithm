package com.howliked.mashibing.algorithm.class10;

import java.util.ArrayList;
import java.util.List;

/**
 * vip题目:https://leetcode.com/problems/encode-n-ary-tree-to-binary-tree
 * 解题思路:
 * 将多叉树序列化为二叉树,并能将二叉树反序列化成多叉树
 * encode():将多叉树序列化为二叉树。二叉树结构: 当前树的左节点为第一个子节点,其余子节点均为子节点的右子节点
 */
public class Code06_EncodeNaryTreeToBinaryTree {
    // 提交时不要提交这个类
    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

    // 提交时不要提交这个类
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    // 只提交这个类即可
    static class Codec {

        // Encodes an n-ary tree to a binary tree.
        public TreeNode encode(Node root) {
            if (root == null) {
                return null;
            }
            TreeNode node = new TreeNode(root.val);
            node.left = en(root.children);
            return node;
        }

        private TreeNode en(List<Node> children) {
            TreeNode root = null;
            TreeNode cur = null;
            for (Node child : children) {
                TreeNode node = new TreeNode(child.val);
                if (root == null) {
                    root = new TreeNode(node.val);
                } else {
                    cur.right = node;
                }
                cur = node;
                cur.left = en(child.children);
            }
            return null;
        }

        // Decodes your binary tree to an n-ary tree.
        public Node decode(TreeNode root) {
            if (root == null) {
                return null;
            }
            return new Node(root.val, de(root.left));
        }

        private List<Node> de(TreeNode root) {
            List<Node> children = new ArrayList<>();
            while (root != null) {
                Node node = new Node(root.val, de(root.left));
                children.add(node);
                root = root.right;
            }
            return children;
        }


    }
}
