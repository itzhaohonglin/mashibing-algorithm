package com.howliked.mashibing.algorithm.class11;

/**
 * 给定一棵二叉树的头节点head，返回这颗二叉树中最大的二叉搜索子树的大小
 * 二叉搜索子树:
 * 1. 与X无关
 * - 1.1 X左树最大搜索子树的大小
 * - 1.2 X右树最大搜索子树的大小
 * 2. 与X有关
 * -2.1 X左树是搜索二叉树
 * -2.2 X右树是搜索二叉树
 * -2.3 左树节点最大值与X的值小
 * -2.4 右树节点最小值比X值大
 */
public class Code05_MaxSubBSTSize {


    private static class NodeInfo {
        private int maxSubBSTSize;
        private int max;
        private int min;
        private int size;

        public NodeInfo(int maxSubBSTSize, int max, int min, int size) {
            this.maxSubBSTSize = maxSubBSTSize;
            this.max = max;
            this.min = min;
            this.size = size;
        }
    }

    private static NodeInfo process(TreeNode node) {
        if (node == null) {
            return null;
        }

        NodeInfo leftInfo = process(node.left);
        NodeInfo rightInfo = process(node.right);
        int max = node.value;
        int min = node.value;
        if (leftInfo != null) {
            min = Math.min(leftInfo.min, min);
            max = Math.max(leftInfo.max, max);
        }
        if (rightInfo != null) {
            min = Math.min(rightInfo.min, min);
            max = Math.max(rightInfo.max, max);
        }

        int size = 0;

        int maxSubBSTSize = 0;
        return new NodeInfo(maxSubBSTSize, max, min, size);
    }
}
