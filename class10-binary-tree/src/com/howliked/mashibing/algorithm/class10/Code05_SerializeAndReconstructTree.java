package com.howliked.mashibing.algorithm.class10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 * 二叉树的序列化与反序列化
 */
public class Code05_SerializeAndReconstructTree {
    /*
     * 二叉树可以通过先序、后序或者按层遍历的方式序列化和反序列化，
     * 以下代码全部实现了。
     * 但是，二叉树无法通过中序遍历的方式实现序列化和反序列化
     * 因为不同的两棵树，可能得到同样的中序序列，即便补了空位置也可能一样。
     * 比如如下两棵树
     *         __2
     *        /
     *       1
     *       和
     *       1__
     *          \
     *           2
     * 补足空位置的中序遍历结果都是{ null, 1, null, 2, null}
     *
     * */

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode();
        String serialize = serialize(root);
        System.out.println(serialize);
        System.out.println(deserialize(serialize));
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuffer buffer = new StringBuffer();
        List<String> result = new ArrayList<>();
        preSerialize(root, result);
        return buffer.toString();
    }

    private static void preSerialize(TreeNode root, List<String> result) {
        if (root == null) {
            result.add("#");
            return;
        }
        result.add(String.valueOf(root.value));
        preSerialize(root.left, result);
        preSerialize(root.right, result);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null || "".equals(data)) {
            return null;
        }
        Queue<String> queue = new LinkedList<>();
        char[] chars = data.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            queue.offer(String.valueOf(chars[i]));
        }
        return preDeserialize(queue);
    }

    private static TreeNode preDeserialize(Queue<String> data) {
        String value = data.poll();
        if (value == null || "#".equals(value)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(value));
        root.left = preDeserialize(data);
        root.right = preDeserialize(data);
        return root;
    }


    public static Queue<String> levelSerial(TreeNode root) {
        Queue<String> res = new LinkedList<>();
        if (root == null) {
            res.offer(null);
        } else {
            //先将head 添加至res中;
            res.add(String.valueOf(root.value));

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    res.add(String.valueOf(node.left.value));
                    queue.offer(node.left);
                } else {
                    res.offer("#");
                }

                if (node.right != null) {
                    res.add(String.valueOf(node.right.value));
                    queue.offer(node.right);
                } else {
                    res.offer("#");
                }
            }
        }
        return res;
    }

}
