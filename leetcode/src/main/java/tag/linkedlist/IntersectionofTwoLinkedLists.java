package tag.linkedlist;

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
        ListNode pa = headA;
        ListNode pb = headB;


        while (pa != pb) {
            if (pa == null) {
                pa = headB;
            }else {
                pa = pa.next;
            }
            if (pb == null) {
                pb = headA;
            }else {
                pb = pb.next;
            }
        }

        return pa;
	}
}


