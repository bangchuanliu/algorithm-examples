package tag.random;

import common.ListNode;

public class LinkedListRandomNode {
    /**
     * @param head The linked list's head.
     * Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    private ListNode head = null;

    public LinkedListRandomNode(ListNode head) {
        this.head = head;
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        int candidate = head.val;
        double count = 1;
        ListNode p = head.next;
        while (p != null) {
            count++;
            double probability = Math.random();
            if (probability <= 1 / count) {
                candidate = p.val;
            }
            p = p.next;
        }
        
        return candidate;
    }
    
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        LinkedListRandomNode solution = new LinkedListRandomNode(node1);
        System.out.println(solution.getRandom());
    }
}
