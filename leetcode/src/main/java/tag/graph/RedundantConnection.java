package tag.graph;

import java.util.Arrays;

public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        UF uf = new UF(edges.length+1);
        for (int i = 0; i < edges.length; i++) {
            if (!uf.union(edges[i][0],edges[i][1])) {
                return edges[i];
            }
        }
        
        return new int[0];
    }


    class UF {
        int[] id;

        UF(int N) {
            id = new int[N];
            for (int i = 0; i < N; i++) {
                id[i] = i;
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
                id[ra] = rb;
                return true;
            }else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{3, 4}, {1, 2}, {2, 4}, {3, 5}, {2, 5}};
        RedundantConnection redundantConnection = new RedundantConnection();
        System.out.println(Arrays.toString(redundantConnection.findRedundantConnection(edges)));
    }
}
