package tag.linkedlist;

import common.ListNode;

/**
 * Reverse a singly linked list.
 * 
 * @author bliu13 Jan 12, 2016
 */
public class ReverseLinkedList {
	public ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode p1 = head;
		ListNode p2 = p1.next;
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
}
