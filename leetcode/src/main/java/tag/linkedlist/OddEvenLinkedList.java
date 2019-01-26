package tag.linkedlist;

import common.ListNode;

public class OddEvenLinkedList {
	
	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return head;
		}
		
		ListNode p1 = head;
		ListNode p2 = head.next;
		
		while (p2 != null && p2.next != null) {
			ListNode temp = p2.next.next;
			p2.next.next = p1.next;
			p1.next = p2.next;
			p2.next = temp;
			p2 = temp;
			p1 = p1.next;
		}
		
		return head;
	}
	
	public static void main(String[] args){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		n1.next  = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		
		OddEvenLinkedList instance = new OddEvenLinkedList();
		ListNode p = instance.oddEvenList(n1);
		while (p != null) {
			System.out.println(p.val);
			p = p.next;
		}
	}
}
