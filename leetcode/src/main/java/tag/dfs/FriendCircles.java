package tag.dfs;

import java.util.HashSet;
import java.util.Set;

public class FriendCircles {

    public int findCircleNum(int[][] M) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < M.length; i++) {
            if (!set.contains(i)) {
                count++;
                set.add(i);
                dfs(M, set, i);
            }
        }
        
        return count;
    }

    public void dfs(int[][] M, Set<Integer> set, int v) {
        if (set.size() == M.length) {
            return;
        }
        
        for (int i = 0; i < M.length; i++) {
            if (M[v][i] == 1 && !set.contains(i)) {
                set.add(i);
                dfs(M, set, i);
            }
        }
    }
}
