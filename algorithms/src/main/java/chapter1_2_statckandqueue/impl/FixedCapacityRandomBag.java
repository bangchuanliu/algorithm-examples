package chapter1_2_statckandqueue.impl;

import chapter1_1_basicprogrammingmodel.RandomUtil;
import chapter1_2_statckandqueue.IBag;

import java.util.Iterator;

public class FixedCapacityRandomBag<Item> implements IBag<Item> {
    private Item[] items;
    private int size;

    public FixedCapacityRandomBag(int cap) {
        if (cap <= 0) {
            throw new RuntimeException("capacity must be positive integer");
        }
        items = (Item[]) new Object[cap];
    }

    @Override
    public void add(Item item) {
        items[size++] = item;
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
        return new FixedCapacityRandomBagIterator(items);
    }

    private class FixedCapacityRandomBagIterator<Item> implements Iterator<Item> {
        private Item[] a;
        private int count = 0;

        private FixedCapacityRandomBagIterator(Item[] items) {
            a = (Item[]) new Object[size];
            for (int i = 0; i < size; i++) {
                a[i] = items[i];
            }
            RandomUtil.shuffle(a);
        }

        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public Item next() {
            return a[count++];
        }
    }


    public static void main(String[] args) {
        FixedCapacityRandomBag<Integer> bag = new FixedCapacityRandomBag(10);
        bag.add(1);
        bag.add(2);
        bag.add(3);
        bag.add(4);
        bag.add(5);
        bag.add(6);
        bag.add(7);
        Iterator<Integer> bagIterator = bag.iterator();
        while (bagIterator.hasNext()) {
            System.out.print(bagIterator.next() + " ");
        }
    }
}
