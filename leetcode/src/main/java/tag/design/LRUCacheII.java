package tag.design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCacheII {
    private Map<Integer, Integer> cache;
    private LinkedList<Integer> list;
    private int capacity;

    public LRUCacheII(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        list = new LinkedList();
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            list.remove(new Integer(key));
            list.addFirst(key);
            return cache.get(key);
        }

        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            list.remove(new Integer(key));
        } else {
            if (capacity == cache.size()) {
                Integer last = list.get(list.size() - 1);
                cache.remove(last);
                list.remove(last);
            }
        }
        list.addFirst(key);
        cache.put(key, value);
    }

    public static void main(String[] args){
        LRUCacheII instance = new LRUCacheII(2);
        instance.put(2,1);
        instance.put(2,2);
        System.out.println(instance.get(2));
        instance.put(1,1);
        instance.put(4,1);
        System.out.println(instance.get(2));
        
//        System.out.println(instance.get(1));
//        System.out.println(instance.get(3));
//        System.out.println(instance.get(4));
        
    }
}
