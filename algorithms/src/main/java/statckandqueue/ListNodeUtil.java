package statckandqueue;

public class ListNodeUtil {

    public static ListNode createLinkedList(int[] a) {
        ListNode head = new ListNode();
        ListNode p = head;
        for (int i = 0; i < a.length; i++) {
            ListNode newListNode = new ListNode();
            newListNode.item = a[i];
            p.next = newListNode;
            p = newListNode;
        }

        return head.next;
    }

    public static void printLinkedList(ListNode first) {
        for (; first != null; first = first.next) {
            System.out.print(first.item + " ");
        }
        System.out.println();
    }

}
