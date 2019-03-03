package tag.hashtable;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {
    
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int N = A.length;
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map.put(0 - A[i] - B[j], map.getOrDefault(0 - A[i] - B[j], 0) + 1);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map.containsKey(C[i] + D[j])) {
                    count += map.get(C[i] + D[j]);
                }
            }
        }

        return count;
    }

}
