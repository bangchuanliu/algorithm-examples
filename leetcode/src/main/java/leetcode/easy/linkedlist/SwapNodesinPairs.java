package leetcode.easy.linkedlist;

import common.ListNode;

public class SwapNodesinPairs {

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode pre = null;
		ListNode newHead = head.next;
		ListNode cur = head;

		while (cur != null && cur.next != null) {
			ListNode next = cur.next;
			cur.next = next.next;
			next.next = cur;
			if (pre != null) {
				pre.next = next;
			}
			pre = cur;
			cur = cur.next;
		}

		return newHead;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;

		SwapNodesinPairs instance = new SwapNodesinPairs();

		ListNode newHead = instance.swapPairs(n1);

		while (newHead != null) {
			System.out.print(newHead.val + " ");
			newHead = newHead.next;
		}

	}
}
