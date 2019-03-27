package tag.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointstoOrigin {
    
    public int[][] kClosest(int[][] points, int K) {
        int[] dis = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            dis[i] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
        }

        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> dis[b] - dis[a]);
        
        for (int i = 0; i < dis.length; i++) {
            q.add(i);
            if (q.size() > K) {
                q.poll();
            }
        }
        
        int[][] result = new int[K][2];
        int index = 0;
        while(!q.isEmpty()) {
            result[index++] = points[q.poll()];
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        KClosestPointstoOrigin kClosestPointstoOrigin = new KClosestPointstoOrigin();
        int[][] points = {{1,3},{-2,-2}};
        System.out.println(Arrays.deepToString(kClosestPointstoOrigin.kClosest(points, 1)));
    }
}
