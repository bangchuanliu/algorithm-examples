package chapter1_2_statckandqueue;

public class ListNode<Item> {
    
    public ListNode (Item item) {
        this.item = item;
        next = null;
    }
    
    public Item item;
    public ListNode<Item> next;
}
