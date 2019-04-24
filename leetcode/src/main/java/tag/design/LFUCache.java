package tag.design;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LFUCache {

    private Map<Integer, Integer> cache;
    private Map<Integer, long[]> count;
    private PriorityQueue<long[]> pq;
    private int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        count = new HashMap<>(capacity);
        pq = new PriorityQueue<>((a,b ) -> {
            if (a[0] == b[0]) {
                return a[1] > b[1] ? 1 : -1;
            } else {
                return a[0] > b[0] ? 1 : -1;
            }
        });
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            long[] keyCount = count.get(key);
            keyCount[0]++;
            keyCount[1] = System.currentTimeMillis();
            count.put(key, keyCount);
            return cache.get(key);
        }

        return -1;
    }

    public void put(int key, int value) {
        if (capacity != 0) {
            if (!cache.containsKey(key)) {
                if (capacity == cache.size()) {
                    long[] keyCount = pq.poll();
                    cache.remove(Integer.valueOf(keyCount[2]+""));
                    count.remove(Integer.valueOf(keyCount[2]+""));
                }
                long[] keyCount = new long[]{1, System.currentTimeMillis(),key};
                pq.add(keyCount);
                count.put(key, keyCount);
            }
            cache.put(key, value);
        }
    }

    public static void main(String[] args) {
        LFUCache instance = new LFUCache(2);
        instance.put(1, 1);
        instance.put(2, 2);
        System.out.println(instance.get(1));
        instance.put(3, 3);
        System.out.println(instance.get(2));
        System.out.println(instance.get(3));
        instance.put(4, 4);
        System.out.println(instance.get(1));
        System.out.println(instance.get(3));
        System.out.println(instance.get(4));

//        System.out.println(instance.get(1));
//        System.out.println(instance.get(3));
//        System.out.println(instance.get(4));

    }
}
