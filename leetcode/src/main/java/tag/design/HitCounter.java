package tag.design;

import java.util.TreeMap;

public class HitCounter {

    TreeMap<Integer, Integer> map;
    /** Initialize your data structure here. */
    public HitCounter() {
        map = new TreeMap<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        map.put(timestamp, map.getOrDefault(timestamp,0) + 1);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        Integer from = map.higherKey(timestamp-300);
        int sum = 0;
        while (from != null && from <= timestamp) {
            sum += map.get(from);
            from = map.higherKey(from);
        }
        return sum;
    }

    public static void main(String[] args){
        HitCounter hitCounter = new HitCounter();
        hitCounter.hit(1);
        hitCounter.hit(2);
        hitCounter.hit(3);
        hitCounter.hit(300);
        System.out.println(hitCounter.getHits(4));
        System.out.println(hitCounter.getHits(300));
        System.out.println(hitCounter.getHits(301));
    }
}
