package com.howliked.mashibing.algorithm.class11;

/**
 * 判断一个树节点是否为满二叉树
 * 满二叉树定义:如果这个树的2^H -1 = 节点数 那它就是满二叉树
 */
public class Code04_IsFull {

    public static boolean isFull1(TreeNode head) {
        if (head == null) {
            return true;
        }
        int height = h(head);
        int nodes = n(head);
        return (1 << height) - 1 == nodes;
    }

    public static int h(TreeNode head) {
        if (head == null) {
            return 0;
        }
        return Math.max(h(head.left), h(head.right)) + 1;
    }

    public static int n(TreeNode head) {
        if (head == null) {
            return 0;
        }
        return n(head.left) + n(head.right) + 1;
    }


    private static boolean isFull(TreeNode root) {
        if (root == null) {
            return true;
        }
        NodeInfo all = process(root);
        return (1 << all.height) - 1 == all.nodes;
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


    // for test
    public static TreeNode generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    // for test
    public static TreeNode generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        TreeNode head = new TreeNode((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }

    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            TreeNode head = generateRandomBST(maxLevel, maxValue);
            if (isFull1(head) != isFull(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }
}
