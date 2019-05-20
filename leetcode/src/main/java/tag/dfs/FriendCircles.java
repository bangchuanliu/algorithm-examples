package tag.dfs;

public class FriendCircles {

    public int findCircleNum(int[][] M) {
        int count = 0;
        boolean[] marked = new boolean[M.length];
        for (int i = 0; i < M.length; i++) {
            if (!marked[i]) {
                count++;
                dfs(M, i, marked);
            }
        }

        return count;
    }



    public void dfs(int[][] M, int i, boolean[] marked) {
        for (int j = 0; j < M[i].length; j++) {
            if (M[i][j] == 1 && !marked[j]) {
                marked[j] = true;
                dfs(M, j, marked);
            }
        }
    }
}
