package chapter1_2_statckandqueue;

public class LinkedListUtil {

    public static <Item> ListNode createLinkedList(Item[] a) {
        ListNode<Item> current = null;
        for (int i = a.length - 1; i >= 0; i--) {
            ListNode<Item> newListNode = new ListNode(a[i]);
            newListNode.next = current;
            current = newListNode;
        }
        return current;
    }

    public static void printLinkedList(ListNode first) {
        for (; first != null; first = first.next) {
            System.out.print(first.item + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Integer[] a = {1,2,3,4,5,6,7,8};
        ListNode first = createLinkedList(a);
        printLinkedList(first);
    }

}
