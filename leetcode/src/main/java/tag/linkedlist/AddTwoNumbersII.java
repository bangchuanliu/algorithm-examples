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
        while (!s1.isEmpty() || !s2.isEmpty() ) {
            int temp = adv;
            
            if (!s1.isEmpty()) {
                temp += s1.pop();
            }

            if (!s2.isEmpty()) {
                temp += s2.pop();
            }
            
            adv = temp / 10;
            ListNode node = new ListNode(temp % 10);
            node.next = helper.next;
            helper.next = node;
        }

        return adv == 1?helper : helper.next;
        
    }
}
