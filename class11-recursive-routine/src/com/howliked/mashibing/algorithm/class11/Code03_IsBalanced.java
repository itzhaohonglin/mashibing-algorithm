package com.howliked.mashibing.algorithm.class11;

/**
 * 平衡二叉树:左树和右树的高度差不大于1
 */
public class Code03_IsBalanced {
    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode();
        System.out.println(isBalanced(root));
    }


    private static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return process(root).isBalanced;
    }

    private static class NodeInfo {
        private boolean isBalanced;
        private int height;

        public NodeInfo(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    private static NodeInfo process(TreeNode node) {
        if (node == null) {
            return new NodeInfo(true, 0);
        }
        NodeInfo leftInfo = process(node.left);
        NodeInfo rightInfo = process(node.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isBalanced = true;
        if (!leftInfo.isBalanced || !rightInfo.isBalanced) {
            isBalanced = false;
        } else if (Math.abs(leftInfo.height - rightInfo.height) > 1) {
            isBalanced = false;
        }
        return new NodeInfo(isBalanced, height);
    }


    private static TreeNode getNode1() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        return root;
    }

}
