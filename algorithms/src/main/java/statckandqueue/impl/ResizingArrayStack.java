package statckandqueue.impl;

import statckandqueue.IStack;

import java.util.Iterator;

/**
 * @param <Item>
 */


public class ResizingArrayStack<Item> implements IStack<Item> {

    private Item[] items;
    private int size = 0;

    public ResizingArrayStack(int cap) {
        if (cap <= 0) {
            throw new RuntimeException("capacity must be positive integer");
        }
        items = (Item[]) new Object[cap];
    }

    private void resize(int newCap) {
        Item[] newItems = (Item[]) new Object[newCap];
        for (int i = 0; i < items.length; i++) {
            newItems[i] = items[i];
        }
        items = newItems;
    }


    @Override
    public void push(Item item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[size++] = item;
    }

    @Override
    public Item pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        Item item = items[--size];
        items[size] = null;
        if (size > 0 && size <= items.length / 4) {
            resize(items.length / 2);
        }
        return item;
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
