package tag.backtracking;

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
