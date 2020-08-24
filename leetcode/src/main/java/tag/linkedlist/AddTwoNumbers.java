package tag.linkedlist;

import common.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode helper = new ListNode(0);
        ListNode p3 = helper;
        int adv = 0;
        while (p1 != null || p2 != null) {
            int temp = adv;
            if (p1 != null) {
                temp += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                temp += p2.val;
                p2 = p2.next;
            }
            adv = temp / 10;
            p3.next = new ListNode(temp % 10);
            p3 = p3.next;
        }

        if (adv > 0) {
            p3.next = new ListNode(adv);
        }
        return helper.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p = new ListNode(0);
        ListNode head = p;

        int adv = 0;

        while(p1 != null || p2 != null){
            if (p1 == null) {
                p.next = new ListNode((p2.val + adv) % 10);
                adv = (p2.val + adv) / 10;
                p2 = p2.next;
            }else if (p2 == null){
                p.next = new ListNode((p1.val + adv) % 10);
                adv = (p1.val + adv) / 10;
                p1 = p1.next;
            }else {
                p.next = new ListNode((p2.val + p1.val + adv) % 10);
                adv = (p1.val + p2.val + adv) / 10;
                p2 = p2.next;
                p1 = p1.next;
            }
            p = p.next;
        }

        if (adv > 0){
            p.next = new ListNode(adv);
        }

        return head.next;

    }
}
