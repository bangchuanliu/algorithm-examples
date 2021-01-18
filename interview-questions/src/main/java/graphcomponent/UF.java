package graphcomponent;

import java.util.HashSet;
import java.util.Set;

public class UF {

    public static void main(String[] args) {
        int[][]  list = {{1,2}, {2,3}, {1,3}, {4,5}};
        UF uf = new UF();
        
        for(int i = 0; i < list.length; i++){
            int[] edge = list[i];
            uf.union(edge[0], edge[1]);
        }
        
        System.out.println(uf.count());
    }
    
    public UF() {
        for(int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }
    
    int[] id = new int[10000];

    public int find(int x) {
        while (x != id[x]) {
            x = id[x];
        }
        return x;
    }

    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px != py) {
            id[px] = py;
        }
    }

    public int count() {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= 5; i++) {
            set.add(find(id[i]));
        }
        return set.size();
    }
}
 