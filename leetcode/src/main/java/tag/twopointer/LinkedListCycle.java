package tag.twopointer;

import common.ListNode;

public class LinkedListCycle {
	
	public boolean hasCycle(ListNode head) {
		
		if (head == null || head.next == null) {
			return false;
		}
		
		ListNode slow = head.next;
		ListNode fast = head.next.next;
		
		while (fast != null && fast.next != null && slow != fast) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow == fast;
	}
}
