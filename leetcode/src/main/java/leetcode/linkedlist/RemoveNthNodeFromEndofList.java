package leetcode.linkedlist;

import common.ListNode;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.

	For example,
	
	   Given linked list: 1->2->3->4->5, and n = 2.
	
	   After removing the second node from the end, the linked list becomes 1->2->3->5.
	Note:
	Given n will always be valid.
	Try to do this in one pass.
 * 
 * 
 * @author BangChuan Liu <liubangchuan1100@gmail.com>
 *
 * @date Oct 30, 2014
 */
public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(n <= 0){
			return head;
		}
		ListNode p1 = head;
		ListNode p2 = head;
		int i = 0;
		while (p2!=null && i < n) {
			p2 = p2.next;
			i++;
		}
		
		if (p2 == null) {
			return head.next;
		}
		
		while(p2.next != null){
			p1 = p1.next;
			p2= p2.next;
		}
		
		p1.next = p1.next.next;
		return head;
	}
	
	public static void main(String[] args){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		ListNode head = new RemoveNthNodeFromEndofList().removeNthFromEnd(n1, 2);
		while(head!=null){
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
}
