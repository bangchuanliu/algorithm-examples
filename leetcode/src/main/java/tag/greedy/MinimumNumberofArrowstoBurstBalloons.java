package tag.greedy;

import java.util.Arrays;

public class MinimumNumberofArrowstoBurstBalloons {

    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] pre = points[0];
        int count = 1;

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= pre[1]) {
                pre[0] = Math.max(pre[0], points[i][0]);
                pre[1] = Math.min(pre[1], points[i][1]);
            } else {
                count++;
                pre = points[i];
            }
        }

        return count;
    }
}
