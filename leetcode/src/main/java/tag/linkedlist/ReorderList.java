package tag.linkedlist;

import common.ListNode;

public class ReorderList {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		ListNode p = head;
		int len = 0;
		while (p != null) {
			len++;
			p = p.next;
		}
		int i = 0;
		p = head;
		while (i < len / 2) {
			p = p.next;
			i++;
		}
		ListNode pp = p.next;
		p.next = null;
		ListNode p2 = reverList(pp);
		ListNode p1 = head;
		while (p1 != null && p2 != null) {
			ListNode p3 = p1.next;
			ListNode p4 = p2.next;
			p2.next = p1.next;
			p1.next = p2;
			p1 = p3;
			p2 = p4;
		}
	}

	private ListNode reverList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode p1 = head;
		ListNode p2 = head.next;
		while (p2 != null) {
			ListNode p3 = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = p3;
		}
		head.next = null;
		head = p1;
		return head;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		ReorderList instance = new ReorderList();
		instance.reorderList(n1);
//		ListNode n = instance.reverList(n1);
		ListNode p = n1;
		while (p != null) {
			System.out.print(p.val + " ");
			p = p.next;
		}
	}
}
