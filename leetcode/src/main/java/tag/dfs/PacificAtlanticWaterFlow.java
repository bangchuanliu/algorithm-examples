package tag.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PacificAtlanticWaterFlow {

    public List<int[]> pacificAtlantic(int[][] matrix) {
        boolean[][] p = new boolean[matrix.length][matrix[0].length];
        boolean[][] a = new boolean[matrix.length][matrix[0].length];

        List<int[]> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (dfsA(matrix,i,j,a)) {
                    
                }
            }
        }
        return result;
    }
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}}; 
    public boolean dfsA (int[][] matrix, int i, int j, boolean[][] marked) {
        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];
            if (x < 0 || y < 0) {
                return true;
            }else if (i >= matrix.length || j >= matrix[0].length || marked[x][y]) {
                return false;
            }else if (matrix[i][j] >= matrix[x][y]){
                marked[x][y] = true;
                dfsA(matrix, x, y, marked);
            }
        }
        return false;
    }

    public boolean dfsP (int[][] matrix, int i, int j, boolean[][] marked) {
        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];
            if (x < 0 || y < 0) {
                return true;
            }else if (i >= matrix.length || j >= matrix[0].length || marked[x][y]) {
                return false;
            }else if (matrix[i][j] >= matrix[x][y]){
                marked[x][y] = true;
                dfsA(matrix, x, y, marked);
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        int[][] matrix = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5,}};
        PacificAtlanticWaterFlow pacificAtlanticWaterFlow = new PacificAtlanticWaterFlow();
        List<int[]> result = pacificAtlanticWaterFlow.pacificAtlantic(matrix);

        System.out.println(Arrays.deepToString(result.toArray()));
    }
}
