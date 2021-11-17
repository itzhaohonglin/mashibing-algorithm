package com.howliked.mashibing.algorithm.class11;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 是否是完全二叉树
 * 叶子结点只能出现在最下层和次下层，且最下层的叶子结点集中在树的左部。需要注意的是，满二叉树肯定是完全二叉树，而完全二叉树不一定是满二叉树
 */
public class Code01_IsCBT {


    public static boolean isCBT1(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode cur = root;
        boolean leaf = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode l = node.left;
            TreeNode r = node.right;
            //1.如果已经遇到过叶子节点,当前节点的左右或者右树还有节点,肯定不是完全二叉树
            if ((leaf && (l != null || r != null))
                    //2.只有右节点,肯定不是完全二叉树
                    || (l == null && r != null)) {
                return false;
            }
            if (l != null) {
                queue.offer(l);
            }

            if (r != null) {
                queue.offer(r);
            }
            //叶子节点
            if (l == null || r == null) {
                leaf = true;
            }
        }
        return true;
    }
}
