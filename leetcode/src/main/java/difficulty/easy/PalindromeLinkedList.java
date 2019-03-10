package difficulty.easy;

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
		
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null ) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode pre = null;
        ListNode cur = slow;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        while (head != null && pre != null && head != pre && head.val == pre.val) {
            head = head.next;
            pre = pre.next;
        }
        return pre == null || head == pre;
	}
}
