package statckandqueue.impl;

import statckandqueue.IBag;
import statckandqueue.ListNode;

import java.util.Iterator;

public class LinkedListBag<Item> implements IBag<Item> {
    private ListNode<Item> first;
    private int size = 0;
    
    @Override
    public void add(Item item) {
        ListNode<Item> oldFirst = first;
        first = new ListNode<>(item);
        first.next = oldFirst;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
