package tag.backtracking;

/**
 * 79. Word Search
 * <p>
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * <p>
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 */

public class WordSearch {

    int[][] offsets = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] used = new boolean[board.length][board[0].length];
                if (exist(board, word, i, j, used, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean exist(char[][] board, String word, int i, int j, boolean[][] used, int index) {
        if (word.charAt(index) != board[i][j]) {
            return false;
        }

        if (index + 1 == word.length()) {
            return true;
        }
        used[i][j] = true;

        for (int[] offset : offsets) {
            int x = i + offset[0];
            int y = j + offset[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[x].length && !used[x][y]) {
                used[x][y] = true;
                if (exist(board, word, x, y, used, index + 1)) {
                    return true;
                }
                used[x][y] = false;
            }
        }
        used[i][j] = false;

        return false;
    }

    public boolean dfs(char[][] board, String word, String temp, int i, int j, boolean[][] seen) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || seen[i][j]) {
            return false;
        }

        temp = temp + board[i][j];

        if (temp.length() > word.length()) {
            return false;
        }

        if (temp.equals(word)) {
            return true;
        }


        seen[i][j] = true;

        boolean up = dfs(board, word, temp, i - 1, j, seen);
        boolean down = dfs(board, word, temp, i + 1, j, seen);
        boolean left = dfs(board, word, temp, i, j - 1, seen);
        boolean right = dfs(board, word, temp, i, j + 1, seen);

        seen[i][j] = false;

        return up || down || left || right;

    }

    public boolean dfs(char[][] board, String word, int index, int i, int j, boolean[][] seen) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || seen[i][j]) {
            return false;
        }

        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        if (index + 1 == word.length()) {
            return true;
        }


        seen[i][j] = true;

        if (dfs(board, word, index + 1, i - 1, j, seen)) {
            return true;
        }

        if (dfs(board, word, index + 1, i + 1, j, seen)) {
            return true;
        }

        if (dfs(board, word, index + 1, i, j - 1, seen)) {
            return true;
        }

        if (dfs(board, word, index + 1, i, j + 1, seen)) {
            return true;
        }


        seen[i][j] = false;

        return false;

    }

    public static void main(String[] args) {
//        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        char[][] board = {{'a'}};
        WordSearch instance = new WordSearch();
        System.out.println(instance.exist(board, "ABCCED"));
        System.out.println(instance.exist(board, "SEE"));
        System.out.println(instance.exist(board, "ABCB"));
        System.out.println(instance.exist(board, "a"));
    }
}
