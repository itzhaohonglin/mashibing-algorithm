package com.howliked.mashibing.algorithm.class10;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 树的最大宽度
 */
public class Code07_TreeMaxWidth {
    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode();
        System.out.println("当前树的最大宽度为:" + maxWidth(root));
    }

    public static int maxWidth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode curNode = root;    //指向当前节点
        TreeNode nextNode = null;   //指向下一层的最右节点,主要用于记录是否是最后一个节点
        int max = 0;    //返回的最大值
        int countNodes = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
                nextNode = node.left;
            }

            if (node.right != null) {
                queue.add(node.right);
                nextNode = node.right;
            }
            countNodes++;
            //已经是当前节点是该层的最后一个节点
            if (node == curNode) {
                max = Math.max(countNodes, max);//取最大节点
                countNodes = 0;
                curNode = nextNode;
            }
        }
        return max;
    }
}
