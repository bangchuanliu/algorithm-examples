package leetcode.easy.linkedlist;

import common.ListNode;

/**
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6 Return: 1 --> 2
 * --> 3 --> 4 --> 5
 * 
 * @author BangChuan Liu
 * @date 2015
 * @Contact liubangchuan1100@gmail.com
 */
public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return head;
		}
		ListNode dumy = new ListNode(val - 1);
		dumy.next = head;
		ListNode p = dumy;
		while (p.next != null) {
			if (p.next.val == val) {
				p.next = p.next.next;
			} else {
				p = p.next;
			}
		}
		return dumy.next;
	}

	public static void main(String[] args) {
		RemoveLinkedListElements ins = new RemoveLinkedListElements();
		ListNode head = new ListNode(1);
		System.out.println(ins.removeElements(head, 1));
	}
}
