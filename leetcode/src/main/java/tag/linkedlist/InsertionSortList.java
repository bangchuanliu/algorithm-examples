package tag.linkedlist;

import common.ListNode;

public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode p1 = head;
		ListNode p2 = p1.next;
		while (p2 != null) {
			ListNode p3 = p2.next;
			ListNode p = head;
			if (p2.val < p.val) {
				p2.next = p;
				p1.next = p3;
				head = p2;
				p2 = p3;
			} else if (p2.val >= p1.val) {
				p1 = p2;
				p2 = p3;
			} else {
				while (p2.val > p.next.val) {
					p = p.next;
				}
				p2.next = p.next;
				p.next = p2;
				p1.next = p3;
				p2 = p3;
			}
		}
		return head;
	}

	public ListNode insertionSortList2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode helperNode = new ListNode(-1);
		helperNode.next = head;
		ListNode p2 = helperNode.next;

		while (p2.next != null) {
			ListNode p1 = helperNode;
			while (p1 != p2 && p2.next.val >= p1.next.val) {
				p1 = p1.next;
			}

			if (p1 != p2) {
				ListNode temp = p2.next;
				p2.next = p2.next.next;
				temp.next = p1.next;
				p1.next = temp;
			} else {
				p2 = p2.next;
			}
		}
		return helperNode.next;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(1);
		// ListNode n3 = new ListNode(2);
		n1.next = n2;
		// n2.next = n3;
		// n3.next = n4;
		// n4.next = n5;
		ListNode head = new InsertionSortList().insertionSortList(n1);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
}
