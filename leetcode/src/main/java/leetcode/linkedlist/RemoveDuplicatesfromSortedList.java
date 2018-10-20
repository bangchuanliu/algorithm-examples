package leetcode.linkedlist;

import common.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * For example,
 * 
 * Given 1->1->2, return 1->2.
 * 
 * Given 1->1->2->3->3, return 1->2->3.
 * 
 * @author BangChuan Liu <liubangchuan1100@gmail.com>
 *
 * @date Oct 30, 2014
 */
public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}
		ListNode p1 = head;
		while (p1.next != null) {
			if (p1.next.val == p1.val) {
				p1.next = p1.next.next;
			} else {
				p1 = p1.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		// Given {1,1,1,1,1} -> {1}
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);
		n1.next = n2;
		n2.next = n3;
		// n3.next = n4;
		// n4.next = n5;
		ListNode head = new RemoveDuplicatesfromSortedList().deleteDuplicates(n1);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
}
