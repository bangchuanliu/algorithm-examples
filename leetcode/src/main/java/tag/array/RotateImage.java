package tag.array;

import java.util.Arrays;


/**
 * You are given an n x n 2D matrix representing an image.
 * <p>
 * Rotate the image by 90 degrees (clockwise).
 * <p>
 * Follow up:
 * Could you do this in-place?
 *
 * @author admin
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        
        int m = matrix.length;
        for (int i = 0; i < m / 2; i++) {
            for (int j = 0; j < (m + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[m - 1 - j][i];
                matrix[m - 1 - j][i] = matrix[m - 1 - i][m - 1 - j];
                matrix[m - 1 - i][m - 1 - j] = matrix[j][m - 1 - i];
                matrix[j][m - 1 - i] = temp;
            }
        }
    }

    /*
     * 1. rotate clockwise 90
     *
     * 	 matrix[i][j] = matrix[m-1-j][i];
     *
     * 2. rotate clockwise 180
     *
     *  matrix[i][j] = matrix[m-1-i][m-1-j];
     *
     * 3. rotate unclock wise 90
     *  matrix[i][j] = matrix[j][m-1-i];
     *
     * 4. reverse
     *
     *
     */
    public static void main(String[] args) {
        RotateImage instance = new RotateImage();
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        int[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        instance.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(Arrays.deepToString(matrix2));
    }
}
