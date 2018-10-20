package leetcode.binarysearch;


/**
 * 
 * @author bliu13 Jan 10, 2016
 */
public class Searcha2DMatrix {
	
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) {
			return false;
		}
		
		int m = matrix.length;
		int n = matrix[0].length;
		
		int start = 0;
		int end = m * n - 1;
		
		while (start <= end) {
			int mid = end - (end - start) / 2;
			
			int i = mid / n;
			int j = mid % n;
			
			if (matrix[i][j] < target) {
				start = mid + 1;
			} else if (matrix[i][j] > target) {
				end = mid - 1;
			} else {
				return true;
			}
		}
		
		return false;
	}
}
