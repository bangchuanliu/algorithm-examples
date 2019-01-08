package leetcode.easy.linkedlist;

import common.ListNode;

/**
 * @author bliu13 
 * @since Jan 17, 2016
 */
public class ReverseLinkedListII {
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null || m >= n) {
			return head;
		}
		
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode p = dummy;
		int index = 1;
		while (p.next != null && index < m) {
			index++;
			p = p.next;
		}
		ListNode pre = p;
		
		if (p.next == null) {
			return head;
		}
		
		ListNode p1 = p;
		ListNode p2 = p.next;
		
		while (p2 != null && index <= n) {
			ListNode p3 = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = p3;
			index++;
		}
		
		ListNode temp = pre.next;
		pre.next = p1;
		temp.next = p2;
		
		return dummy.next;
	}
}
