package chapter1_2_statckandqueue.impl;

import chapter1_2_statckandqueue.IStack;
import chapter1_2_statckandqueue.ListNode;

import java.util.Iterator;

public class Steque<Item> implements IStack<Item> {
    private ListNode<Item> first;
    private int size = 0;

    @Override
    public void push(Item item) {
        ListNode<Item> oldFirst = first;
        first = new ListNode<>(item);
        first.next = oldFirst;
        size++;
    }

    @Override
    public Item pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        ListNode<Item> node = first;
        first = first.next;
        size--;
        return node.item;
    }

    public void enQueue(Item item) {
        ListNode<Item> newNode = new ListNode<>(item);
        if (isEmpty()) {
            first = newNode;
        } else {
            ListNode<Item> node = first;
            while (node.next != null) {
                node = node.next;
            }
            node.next = newNode;
        }
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
