package com.howliked.mashibing.algorithm.class11;

import java.util.ArrayList;

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


    public static int getBSTSize(TreeNode head) {
        if (head == null) {
            return 0;
        }
        ArrayList<TreeNode> arr = new ArrayList<>();
        in(head, arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).value <= arr.get(i - 1).value) {
                return 0;
            }
        }
        return arr.size();
    }

    public static void in(TreeNode head, ArrayList<TreeNode> arr) {
        if (head == null) {
            return;
        }
        in(head.left, arr);
        arr.add(head);
        in(head.right, arr);
    }

    public static int maxSubBSTSize1(TreeNode head) {
        if (head == null) {
            return 0;
        }
        int h = getBSTSize(head);
        if (h != 0) {
            return h;
        }
        return Math.max(maxSubBSTSize1(head.left), maxSubBSTSize1(head.right));
    }

    private static int maxSubTreeSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return process(root).maxSubTreeSize;
    }

    private static class NodeInfo {
        private boolean isBST;
        private int maxSubTreeSize;
        private int max;
        private int min;

        public NodeInfo(boolean isBST, int maxSubTreeSize, int max, int min) {
            this.isBST = isBST;
            this.maxSubTreeSize = maxSubTreeSize;
            this.max = max;
            this.min = min;
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
        int maxSubTreeSize = 0;

        if (leftInfo != null) {
            max = Math.max(max, leftInfo.max);
            min = Math.min(min, leftInfo.min);
            maxSubTreeSize = Math.max(maxSubTreeSize, leftInfo.maxSubTreeSize);
        }

        if (rightInfo != null) {
            max = Math.max(max, rightInfo.max);
            min = Math.min(min, rightInfo.min);
            maxSubTreeSize = Math.max(maxSubTreeSize, rightInfo.maxSubTreeSize);
        }

        boolean isBST = false;

        if ((leftInfo == null ? true : leftInfo.isBST && leftInfo.max < node.value)
                && (rightInfo == null ? true : rightInfo.isBST && rightInfo.min > node.value)) {
            maxSubTreeSize = (leftInfo == null ? 0 : leftInfo.maxSubTreeSize) + (rightInfo == null ? 0 : rightInfo.maxSubTreeSize) + 1;
            isBST = true;
        }

        return new NodeInfo(isBST, maxSubTreeSize, max, min);
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
        int maxLevel = 4;
        int maxValue = 100;
        int testTimes = 100;
        for (int i = 0; i < testTimes; i++) {
            TreeNode head = generateRandomBST(maxLevel, maxValue);
            if (maxSubBSTSize1(head) != maxSubTreeSize(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }

}
