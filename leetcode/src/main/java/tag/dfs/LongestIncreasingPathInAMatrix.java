package tag.dfs;

public class LongestIncreasingPathInAMatrix {

    public static int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int[][] cached = new int[matrix.length][matrix[0].length];
                int len = dfs(matrix, cached, i, j);
                max = Math.max(max, len);
            }
        }
        return max;
    }

    public static int dfs(int[][] matrix, int[][] cached, int i, int j) {
        if (cached[i][j] != 0) {
            return cached[i][j];
        }
        int max = 1;
        int[][] dis = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] d : dis) {
            int x = i + d[0];
            int y = j + d[1];
            
            if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[x].length || matrix[x][y] <= matrix[i][j]) {
                continue;
            }
            int len = 1 + dfs(matrix, cached, x, y);
            max = Math.max(max, len);
        }
        cached[i][j] = max;
        
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = {{3,3,14,2,17,12,5}};
        System.out.println(longestIncreasingPath(matrix));
    }
}
