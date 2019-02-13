package tag.dp;

public class RangeSumQuery2D {

	private int[][] matrix;
	private int[][] sums;

	public RangeSumQuery2D(int[][] matrix) {
		this.matrix = matrix;
		if (matrix != null && matrix.length != 0) {
			int m = matrix.length;
			int n = matrix[0].length;
			
			sums = new int[m + 1][n + 1]; 
			
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					sums[i+1][j+1] = matrix[i][j] + sums[i][j+1] + sums[i+1][j] - sums[i][j];
				}
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		return sums[row2+1][col2+1] + sums[row1][col1] - sums[row2+1][col1] - sums[row1][col2+1];
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
		RangeSumQuery2D instance = new RangeSumQuery2D(matrix);
		instance.sumRegion(2, 1, 4, 3);
		instance.sumRegion(1, 1, 2, 2);
		instance.sumRegion(1, 2, 2, 4);
	}
}
