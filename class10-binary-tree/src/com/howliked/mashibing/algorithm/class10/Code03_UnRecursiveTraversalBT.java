package com.howliked.mashibing.algorithm.class10;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 非递归方式-二叉树的前、中、后序遍历
 */
public class Code03_UnRecursiveTraversalBT {

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode();
        System.out.println("二叉树的前序遍历:" + preOrder(root));
        System.out.println("二叉树的中序遍历:" + inOrder(root));
        System.out.println("二叉树的后序遍历:" + postOrder(root));
    }


    private static List<Integer> preOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.value);
            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    private static List<Integer> inOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                result.add(root.value);
                root = root.right;
            }
        }
        return result;
    }

    private static List<Integer> postOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }

        while (!stack2.isEmpty()) {
            result.add(stack2.pop().value);
        }
        return result;
    }


}
