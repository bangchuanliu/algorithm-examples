package tag.hashtable;

import java.util.Arrays;

public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) {
            return new int[0][0];
        }

        boolean[] zeroA = new boolean[A.length];
        boolean[] zeroB = new boolean[B[0].length];

        Arrays.fill(zeroA, true);
        Arrays.fill(zeroB, true);

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] != 0) {
                    zeroA[i] = false;
                    break;
                }
            }
        }
        for (int j = 0; j < B[0].length; j++) {
            for (int i = 0; i < B.length; i++) {
                if (B[i][j] != 0) {
                    zeroB[j] = false;
                    break;
                }
            }
        }

        int[][] C = new int[A.length][B[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                if (!zeroA[i] && !zeroB[j]) {
                    for (int k = 0; k < A[0].length; k++) {
                        C[i][j] += A[i][k] * B[k][j];
                    }
                }

            }
        }

        return C;
    }
}
