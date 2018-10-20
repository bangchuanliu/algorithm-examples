package leetcode.backtracking;

import java.util.HashSet;
import java.util.Set;

public class SudokuSolver {
	public void solveSudoku(char[][] board) {
		helper(board, 0, 0);
	}

	public boolean helper(char[][] board, int i, int j) {
		if (j >= 9)
			return helper(board, i + 1, 0);
		if (i == 9) {
			return true;
		}
		if (board[i][j] == '.') {
			for (int k = 1; k <= 9; k++) {
				board[i][j] = (char) (k + '0');
				if (isValid(board, i, j)) {
					if (helper(board, i, j + 1))
						return true;
				}
				board[i][j] = '.';
			}
			return false;
		} else {
			return helper(board, i, j + 1);
		}
	}

	public boolean isValid(char[][] board, int i, int j) {
		Set<Character> set = new HashSet<>();

		for (int k = 0; k < 9; k++) {
			if (set.contains(board[i][k])) {
				return false;
			} else if (Character.isDigit(board[i][k])) {
				set.add(board[i][k]);
			}
		}

		set.clear();
		for (int k = 0; k < 9; k++) {
			if (set.contains(board[k][j])) {
				return false;
			} else if (Character.isDigit(board[k][j])) {
				set.add(board[k][j]);
			}
		}

		set.clear();
		for (int m = i / 3 * 3; m < i / 3 * 3 + 3; m++) {
			for (int n = j / 3 * 3; n < j / 3 * 3 + 3; n++) {
				if (set.contains(board[m][n])) {
					return false;
				} else if (Character.isDigit(board[m][n])) {
					set.add(board[m][n]);
				}
			}
		}
		return true;
	}
}
