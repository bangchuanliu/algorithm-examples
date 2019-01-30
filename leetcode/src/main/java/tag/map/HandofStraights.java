package tag.map;

import java.util.Arrays;
import java.util.TreeMap;

public class HandofStraights {

    public static boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer, Integer> maps = new TreeMap<>();
        Arrays.sort(hand);
        for (int a : hand) {
            if (maps.containsKey(a)) {
                maps.put(a, maps.get(a) + 1);
            } else {
                maps.put(a, 1);
            }
        }

        while (!maps.isEmpty()) {
            int start = maps.firstKey();
            for (int i = 0; i < W; i++) {
                if (maps.containsKey(start + i)) {
                    int count = maps.get(start + i);
                    count--;
                    if (count == 0) {
                        maps.remove(start + i);
                    } else {
                        maps.put(start + i, count);
                    }
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        System.out.println(isNStraightHand(hand, 3));
        int[] hand2 = {1, 2, 3, 4, 5};
        System.out.println(isNStraightHand(hand2, 4));
    }
}
