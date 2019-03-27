package tag.graph;

import java.util.ArrayList;
import java.util.List;

public class NumberofIslandsII {
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        UF uf = new UF(m * n);
        
        int[][] dir =  {{0,1},{0,-1},{1,0},{-1,0}};
        for (int i = 0; i < positions.length; i++) {
            List<Integer> neighbors = new ArrayList<>();
            
            for (int j = 0 ;j < dir.length; j++) {
                int x = positions[i][0] + dir[j][0];
                int y = positions[i][1] + dir[j][1];
                if (x >=0 && x < m && y >=0 && y< n && uf.isValid(x*n + y)) {
                    neighbors.add(x*n+y);
                }
            }
            
            uf.setId(positions[i][0] * n + positions[i][1]);
            for (int v : neighbors) {
                uf.union(positions[i][0] * n + positions[i][1], v);
            }
            result.add(uf.count);
        }
        
        return result;
    }


    class UF {
        int[] id;
        int count;

        UF(int N) {
            id = new int[N];
            for (int i = 0; i < N; i++) {
                id[i] = -1;
            }
        }

        public int find(int p) {
            while (id[p] != p) {
                p = id[p];
            }
            return p;
        }

        public boolean union(int a, int b) {
            int ra = find(a);
            int rb = find(b);
            if (ra != rb) {
                count--;
                id[ra] = rb;
                return true;
            }else {
                return false;
            }
        }
        
        public void setId(int index) {
            id[index] = index;
            count++;
        }
        
        public boolean isValid(int index) {
            return id[index] != -1;
        }
    }
}
