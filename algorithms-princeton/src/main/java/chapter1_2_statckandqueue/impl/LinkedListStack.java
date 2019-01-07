package chapter1_2_statckandqueue.impl;

import chapter1_2_statckandqueue.IStack;
import chapter1_2_statckandqueue.ListNode;

import java.util.Iterator;

public class LinkedListStack<Item> implements IStack<Item> {
    private ListNode<Item> first;
    private int size = 0;

    @Override
    public void push(Item item) {
        ListNode<Item> node = new ListNode<>(item);
        node.next = first;
        first = node;
        size++;
    }

    @Override
    public Item pop() {
        ListNode<Item> node = first;
        first = first.next;
        size--;
        return node.item; 
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
