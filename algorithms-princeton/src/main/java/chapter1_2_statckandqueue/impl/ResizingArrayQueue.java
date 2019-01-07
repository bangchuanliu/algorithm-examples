package chapter1_2_statckandqueue.impl;

import chapter1_1_basicprogrammingmodel.ArrayUtil;
import chapter1_1_basicprogrammingmodel.RandomUtil;
import chapter1_2_statckandqueue.IRandomQueue;

public class ResizingArrayQueue<Item> implements IRandomQueue<Item> {
    private Item[] items;
    private int size = 0;

    public ResizingArrayQueue(int cap) {
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
    public void enQueue(Item item) {
        if (size == items.length) {
            resize(size * 2);
        }
        for (int i = size - 1; i >= 0; i--) {
            items[i + 1] = items[i];
        }
        items[0] = item;
    }

    @Override
    public Item deQueue() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        int r = RandomUtil.uniform(size - 1);
        ArrayUtil.swap(items, r, size - 1);
        Item item = items[--size];
        items[size] = null;
        if (size > 0 && size <= items.length / 4) {
            resize(items.length / 2);
        }
        return item;
    }

    @Override
    public Item sample() {
        return items[RandomUtil.uniform(size)];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
