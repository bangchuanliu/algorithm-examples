package tag.graph;

import java.util.List;

public class KeysandRooms {
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] marked = new boolean[rooms.size()];
        int count = 0;
        for (int i = 0; i < rooms.size(); i++) {
            if (!marked[i]) {
                count++;
                dfs(rooms, marked,i);
            }
        }
        
        return count == 1;
    }
    
    
    public void dfs(List<List<Integer>> rooms, boolean[] marked, int v) {
        marked[v] = true;
        
        for (int u : rooms.get(v)) {
            if (!marked[u]) {
                dfs(rooms, marked,u);
            }
        }
    }
    
}
