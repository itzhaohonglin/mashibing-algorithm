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
            //1.先构建当前根节点
            TreeNode node = new TreeNode(root.val);
            //2.当前节点的左节点为子节点
            node.left = en(root.children);
            return node;
        }

        /**
         * 将子节点构建为左树的右子节点
         * 1.构建当前节点,如果根节点为空,则构建出来,否则为右节点
         * 2.当前节点下推,变更为当前节点;
         * 3.依次构建
         *
         * @param children
         * @return
         */
        private TreeNode en(List<Node> children) {
            //返回根节点
            TreeNode root = null;
            TreeNode cur = null;    //当前节点
            for (Node child : children) {
                TreeNode tNode = new TreeNode(child.val);
                if (root == null) {
                    root = new TreeNode(tNode.val);
                } else {
                    root.right = tNode;
                }
                cur = tNode;
                cur.left = en(child.children);
            }
            return root;
        }


        // Decodes your binary tree to an n-ary tree.
        public Node decode(TreeNode root) {
            if (root == null) {
                return null;
            }
            return new Node(root.val, de(root.left));
        }

        private List<Node> de(TreeNode root) {
            if (root == null) {
                return null;
            }
            List<Node> result = new ArrayList<>();
            //只要有节点
            while (root != null) {
                //创建当前节点,并添加到子节点中
                Node node = new Node(root.val);
                result.add(node);
                //依次向右查找是否有节点
                root = root.right;
            }
            return result;
        }
    }
}
