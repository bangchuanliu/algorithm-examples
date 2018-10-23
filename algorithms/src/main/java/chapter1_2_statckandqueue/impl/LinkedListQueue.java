package chapter1_2_statckandqueue.impl;

import chapter1_2_statckandqueue.IQueue;
import chapter1_2_statckandqueue.ListNode;

import java.util.Iterator;

public class LinkedListQueue<Item> implements IQueue<Item> {

    private ListNode<Item> first;
    private ListNode<Item> last;
    private int size = 0;


    @Override
    public void enQueue(Item item) {
        ListNode<Item> node = new ListNode<>(item);
        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    @Override
    public Item deQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        ListNode<Item> node = first;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        
        return node.item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
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
