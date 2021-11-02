package com.howliked.mashibing.algorithm.class10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层级遍历二叉树
 */
public class Code04_LevelTraversalBT {

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode();
        System.out.println(level(root));
    }

    public static List<Integer> level(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.value);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return result;
    }
}
