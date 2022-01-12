package com.howliked.mashibing.algorithm.class27.morris;

import java.util.ArrayList;
import java.util.List;

/**
 * morris遍历：一种遍历二叉树的方式，并且时间复杂度O(N)，额外空间复杂度O(1)，通过利用原树中大量空闲指针的方式，达到节省空间的目的
 * 细节:
 * 假设来到当前节点cur，开始时cur来到头节点位置
 * 1. 如果cur没有左孩子，cur向右移动(cur = cur.right)
 * 2. 如果cur有左孩子，找到左子树上最右的节点mostRight
 * - 如果mostRight的右指针指向空，让其指向cur，然后cur向左移动(cur=cur.left)
 * - 如果mostRight的右指针指向cur，让其指向null，然后cur向右移动(cur=cur.right)
 * 3.cur为空时遍历停止
 */
public class Code01_Morris {

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode();
        System.out.println(morris(root));
    }

    public static List<Integer> morris(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    result.add(cur.value);
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            result.add(cur.value);
            cur = cur.right;
        }
        return result;
    }

}
