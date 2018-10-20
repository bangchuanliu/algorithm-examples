package leetcode.diveconquer;

/**
 * 
 * @author bliu13 Dec 10, 2015
 */
public class Searcha2DMatrixII {

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}

		int row = matrix.length;
		int column = matrix[0].length;

		int i = 0;
		int j = column - 1;

		while (i < row && j >= 0) {
			if (target < matrix[i][j]) {
				j--;
			} else if (target > matrix[i][j]) {
				i++;
			} else {
				return true;
			}
		}
		
		return false;
	}
}
