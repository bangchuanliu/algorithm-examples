package tag.bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NetworkDelayTime {
    
    public int networkDelayTime(int[][] times, int N, int K) {
        int result = 0;
        Set<Integer> set = new HashSet<>();
        int[] dis = new int[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[K] = 0;
        set.add(K);

        while (set.size() < N) {
            int node = -1;
            int min = Integer.MAX_VALUE;
            for (int[] time: times) {
                if (set.contains(time[0]) && !set.contains(time[1])) {
                    if (dis[time[0]] + time[2] < min) {
                        min = dis[time[0]] + time[2];
                        node = time[1];
                    }
                }
            }
            if (node == -1) {
                break;
            }
            dis[node] = min;
            set.add(node);
        }

        for (int i = 1; i < dis.length; i++) {
            result = Math.max(result,dis[i]);
        }

        return set.size() < N ? -1 : result;

    }
    
    public static void main(String[] args) {
        int[][] times = {{1,2,1},{2,3,2},{1,3,4}};
        NetworkDelayTime networkDelayTime = new NetworkDelayTime();
        System.out.println(networkDelayTime.networkDelayTime(times,3,1));
    }
}
