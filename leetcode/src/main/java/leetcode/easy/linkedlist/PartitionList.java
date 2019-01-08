package leetcode.easy.linkedlist;

import common.ListNode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5
 * 
 * @author BangChuan Liu
 * @date 2015
 * @Contact liubangchuan1100@gmail.com
 */
public class PartitionList {
	public ListNode partition(ListNode head, int x) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode p1 = dummy;
		ListNode p2 = dummy;

		while (p2 != null && p2.next != null) {
			if (p2.next.val < x) {
				if (p1 == p2) {
					p1 = p1.next;
					p2 = p2.next;
				} else {
					ListNode temp = p2.next;
					p2.next = p2.next.next;

					temp.next = p1.next;
					p1.next = temp;
					p1 = p1.next;
				}
			} else {
				p2 = p2.next;
			}
		}

		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(2);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		PartitionList ins = new PartitionList();
		ListNode head = ins.partition(n1, 3);
		while (head != null) {
			System.out.print(head.val + "  ");
			head = head.next;
		}
	}
}
