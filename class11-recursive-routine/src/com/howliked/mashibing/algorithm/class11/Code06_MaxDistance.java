package com.howliked.mashibing.algorithm.class11;

/**
 * 给定一棵二叉树的头节点head，任何两个节点之间都存在距离，返回整棵二叉树的最大距离
 * 解题思路:
 * 1.左树上的最大距离
 * 2.右树上的最大距离
 * 3.X左树上的最远距离 + X右树上的最远距离 +1
 */
public class Code06_MaxDistance {

    public static void main(String[] args) {

    }

    private static class NodeInfo {
        private int maxDistance;
        private int height;

        public NodeInfo(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }

    private static NodeInfo process(TreeNode node) {
        if (node == null) {
            return new NodeInfo(0, 0);
        }
        NodeInfo leftInfo = process(node.left);
        NodeInfo rightINfo = process(node.right);
        int height = Math.max(leftInfo.height, rightINfo.height) + 1;
        int maxDistance = Math.max((leftInfo.height + rightINfo.height) + 1, Math.max(leftInfo.maxDistance, rightINfo.maxDistance));
        return new NodeInfo(maxDistance, height);
    }

}
