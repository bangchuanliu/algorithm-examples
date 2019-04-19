package company.google;

import java.util.HashMap;

public class SwapPair {

    static int countSwaps(int[][] seats) {
        
        int n = seats.length;
        HashMap<Integer, Integer> unmatches = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            if (seats[i][0] == seats[i][1]) {
                continue;
            }

            unmatches.put(seats[i][0], seats[i][1]);
        }

        int count = 0;
        while (!unmatches.isEmpty()) {
            int l1, r1, l2, r2;
            l1 = unmatches.keySet().iterator().next();
            r1 = unmatches.get(l1);
            l2 = r1;
            r2 = unmatches.get(l2);

            unmatches.put(l1, r2);
            unmatches.put(l2, r1);
            ++count;

            unmatches.remove(l2);

            if (l1 == r2) {
                unmatches.remove(l1);
            }
        }

        return count;
    }
}
