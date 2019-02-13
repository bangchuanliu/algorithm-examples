package tag.array;

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
        boolean fr = false;
        boolean fc = false;

        // set first row and column zero or not
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                fc = true;
                break;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                fr = true;
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
        if (fc) {
            for (int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
        }

        if (fr) {
            for (int i = 0; i < matrix[0].length; i++)
                matrix[0][i] = 0;
        }
	}

	public static void main(String[] args) {
		SetMatrixZeroes instance = new SetMatrixZeroes();
		int[][] matrix = { { 0,1, 2, 0 },{3,4,5,2} ,{ 1,3, 1, 5 } };
		instance.setZeroes(matrix);
		System.out.println(Arrays.deepToString(matrix));
	}
}
