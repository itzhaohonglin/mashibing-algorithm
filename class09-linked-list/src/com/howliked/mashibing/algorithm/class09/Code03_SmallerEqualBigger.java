package com.howliked.mashibing.algorithm.class09;

public class Code03_SmallerEqualBigger {
	
	public static ListNode listPartition1(ListNode head, int pivot) {
		if (head == null) {
			return head;
		}
		ListNode cur = head;
		int i = 0;
		while (cur != null) {
			i++;
			cur = cur.next;
		}
		ListNode[] nodeArr = new ListNode[i];
		i = 0;
		cur = head;
		for (i = 0; i != nodeArr.length; i++) {
			nodeArr[i] = cur;
			cur = cur.next;
		}
		arrPartition(nodeArr, pivot);
		for (i = 1; i != nodeArr.length; i++) {
			nodeArr[i - 1].next = nodeArr[i];
		}
		nodeArr[i - 1].next = null;
		return nodeArr[0];
	}

	public static void arrPartition(ListNode[] nodeArr, int pivot) {
		int small = -1;
		int big = nodeArr.length;
		int index = 0;
		while (index != big) {
			if (nodeArr[index].value < pivot) {
				swap(nodeArr, ++small, index++);
			} else if (nodeArr[index].value == pivot) {
				index++;
			} else {
				swap(nodeArr, --big, index);
			}
		}
	}

	public static void swap(ListNode[] nodeArr, int a, int b) {
		ListNode tmp = nodeArr[a];
		nodeArr[a] = nodeArr[b];
		nodeArr[b] = tmp;
	}

	public static ListNode listPartition2(ListNode head, int pivot) {
		ListNode sH = null; // small head
		ListNode sT = null; // small tail
		ListNode eH = null; // equal head
		ListNode eT = null; // equal tail
		ListNode mH = null; // big head
		ListNode mT = null; // big tail
		ListNode next = null; // save next ListNode
		// every ListNode distributed to three lists
		while (head != null) {
			next = head.next;
			head.next = null;
			if (head.value < pivot) {
				if (sH == null) {
					sH = head;
					sT = head;
				} else {
					sT.next = head;
					sT = head;
				}
			} else if (head.value == pivot) {
				if (eH == null) {
					eH = head;
					eT = head;
				} else {
					eT.next = head;
					eT = head;
				}
			} else {
				if (mH == null) {
					mH = head;
					mT = head;
				} else {
					mT.next = head;
					mT = head;
				}
			}
			head = next;
		}
		// 小于区域的尾巴，连等于区域的头，等于区域的尾巴连大于区域的头
		if (sT != null) { // 如果有小于区域
			sT.next = eH;
			eT = eT == null ? sT : eT; // 下一步，谁去连大于区域的头，谁就变成eT
		}
		// 下一步，一定是需要用eT 去接 大于区域的头
		// 有等于区域，eT -> 等于区域的尾结点
		// 无等于区域，eT -> 小于区域的尾结点
		// eT 尽量不为空的尾巴节点
		if (eT != null) { // 如果小于区域和等于区域，不是都没有
			eT.next = mH;
		}
		return sH != null ? sH : (eH != null ? eH : mH);
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
		ListNode head1 = new ListNode(7);
		head1.next = new ListNode(9);
		head1.next.next = new ListNode(1);
		head1.next.next.next = new ListNode(8);
		head1.next.next.next.next = new ListNode(5);
		head1.next.next.next.next.next = new ListNode(2);
		head1.next.next.next.next.next.next = new ListNode(5);
		printLinkedList(head1);
		// head1 = listPartition1(head1, 4);
		head1 = listPartition2(head1, 5);
		printLinkedList(head1);

	}

}
