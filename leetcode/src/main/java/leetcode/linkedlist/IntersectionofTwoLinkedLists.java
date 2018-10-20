package leetcode.linkedlist;

import common.ListNode;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
 * 
 * 
 * @author bliu13 Jan 13, 2016
 */
public class IntersectionofTwoLinkedLists {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		ListNode p1 = headA;
		ListNode p2 = headB;
		int len1 = 0;
		int len2 = 0;
		while (p1 != null) {
			p1 = p1.next;
			len1++;
		}
		while (p2 != null) {
			p2 = p2.next;
			len2++;
		}
		p1 = headA;
		p2 = headB;
		if (len1 > len2) {
			while (len2 < len1) {
				p1 = p1.next;
				len2++;
			}
		} else if (len1 < len2) {
			while (len1 < len2) {
				p2 = p2.next;
				len1++;
			}
		}
		while (p1 != null && p2 != null && p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
}


