package leetcode.linkedlist;

import common.ListNode;

public class SortList {
	public ListNode sortList(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode slow = head.next;
		ListNode fast = head.next.next;
		ListNode second = null;
		
		if (fast == null) {
			second = slow;
			head.next = null;
		} else {
			while (fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
			second = slow.next;
			slow.next = null;
		}

		ListNode left = sortList(head);
		ListNode right = sortList(second);

		return mergeTwoLists(left, right);
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}
		if (l1 != null && l2 == null) {
			return l1;
		}
		if (l1 == null && l2 != null) {
			return l2;
		}
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode l3 = new ListNode(0);// helper node
		ListNode p = l3;
		while (p1 != null && p2 != null) {
			if (p1.val < p2.val) {
				p.next = p1;
				p = p1;
				p1 = p1.next;
			} else {
				p.next = p2;
				p = p2;
				p2 = p2.next;
			}
		}
		if (p1 != null) {
			p.next = p1;
		}
		if (p2 != null) {
			p.next = p2;
		}
		return l3.next;
	}
}
