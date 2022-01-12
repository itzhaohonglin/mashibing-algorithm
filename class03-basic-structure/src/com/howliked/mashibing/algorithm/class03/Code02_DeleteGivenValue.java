package com.howliked.mashibing.algorithm.class03;

/**
 * 删除链表中指定的值
 */
public class Code02_DeleteGivenValue {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println(removeValue(head, 1));
    }

    // head = removeValue(head, 2);
    public static ListNode removeValue(ListNode head, int num) {
        if (head == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode cur = dummyNode;
        while (cur.next != null) {
            if (cur.next.value == num) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }

}
