package tag.array;

public class GameOfLife {
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = liveNeighbors(board, i, j);
                if (board[i][j] == 1) {
                    if (liveNeighbors >= 2 && liveNeighbors <= 3) {
                        result[i][j] = 1;
                    }
                } else if (liveNeighbors == 3) {
                    result[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = result[i][j];
            }
        }
        
    }

    public int liveNeighbors(int[][] board, int i, int j) {
        int live = 0;

        for (int[] pos : dir) {
            int x = pos[0] + i;
            int y = pos[1] + j;

            if (x >= 0 && x < board.length && y >= 0 && y < board[x].length && board[x][y] == 1) {
                live++;
            }
        }
        return live;
    }
    
    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        GameOfLife instnce = new GameOfLife();
        instnce.gameOfLife(board);
        System.out.println(board);
    }
}