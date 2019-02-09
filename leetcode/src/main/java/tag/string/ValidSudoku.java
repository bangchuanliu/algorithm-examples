package tag.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled with
 * the character '.'.
 * 
 * @author BangChuan Liu <liubangchuan1100@gmail.com>
 *
 * @date Feb 3, 2015
 */
public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		if (board == null || board.length != board[0].length || board.length != 9) {
			return false;
		}
		int length = board.length;
		Set<Character> set = new HashSet<>();

		for (int i = 0; i < length; i++) {
			set.clear();
			for (int j = 0; j < length; j++) {
				if (board[i][j] != '.') {
					if (set.contains(board[i][j])) {
						return false;
					}
					set.add(board[i][j]);
				}
			}
		}

		for (int i = 0; i < length; i++) {
			set.clear();
			for (int j = 0; j < length; j++) {
				if (board[j][i] != '.') {
					if (set.contains(board[j][i])) {
						return false;
					}
					set.add(board[j][i]);
				}
			}
		}

		for (int i = 0; i < length; i += 3) {
			for (int j = 0; j < length; j += 3) {
				set.clear();
				for (int m = i; m < i + 3; m++) {
					for (int n = j; n < j + 3; n++) {
						if (board[m][n] != '.') {
							if (set.contains(board[m][n])) {
								return false;
							}
							set.add(board[m][n]);
						}
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		char[][] sudo = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		char[][] sudo2 = { { '.', '.', '4', '.', '.', '.', '.', '6', '3' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '5', '.', '.', '.', '.', '.', '.', '9', '.' },
				{ '.', '.', '.', '5', '6', '.', '.', '.', '.' }, { '4', '.', '3', '.', '.', '.', '.', '.', '1' },
				{ '.', '.', '.', '7', '.', '.', '.', '.', '.' }, { '.', '.', '.', '5', '.', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.', '.' } };
		ValidSudoku instance = new ValidSudoku();
		System.out.println(instance.isValidSudoku(sudo2));

	}
}
