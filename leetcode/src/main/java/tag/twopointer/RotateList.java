package tag.twopointer;

import common.ListNode;

public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {

		if (head == null || head.next == null || k < 0) {
			return head;
		}
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1;
        ListNode p2;
		
        p1 = head;
		int len = 0;

		while (p1 != null) {
			len++;
			p1 = p1.next;
		}

		k = k % len;
		p1 = dummy;
		p2 = dummy;
		for (int i = 0 ; i < len - k; i++) {
		    p2 = p2.next;
        }
        
		while (p2 != null && p2.next != null) {
		    ListNode temp = p2.next;
            p2.next = p2.next.next;
            temp.next = p1.next;
		    p1.next = temp;
		    p1 = p1.next;
		}

		return dummy.next;
	}
	
	public static void main(String[] args) {
        ListNode n0 = new ListNode(0);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n0.next = n1;
        n1.next = n2;

        RotateList rotateList = new RotateList();
        ListNode head = rotateList.rotateRight(n0,4);
    }
}
