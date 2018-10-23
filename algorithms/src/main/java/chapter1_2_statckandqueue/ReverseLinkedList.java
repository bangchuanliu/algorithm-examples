package chapter1_2_statckandqueue;

public class ReverseLinkedList {

    public static ListNode reverse(ListNode first) {
        if (first == null || first.next == null) {
            return first;
        }

        ListNode p = first;
        ListNode q = first.next;

        while (p != null && q != null) {
            ListNode r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        first.next = null;
        return p;
    }


    /**
     * better solution
     *
     * @param first
     * @return
     */
    public static ListNode reverse2(ListNode first) {
        if (first == null || first.next == null) {
            return first;
        }

        ListNode p = first;
        ListNode next = null;

        while (p != null) {
            ListNode q = p.next;
            p.next = next;
            next = p;
            p = q;
        }
        return next;
    }


    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5, 6, 7};
        ListNode first = LinkedListUtil.createLinkedList(a);
        LinkedListUtil.printLinkedList(first);
        ListNode listNode = reverse(first);
        LinkedListUtil.printLinkedList(listNode);
        ListNode first2 = LinkedListUtil.createLinkedList(a);
        ListNode listNode2 = reverse(first2);
        LinkedListUtil.printLinkedList(listNode2);
    }
}
