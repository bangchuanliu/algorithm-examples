package chapter1_2_statckandqueue.impl;

import chapter1_2_statckandqueue.IStack;

import java.util.Iterator;

/**
 * ignore corner case
 * 
 *  push, pop, isEmpty, size, Iterator
 */

public class FixedCapacityStack<Item> implements IStack<Item> {
    private Item[] items;
    private int size = 0;

    public FixedCapacityStack(int cap) {
        if (cap <= 0) {
            throw new RuntimeException("cap must larger than zero");
        }
        items = (Item[]) new Object[cap];
    }

    public void push(Item item) {
        if (isFull()) {
            throw new RuntimeException("stack is full");
        }
        items[size++] = item;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        return items[--size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean isFull() {
        return items != null && size == items.length;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
