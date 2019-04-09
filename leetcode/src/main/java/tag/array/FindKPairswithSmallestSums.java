package tag.array;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairswithSmallestSums {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> (b[0]+b[1]-a[0]-a[1]));

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                q.add(new int[]{nums1[i],nums2[j]});

                if (q.size() > k) {
                    q.poll();
                }
            }
        }

        List<int[]> result = new ArrayList<>();
        while (!q.isEmpty()) {
            result.add(q.poll());
        }

        return result;
    }
}
