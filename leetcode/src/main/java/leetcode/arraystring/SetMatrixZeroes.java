package leetcode.arraystring;

import java.util.Arrays;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in place.
 * 
 * @author admin
 *
 */
public class SetMatrixZeroes {

	public void setZeroes(int[][] matrix) {
		if (matrix == null || matrix[0] == null) {
			return;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[][] temp = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					temp[i][j] = true;
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (temp[i][j] == true) {
					for (int x = 0; x < n; x++) {
						matrix[i][x] = 0;
					}
					for (int y = 0; y < m; y++) {
						matrix[y][j] = 0;
					}
				}
			}
		}
	}

	public void setZeroes2(int[][] matrix) {
		boolean firstRowZero = false;
		boolean firstColumnZero = false;

		// set first row and column zero or not
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				firstColumnZero = true;
				break;
			}
		}

		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0) {
				firstRowZero = true;
				break;
			}
		}

		// mark zeros on first row and column
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		// use mark to set elements
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		// set first column and row
		if (firstColumnZero) {
			for (int i = 0; i < matrix.length; i++)
				matrix[i][0] = 0;
		}

		if (firstRowZero) {
			for (int i = 0; i < matrix[0].length; i++)
				matrix[0][i] = 0;
		}
	}

	public static void main(String[] args) {
		SetMatrixZeroes instance = new SetMatrixZeroes();
		int[][] matrix = { { 1, 2, 3 }, { 4, 0, 6 } };
		instance.setZeroes(matrix);
		System.out.println(Arrays.deepToString(matrix));
	}
}
