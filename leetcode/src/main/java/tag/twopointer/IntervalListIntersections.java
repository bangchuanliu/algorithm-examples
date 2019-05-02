package tag.twopointer;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0;
        int j = 0;

        List<int[]> list = new ArrayList<>();
        while (i < A.length && j < B.length) {
            if (A[i][0] <= B[j][1] && B[j][0] <= A[i][1]) {
                int low = Math.max(A[i][0], B[j][0]);
                int high = Math.min(A[i][1], B[j][1]);
                list.add(new int[]{low, high});
            }
            
            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        int[][] result = new int[list.size()][2];

        for (i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
