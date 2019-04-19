package tag.dfs;

public class LongestIncreasingPathInAMatrix {

    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int[][] mem = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                max = Math.max(dfs(matrix, i, j, mem), max);
            }
        }

        return max;
    }


    public int dfs(int[][] matrix, int i, int j, int[][] mem) {
        if (mem[i][j] > 0) {
            return mem[i][j];
        }
        
        int count = 0;

        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];
            if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= matrix[i][j]) {
                continue;
            }
            count = Math.max(dfs(matrix, x, y, mem), count);
        }
        int ans = count + 1;
        mem[i][j] = ans;
        return ans;
    }

    public static void main(String[] args) {
        LongestIncreasingPathInAMatrix inAMatrix = new LongestIncreasingPathInAMatrix();
        int[][] matrix = {{3, 3, 14, 2, 17, 12, 5}};
        System.out.println(inAMatrix.longestIncreasingPath(matrix));
    }
}
