package com.howliked.mashibing.algorithm.class11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定两个二叉树节点,找到它们的最低公共祖先
 * 与x有关
 * x是否是a
 * x是否是b
 * 与x无关
 * * 是否找到A
 * * 是否找到B
 */
public class Code08_LowestAncestor {


    private static TreeNode lowestAncestor(TreeNode root, TreeNode aNode, TreeNode bNode) {
        if (root == null) {
            return null;
        }
        return process(root, aNode, bNode).ans;
    }

    private static class NodeInfo {
        private boolean findA;
        private boolean findB;
        private TreeNode ans;

        public NodeInfo(boolean findA, boolean findB, TreeNode ans) {
            this.findA = findA;
            this.findB = findB;
            this.ans = ans;
        }
    }

    private static NodeInfo process(TreeNode node, TreeNode aNode, TreeNode bNode) {
        if (node == null) {
            return new NodeInfo(false, false, null);
        }
        NodeInfo leftInfo = process(node.left, aNode, bNode);
        NodeInfo rightInfo = process(node.right, aNode, bNode);

        boolean findA = (node == aNode) || leftInfo.findA || rightInfo.findA;
        boolean findB = (node == bNode) || leftInfo.findB || rightInfo.findB;

        TreeNode ans = null;
        if (leftInfo.ans != null) {
            ans = leftInfo.ans;
        } else if (rightInfo.ans != null) {
            ans = rightInfo.ans;
        } else {
            if (findA && findB) {
                ans = node;
            }
        }

        return new NodeInfo(findA, findB, ans);
    }


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

    // for test
    public static TreeNode pickRandomOne(TreeNode head) {
        if (head == null) {
            return null;
        }
        ArrayList<TreeNode> arr = new ArrayList<>();
        fillPrelist(head, arr);
        int randomIndex = (int) (Math.random() * arr.size());
        return arr.get(randomIndex);
    }

    // for test
    public static void fillPrelist(TreeNode head, ArrayList<TreeNode> arr) {
        if (head == null) {
            return;
        }
        arr.add(head);
        fillPrelist(head.left, arr);
        fillPrelist(head.right, arr);
    }

    public static void main(String[] args) {
        int maxLevel = 4;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            TreeNode head = generateRandomBST(maxLevel, maxValue);
            TreeNode o1 = pickRandomOne(head);
            TreeNode o2 = pickRandomOne(head);
            if (lowestAncestor1(head, o1, o2) != lowestAncestor(head, o1, o2)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }

}
