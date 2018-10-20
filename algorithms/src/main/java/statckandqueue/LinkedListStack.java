package statckandqueue;

public class LinkedListStack<Item> {
    private ListNode<Item> first;
    private int size;

    public LinkedListStack() {
    }

    public void push(Item item) {
        ListNode<Item> listNode = new ListNode<>();
        listNode.item = item;

        listNode.next = first;
        first = listNode;
        size++;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        size--;
        ListNode<Item> listNode = first;
        first = first.next;
        return listNode.item;
        
    }
    
    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

}
