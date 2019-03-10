package tag.design;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class AllOne {

    Map<String, Integer> map;
    PriorityQueue<String> min;
    PriorityQueue<String> max;

    /**
     * Initialize your data structure here.
     */
    public AllOne() {
        map = new HashMap<>();
        min = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        max = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        if (!map.containsKey(key)) {
            min.add(key);
            max.add(key);
        }
        map.put(key, map.getOrDefault(key, 1) + 1);
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        if (map.containsKey(key)) {
            Integer val = map.get(key);
            val--;
            if (val == 1) {
                map.remove(key);
                min.remove(key);
                max.remove(key);
            } else {
                map.put(key, val);
            }
        }
    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        return max.peek() == null ? "" : max.peek();
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        return min.peek() == null ? "" : min.peek();
    }

    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("world");
        allOne.inc("hello");
        allOne.dec("world");
        allOne.inc("hello");
        allOne.inc("leet");
        System.out.println(allOne.getMaxKey());
//        allOne.inc("c");

        allOne.dec("hello");
        allOne.dec("hello");
        allOne.dec("hello");
        System.out.println(allOne.getMaxKey());
//        System.out.println(allOne.getMinKey());
//        allOne.dec("a");

//        System.out.println(allOne.getMinKey());
    }
}
