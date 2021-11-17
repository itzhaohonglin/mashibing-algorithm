package com.howliked.mashibing.algorithm.class11;

/**
 * 给定一棵二叉树的头节点head，任何两个节点之间都存在距离，返回整棵二叉树的最大距离
 * 解题思路:
 * 1.左树上的最大距离
 * 2.右树上的最大距离
 * 3.X左树上的最远距离 + X右树上的最远距离 +1
 */
public class Code06_MaxDistance {

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
            new NodeInfo(0, 0);
        }
        NodeInfo leftInfo = process(node.left);
        NodeInfo rightInfo = process(node.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int p1 = leftInfo.maxDistance;
        int p2 = rightInfo.maxDistance;
        int p3 = leftInfo.height + rightInfo.height + 1;
        int maxDistance = Math.max(p1, Math.max(p2, p3));
        return new NodeInfo(maxDistance, height);
    }

}
