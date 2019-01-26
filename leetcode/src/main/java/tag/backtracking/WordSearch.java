package tag.backtracking;

public class WordSearch {

	public boolean exist(char[][] board, String word) {
		if (board == null || word == null) {
			return false;
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				boolean[][] used = new boolean[board.length][board[0].length];
				used[i][j] = true;
				StringBuilder sb = new StringBuilder();
				sb.append(board[i][j]);
				if (exist(board, word, i, j, sb, used)) {
					return true;
				}
			}
		}

		return false;
	}

	public boolean exist(char[][] board, String word, int i, int j, StringBuilder newWord, boolean[][] used) {

		boolean result = false;
		
		if (newWord.length() < word.length()) {
			if (!word.startsWith(newWord.toString())) {
				return false;
			}
		} else {
			return word.endsWith(newWord.toString());
		}

		if (i > 0 && used[i - 1][j] == false) {
			newWord.append(board[i - 1][j]);
			used[i - 1][j] = true;
			result = exist(board, word, i - 1, j, newWord, used);
			used[i - 1][j] = false;
			newWord.deleteCharAt(newWord.length() - 1);
		}

		if (result == true) {
			return true;
		}
		
		if (i < board.length - 1 && used[i + 1][j] == false) {
			newWord.append(board[i + 1][j]);
			used[i + 1][j] = true;
			result = exist(board, word, i + 1, j, newWord, used);
			used[i + 1][j] = false;
			newWord.deleteCharAt(newWord.length() - 1);
		}

		if (result == true) {
			return true;
		}
		
		if (j < board[0].length - 1 && used[i][j + 1] == false) {
			newWord.append(board[i][j + 1]);
			used[i][j + 1] = true;
			result = exist(board, word, i, j + 1, newWord, used);
			used[i][j + 1] = false;
			newWord.deleteCharAt(newWord.length() - 1);
		}

		if (result == true) {
			return true;
		}
		
		if (j > 0 && used[i][j - 1] == false) {
			newWord.append(board[i][j - 1]);
			used[i][j - 1] = true;
			result = exist(board, word, i, j - 1, newWord, used);
			used[i][j - 1] = false;
			newWord.deleteCharAt(newWord.length() - 1);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'}, {'A','D','E','E'}};
		WordSearch instance = new WordSearch();
		System.out.println(instance.exist(board,"ABCCED"));
		System.out.println(instance.exist(board,"SEE"));
		System.out.println(instance.exist(board,"ABCB"));
	}
}
