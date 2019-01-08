package leetcode.easy.arraystring;

import java.util.Arrays;

/**
 *  Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

	For example,
	Given n = 3,
	
	You should return the following matrix:
	[
	 [ 1, 2, 3 ],
	 [ 8, 9, 4 ],
	 [ 7, 6, 5 ]
	]
 * 
 * @author admin
 *
 */
public class SpiralMatrixII {

	public int[][] generateMatrix(int n) {
		if (n <= 0) {
			return new int[0][0];
		}
		int[][] matrix = new int[n][n];
		int x = 0;
		int y = 0;
		int count = 1;
		while (n > 0) {
			if (n == 1) {
				matrix[x][y] = count;
			}

			for (int i = 0; i < n - 1; i++) {
				matrix[x][y++] = count++;
			}
			for (int i = 0; i < n - 1; i++) {
				matrix[x++][y] = count++;
			}
			for (int i = 0; i < n - 1; i++) {
				matrix[x][y--] = count++;
			}
			for (int i = 0; i < n - 1; i++) {
				matrix[x--][y] = count++;
			}
			n -= 2;
			x++;
			y++;
		}
		return matrix;
	}

	public static void main(String[] args){
		SpiralMatrixII instance = new SpiralMatrixII();
		int[][] matrix = instance.generateMatrix(1);
		int[][] matrix2 = instance.generateMatrix(2);
		int[][] matrix3 = instance.generateMatrix(3);
		System.out.println(Arrays.deepToString(matrix));
		System.out.println(Arrays.deepToString(matrix2));
		System.out.println(Arrays.deepToString(matrix3));
	}
}
