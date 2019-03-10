package tag.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {

    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    Random ran = new Random();

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {

    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!list.isEmpty() && map.containsKey(val)) {
            int index = map.get(val);
            map.remove(val);
            int last = list.get(list.size() - 1);
            if (index < list.size() - 1) {
                map.put(last, index);
                list.set(index, last);
            }

            list.remove(list.size() - 1);
            return true;
        }
        return false;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        if (!list.isEmpty()) {
            int index = ran.nextInt(list.size());
            return list.get(index);
        }
        return 0;
    }
    public static void main(String[] args){
        RandomizedSet instance = new RandomizedSet();
        instance.insert(1);
        instance.insert(2);
        instance.remove(2);
        System.out.println();
    }
}
