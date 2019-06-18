package company.google;

public class MazeGenerator {

    public int[][] maze(int n) {
// Write your solution here.
        int[][] maze = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    maze[i][j] = 0;
                } else {
                    maze[i][j] = 1;
                }
            }
        }
        generate(maze, 0, 0);
        return maze;
    }


    private void generate(int[][] maze, int x, int y) {
        int[] dirX = {1, 0, -1, 0};
        int[] dirY = {0, 1, 0, -1};
        shuffle(dirX, dirY);
        for (int i = 0; i < dirX.length; i++) {
            int dx = dirX[i];
            int dy = dirY[i];
            if (validWall(maze, x + 2 * dx, y + 2 * dy)) {
                maze[x + dx][y + dy] = 0;
                maze[x + 2 * dx][y + 2 * dy] = 0;
                generate(maze, x + 2 * dx, y + 2 * dy);
            }
        }
    }

    private boolean validWall(int[][] maze, int x, int y) {
        if (x >= 0 && x < maze.length && y >= 0 && y < maze.length && maze[x][y] == 1) {
            return true;
        } else {
            return false;
        }
    }

    private void shuffle(int[] dirX, int[] dirY) {
        for (int i = 0; i < dirX.length; i++) {
            int rand = (int) (Math.random() * (dirX.length - i));
            swap(dirX, i, i + rand);
            swap(dirY, i, i + rand);
        }
    }

    private void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
    
    public static void main(String[] args) {
        MazeGenerator mazeGenerator = new MazeGenerator();
        int[][] ret = mazeGenerator.maze(7);
        
        for (int[] row : ret) {
            for (int col : row) {
                System.out.print(col + ",");
            }
            System.out.println();
        }
        
    }
}
