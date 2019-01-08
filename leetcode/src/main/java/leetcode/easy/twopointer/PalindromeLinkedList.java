package leetcode.easy.twopointer;

import common.ListNode;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Follow up: Could you do it in O(n) time and O(1) space?
 * 
 * @author bliu13 Jan 13, 2016
 */
public class PalindromeLinkedList {

	public boolean isPalindrome(ListNode head) {

		if (head == null) {
			return true;
		}

		ListNode p = head;
		ListNode newHead = null;
		while (p != null) {
			ListNode node = new ListNode(p.val);
			node.next = newHead;
			newHead = node;
			p = p.next;
		}

		ListNode p1 = head;
		ListNode p2 = newHead;

		while (p1 != null && p1.val == p2.val) {
			p1 = p1.next;
			p2 = p2.next;
		}

		return p1 == null;
	}
}
