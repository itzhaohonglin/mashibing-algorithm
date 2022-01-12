package com.howliked.mashibing.algorithm.class03;

/**
 * 反转链表
 */
public class Code01_ReverseList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println(reverseLinkedList(head));
    }

    //  head
    //   a    ->   b    ->  c  ->  null
    //   c    ->   b    ->  a  ->  null
    public static ListNode reverseLinkedList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            //记录当前节点的下一个节点
            ListNode temp = cur.next;
            //当前节点的下一个节点为pre;
            cur.next = pre;
            //pre节点为当前节点,就完成了反转
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static DoubleNode reverseDoubleList(DoubleNode head) {
        return null;
    }
}