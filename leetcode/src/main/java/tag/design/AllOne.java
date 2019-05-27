package tag.design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class AllOne {

    Map<String, Integer> keyMap;
    Map<Integer, Set<String>> countMap;
    LinkedList<Integer> minMax;

    /**
     * Initialize your data structure here.
     */
    public AllOne() {
        keyMap = new HashMap<>();
        countMap = new HashMap<>();
        minMax = new LinkedList<>();
    }

    public void putIntoCountMap(int count, String key) {
        Set<String> set = countMap.getOrDefault(count, new HashSet<>());
        set.add(key);
        countMap.put(count, set);

        if (minMax.isEmpty() || minMax.getFirst() > count) {
            minMax.addFirst(count);
        }

        if (!minMax.isEmpty() && minMax.getLast() < count) {
            minMax.addLast(count);
        }
    }

    public void removeFromCountMap(int count, String key) {
        if (countMap.containsKey(count)) {
            Set<String> set = countMap.get(count);
            set.remove(key);
            if (set.size() == 0) {
                countMap.remove(count);
                if (!minMax.isEmpty() && minMax.getFirst() == count) {
                    minMax.removeFirst();
                }

                if (!minMax.isEmpty() && minMax.getLast() == count) {
                    minMax.removeLast();
                }
            }
        }
    }


    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        if (keyMap.containsKey(key)) {
            int count = keyMap.get(key);
            keyMap.put(key, count + 1);
            removeFromCountMap(count, key);
            putIntoCountMap(count + 1, key);
        } else {
            keyMap.put(key, 1);
            putIntoCountMap(1, key);
        }
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        if (keyMap.containsKey(key)) {
            int count = keyMap.get(key);
            removeFromCountMap(count, key);
            if (count == 1) {
                keyMap.remove(key);
            } else {
                keyMap.put(key, count-1);
                putIntoCountMap(count - 1, key);
            }
        }
    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        if (!minMax.isEmpty()) {
            return countMap.get(minMax.getLast()).iterator().next();
        } else {
            return "";
        }
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        if (!minMax.isEmpty()) {
            return countMap.get(minMax.getFirst()).iterator().next();
        } else {
            return "";
        }

    }

    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("c");
        allOne.inc("c");
        allOne.inc("c");
        allOne.dec("b");
        allOne.dec("b");

        System.out.println(allOne.getMinKey());

        allOne.dec("a");
        System.out.println(allOne.getMaxKey());
        System.out.println(allOne.getMinKey());
//        allOne.dec("hello");

//        System.out.println(allOne.getMinKey());
//        allOne.dec("a");

//        System.out.println(allOne.getMinKey());
    }
}
