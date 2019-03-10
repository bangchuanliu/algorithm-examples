package tag.design;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LFUCache {

    private Map<Integer, Integer> cache;
    private Map<Integer, KeyCount> count;
    private PriorityQueue<KeyCount> pq;
    private int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        count = new HashMap<>(capacity);
        pq = new PriorityQueue<>((a,b ) -> {
            if (a.count == b.count) {
                return a.timestamp > b.timestamp ? 1 : -1;
            } else {
                return a.count - b.count;
            }
        });
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            KeyCount keyCount = count.get(key);
            pq.remove(keyCount);
            pq.remove(keyCount);
            keyCount.count++;
            keyCount.timestamp = System.currentTimeMillis();
            pq.add(keyCount);
            count.put(key, keyCount);
            return cache.get(key);
        }

        return -1;
    }

    public void put(int key, int value) {
        if (!cache.containsKey(key)) {
            if (capacity == cache.size()) {
                KeyCount keyCount = pq.poll();
                cache.remove(keyCount.key);
                count.remove(keyCount.key);
            }
            KeyCount keyCount = new KeyCount(key, 1, System.currentTimeMillis());
            pq.add(keyCount);
            count.put(key, keyCount);
        }
        cache.put(key, value);
    }

    class KeyCount {
        int key;
        int count;
        long timestamp;
        KeyCount(int key, int count, long timestamp) {
            this.key = key;
            this.count = count;
            this.timestamp = timestamp;
        }
    }
    
    public static void main(String[] args) {
        LRUCacheII instance = new LRUCacheII(2);
        instance.put(2, 1);
        instance.put(2, 2);
        System.out.println(instance.get(2));
        instance.put(1, 1);
        instance.put(4, 1);
        System.out.println(instance.get(2));

//        System.out.println(instance.get(1));
//        System.out.println(instance.get(3));
//        System.out.println(instance.get(4));

    }
}
