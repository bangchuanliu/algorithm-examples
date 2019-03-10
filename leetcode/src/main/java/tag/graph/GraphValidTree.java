package tag.graph;

public class GraphValidTree {
    
    public boolean validTree(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int i = 0; i < edges.length; i++) {
            if (!uf.union(edges[i][0], edges[i][1])) {
                return false;
            }
        }
        
        return uf.count == 1;
    }


    class UF {
        int[] id;
        int count;

        UF(int N) {
            id = new int[N];
            for (int i = 0; i < N; i++) {
                id[i] = i;
            }
            count = N;
        }

        public int find(int p) {
            while (id[p] != p) {
                p = id[p];
            }
            return p;
        }

        public boolean union(int a, int b) {
            count--;
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
    
}


