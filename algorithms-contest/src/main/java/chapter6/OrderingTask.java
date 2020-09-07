package chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderingTask {
    public static void main(String[] args) {
        int[] n1 = {0,1};
        int[] n2 = {2,1};
        int[] n3 = {3,2};
        
        List<int[]> list = Arrays.asList(n1, n2, n3);
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < 4; i++){
            if (c[i] == 0) {
                if (!solve(list, result, i)) return;    
            }
        }
        
        System.out.println(Arrays.toString(result.toArray()));
    }
    
    
    static int[] c = new int[10000];
    public static boolean solve(List<int[]> list, List<Integer> result, int u){
        c[u] = -1;
        for (int i = 0; i < list.size(); i++){
            if (u == list.get(i)[0]){
                int v = list.get(i)[1];
                if (c[v] == -1) return false;
                if (c[v] == 0 && !solve(list, result, v)) return false;    
            }
        }
        c[u] = 1;
        result.add(0, u);
        return true;
    }
}
