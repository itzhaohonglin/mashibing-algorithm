package com.howliked.mashibing.algorithm.class11;

/**
 * 是否是二叉搜索树
 */
public class Code02_IsBST {

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode();
        System.out.println(isBST2(root));
        TreeNode node1 = getNode1();
        System.out.println(isBST2(node1));
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

    private static boolean isBST2(TreeNode root) {
        if (root == null) {
            return false;
        }
        return process2(root).isBST;
    }

    private static class NodeInfo {
        private boolean isBST;
        private int min;
        private int max;

        public NodeInfo(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }

    private static NodeInfo process2(TreeNode node) {
        if (node == null) {
            return null;
        }
        NodeInfo leftInfo = process2(node.left);
        NodeInfo rightInfo = process2(node.right);
        int min = node.value;
        int max = node.value;
        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
        }
        if (rightInfo != null) {
            max = Math.max(max, rightInfo.max);
            min = Math.min(min, rightInfo.min);
        }
        boolean isBST = true;
        if (leftInfo != null && (!leftInfo.isBST || leftInfo.max >= node.value)) {
            isBST = false;
        }
        if (rightInfo != null && (!rightInfo.isBST || rightInfo.min <= node.value)) {
            isBST = false;
        }
        return new NodeInfo(isBST, min, max);
    }


}
