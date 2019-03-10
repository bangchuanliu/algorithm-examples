package tag.linkedlist;

import common.ListNode;

import java.util.Stack;

public class AddTwoNumbersII {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while(l1 != null || l2 != null) {
            if (l1 != null) {
                s1.push(l1.val);
                l1 = l1.next;    
            }
            if (l2 != null) {
                s2.push(l2.val);
                l2 = l2.next;    
            }
        }

        ListNode helper = new ListNode(1);
        int adv = 0;
        while (!s1.isEmpty() && !s2.isEmpty() ) {
            int val1 = s1.pop();
            int val2 = s2.pop();
            int val = (val1 + val2 + adv) % 10;
            adv = (val1 + val2 + adv) / 10;
            ListNode node = new ListNode(val);
            node.next = helper.next;
            helper.next = node;
        }

        while (!s1.isEmpty()) {
            int val = (s1.peek() + adv) % 10;
            adv = (s1.pop() + adv) / 10;
            ListNode node = new ListNode(val);
            node.next = helper.next;
            helper.next = node;
        }

        while (!s2.isEmpty()) {
            int val = (s2.peek() + adv) % 10;
            adv = (s2.pop() + adv) / 10;
            ListNode node = new ListNode(val);
            node.next = helper.next;
            helper.next = node;
        }

        return adv == 1?helper : helper.next;
        
    }
}
