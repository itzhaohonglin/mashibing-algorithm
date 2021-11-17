package com.howliked.mashibing.algorithm.class11;

/**
 * 判断一个树节点是否为满二叉树
 * 满二叉树定义:如果这个树的2^H -1 = 节点数 那它就是满二叉树
 */
public class Code04_IsFull {

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode();
        System.out.println(isFull(root));
    }


    private static boolean isFull(TreeNode root) {
        if (root == null) {
            return true;
        }
        NodeInfo nodeInfo = process(root);
        return (1 << nodeInfo.height) - 1 == nodeInfo.nodes;
    }

    private static class NodeInfo {
        private int height;
        private int nodes;

        public NodeInfo(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }

    private static NodeInfo process(TreeNode node) {
        if (node == null) {
            return new NodeInfo(0, 0);
        }
        NodeInfo leftInfo = process(node.left);
        NodeInfo rightInfo = process(node.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int nodes = leftInfo.nodes + rightInfo.nodes + 1;
        return new NodeInfo(height, nodes);
    }

}
