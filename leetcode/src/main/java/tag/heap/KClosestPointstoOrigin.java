package tag.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class KClosestPointstoOrigin {

    public int[][] kClosest(int[][] points, int K) {

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1]);

        for (int i = 0; i < points.length; i++) {
            q.add(points[i]);
            if (q.size() > K) {
                q.poll();
            }
        }

        int[][] result = new int[K][2];
        int index = 0;
        while (!q.isEmpty()) {
            result[index++] = q.poll();
        }

        return result;
    }

    public int[][] kClosest2(int[][] points, int K) {

        int i = 0;
        int j = points.length - 1;
        int offset = K - 1;
        while (i <= j) {
            int index = partition(points, i, j);

            if (index == offset) {
                return Arrays.copyOfRange(points, 0, index + 1);
            } else if (index > offset) {
                j = index - 1;
            } else {
                i = index + 1;
            }
        }

        return null;
    }


    public int partition(int[][] points, int i, int j) {
        Random ran = new Random();
        int index = ran.nextInt(j - i + 1) + i;
        int[] temp = points[j];
        points[j] = points[index];
        points[index] = temp;

        int l = i;
        int r = j - 1;
        while (l <= r) {
            if (dist(points[l], points[j]) <= 0) {
                l++;
            } else {
                temp = points[r];
                points[r] = points[l];
                points[l] = temp;
                r--;
            }
        }
        temp = points[j];
        points[j] = points[l];
        points[l] = temp;

        return l;
    }


    public int dist(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }


    public static void main(String[] args) {
        KClosestPointstoOrigin kClosestPointstoOrigin = new KClosestPointstoOrigin();
        int[][] points = {{6, 10}, {-3, 3}, {-2, 5}, {0, 2}};
//        int[][] points = {{1,3},{-2,2}};
        System.out.println(Arrays.deepToString(kClosestPointstoOrigin.kClosest(points, 3)));
        System.out.println(Arrays.deepToString(kClosestPointstoOrigin.kClosest2(points, 3)));
    }
}
