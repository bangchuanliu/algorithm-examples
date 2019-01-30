package tag.binaryindextree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class SkyLineProblem {

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();

        for (int i = 0; i < buildings.length; i++) {
            int[] h1 = {buildings[i][0], -buildings[i][2]};
            int[] h2 = {buildings[i][1], buildings[i][2]};
            height.add(h1);
            height.add(h2);
        }

        Collections.sort(height, (h1, h2) -> {
            if (h1[0] != h2[0]) {
                return h1[0] - h2[0];
            } else {
                return h1[1] - h2[1];
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.add(0);
        int pre = 0;

        for (int[] h : height) {
            if (h[1] < 0) {
                pq.add(-h[1]);
            } else {
                pq.remove(h[1]);
            }

            int cur = pq.peek();

            if (cur != pre) {
                result.add(new int[]{h[0], cur});
                pre = cur;
            }
        }
        return result;
    }
}
