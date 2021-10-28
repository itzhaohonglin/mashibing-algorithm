package com.howliked.mashibing.algorithm.class09;

/**
 * 1.奇数长度返回中点，偶数长度返回上中点
 * 2.奇数长度返回中点，偶数长度返回下中点
 * 3.奇数长度返回中点前一个，偶数长度返回上中点前一个
 * 4.奇数长度返回中点前一个，偶数长度返回下中点前一个
 */
public class Code01_LinkedListMid {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next.next = new ListNode(8);
        System.out.println("奇数长度返回中点，偶数长度返回上中点:" + midOrUpMidNode(head));
        System.out.println("奇数长度返回中点，偶数长度返回下中点:" + midOrDownMidNode(head));
        System.out.println("奇数长度返回中点前一个，偶数长度返回上中点前一个:" + midOrUpMidPreNode(head));
        System.out.println("奇数长度返回中点前一个，偶数长度返回下中点前一个:" + midOrDownMidPreNode(head));
    }

    /**
     * 奇数长度返回中点，偶数长度返回上中点
     *
     * @param head
     * @return
     */
    public static ListNode midOrUpMidNode(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 奇数长度返回中点，偶数长度返回下中点
     *
     * @param head
     * @return
     */
    public static ListNode midOrDownMidNode(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 奇数长度返回中点前一个，偶数长度返回上中点前一个
     *
     * @param head
     * @return
     */
    public static ListNode midOrUpMidPreNode(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 奇数长度返回中点前一个，偶数长度返回下中点前一个
     *
     * @param head
     * @return
     */
    public static ListNode midOrDownMidPreNode(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
