package com.howliked.mashibing.algorithm.class10;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归方式遍历二叉树的前、中、后序
 */
public class Code02_RecursiveTraversalBT {

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode();
        pre(root);
        System.out.println("二叉树的前序遍历:" + preNodeList);
        in(root);
        System.out.println("二叉树的中序遍历:" + inNodeList);
        post(root);
        System.out.println("二叉树的后序遍历:" + postNodeList);
    }

    private static List<Integer> preNodeList = new ArrayList<>();
    private static List<Integer> inNodeList = new ArrayList<>();
    private static List<Integer> postNodeList = new ArrayList<>();

    private static void pre(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        preNodeList.add(treeNode.value);
        pre(treeNode.left);
        pre(treeNode.right);
    }

    private static void in(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        in(treeNode.left);
        inNodeList.add(treeNode.value);
        in(treeNode.right);
    }

    private static void post(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        post(treeNode.left);
        post(treeNode.right);
        postNodeList.add(treeNode.value);
    }

}
