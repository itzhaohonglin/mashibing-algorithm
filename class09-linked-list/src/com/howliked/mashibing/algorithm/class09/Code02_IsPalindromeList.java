package com.howliked.mashibing.algorithm.class09;

import java.util.Stack;

public class Code02_IsPalindromeList {


    // need n extra space
    public static boolean isPalindrome1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        ListNode temp = head;
        while (!stack.isEmpty()) {
            if (temp.value != stack.pop().value) {
                return false;
            }
            temp = temp.next;
        }
        return true;
    }

    // need n/2 extra space
    public static boolean isPalindrome2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //slow is mid node
        Stack<ListNode> stack = new Stack<>();
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }
        ListNode cur = head;
        while (!stack.isEmpty()) {
            if (cur.value != stack.pop().value) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    // need O(1) extra space
    public static boolean isPalindrome3(ListNode head) {
        ListNode midNode = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            midNode = midNode.next;
            fast = fast.next.next;
        }
        //slow is mid node
        ListNode next = midNode.next;  //mide node's first node
        //链表反转
        ListNode pre = null;
        while (next != null) {
            ListNode temp = next.next;
            next.next = pre;
            pre = next;
            next = temp;
        }
        next = head;
        while (pre != null) {
            if (pre.value != next.value) {
                return false;
            }
            next = next.next;
            pre = pre.next;
        }
        return true;
    }

    public static void printLinkedList(ListNode ListNode) {
        System.out.print("Linked List: ");
        while (ListNode != null) {
            System.out.print(ListNode.value + " ");
            ListNode = ListNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(1);

        System.out.println("isPalindrome1:" + isPalindrome1(head));
        System.out.println("isPalindrome2:" + isPalindrome2(head));
        System.out.println("isPalindrome3:" + isPalindrome3(head));
    }
}
