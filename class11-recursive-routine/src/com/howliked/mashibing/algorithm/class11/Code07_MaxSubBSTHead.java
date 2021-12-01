package com.howliked.mashibing.algorithm.class11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定一棵二叉树的头节点head，返回这颗二叉树中最大的二叉搜索子树的头节点
 */
public class Code07_MaxSubBSTHead {

    public static TreeNode lowestAncestor1(TreeNode head, TreeNode o1, TreeNode o2) {
        if (head == null) {
            return null;
        }
        // key的父节点是value
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        parentMap.put(head, null);
        fillParentMap(head, parentMap);
        HashSet<TreeNode> o1Set = new HashSet<>();
        TreeNode cur = o1;
        o1Set.add(cur);
        while (parentMap.get(cur) != null) {
            cur = parentMap.get(cur);
            o1Set.add(cur);
        }
        cur = o2;
        while (!o1Set.contains(cur)) {
            cur = parentMap.get(cur);
        }
        return cur;
    }

    public static void fillParentMap(TreeNode head, HashMap<TreeNode, TreeNode> parentMap) {
        if (head.left != null) {
            parentMap.put(head.left, head);
            fillParentMap(head.left, parentMap);
        }
        if (head.right != null) {
            parentMap.put(head.right, head);
            fillParentMap(head.right, parentMap);
        }
    }


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

    public static TreeNode maxSubBSTHead1(TreeNode head) {
        if (head == null) {
            return null;
        }
        if (getBSTSize(head) != 0) {
            return head;
        }
        TreeNode leftAns = maxSubBSTHead1(head.left);
        TreeNode rightAns = maxSubBSTHead1(head.right);
        return getBSTSize(leftAns) >= getBSTSize(rightAns) ? leftAns : rightAns;
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
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            TreeNode head = generateRandomBST(maxLevel, maxValue);
            if (maxSubBSTHead1(head) != maxSubBSTHead(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }

    private static class NodeInfo {
        private int maxSubBSTSize;
        private TreeNode maxSubBSTHead;
        private int max;
        private int min;

        public NodeInfo(int maxSubBSTSize, TreeNode maxSubBSTHead, int max, int min) {
            this.maxSubBSTSize = maxSubBSTSize;
            this.maxSubBSTHead = maxSubBSTHead;
            this.max = max;
            this.min = min;
        }
    }

    private static TreeNode maxSubBSTHead(TreeNode root) {
        if (root == null) {
            return null;
        }
        return process(root).maxSubBSTHead;
    }

    private static NodeInfo process(TreeNode node) {
        if (node == null) {
            return null;
        }
        NodeInfo leftInfo = process(node.left);
        NodeInfo rightInfo = process(node.right);

        int max = node.value;
        int min = node.value;
        int maxSubBSTSize = 0;
        TreeNode maxSubBSTHead = null;
        if (leftInfo != null) {
            max = Math.max(max, leftInfo.max);
            min = Math.min(min, leftInfo.min);
            maxSubBSTHead = leftInfo.maxSubBSTHead;
            maxSubBSTSize = Math.max(maxSubBSTSize, leftInfo.maxSubBSTSize);
        }

        if (rightInfo != null) {
            max = Math.max(max, rightInfo.max);
            min = Math.min(min, rightInfo.min);
            if (rightInfo.maxSubBSTSize > maxSubBSTSize) {
                maxSubBSTSize = rightInfo.maxSubBSTSize;
                maxSubBSTHead = rightInfo.maxSubBSTHead;
            }
        }

        if ((leftInfo == null ? true : (leftInfo.maxSubBSTHead == node.left && leftInfo.max < node.value)) && (rightInfo == null ? true : (rightInfo.maxSubBSTHead == node.right && rightInfo.min > node.value))) {
            maxSubBSTHead = node;
            maxSubBSTSize = (leftInfo == null ? 0 : leftInfo.maxSubBSTSize) + (rightInfo == null ? 0 : rightInfo.maxSubBSTSize) + 1;
        }

        return new NodeInfo(maxSubBSTSize, maxSubBSTHead, max, min);
    }

}
