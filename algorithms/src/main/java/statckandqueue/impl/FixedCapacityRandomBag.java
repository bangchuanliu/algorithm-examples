package statckandqueue.impl;

import statckandqueue.IBag;

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
        
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
    
    
}
