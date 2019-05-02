package tag.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListUnion {

    public int[][] intervalUnion(int[][] A, int[][] B) {
        int i = 0;
        int j = 0;

        if (A == null) {
            return B;
        }

        if (B == null) {
            return A;
        }

        int[] pre = B[0][0] > A[0][0] ? A[0] : B[0];

        List<int[]> list = new ArrayList<>();

        while (i < A.length && j < B.length) {
            if (A[i][0] < B[j][0]) {
                if (pre[1] >= A[i][0]) {
                    pre[0] = Math.min(pre[0], A[i][0]);
                    pre[1] = Math.max(pre[1], A[i][1]);
                }else {
                    list.add(new int[]{pre[0],pre[1]});
                    pre = A[i];    
                }
                i++;
            }else {
                if (pre[1] >= B[j][0]) {
                    pre[0] = Math.min(pre[0], B[j][0]);
                    pre[1] = Math.max(pre[1], B[j][1]);
                }else {
                    list.add(new int[]{pre[0],pre[1]});
                    pre = B[j];
                }
                j++;
            }
            
        }
        
        while (i < A.length) {
            if (pre[1] >= A[i][0]) {
                pre[0] = Math.min(pre[0], A[i][0]);
                pre[1] = Math.max(pre[1], A[i][1]);
            }else {
                list.add(new int[]{pre[0],pre[1]});
                pre = A[i];
            }
            i++;
        }
        while (j < B.length) {
            if (pre[1] >= B[j][0]) {
                pre[0] = Math.min(pre[0], B[j][0]);
                pre[1] = Math.max(pre[1], B[j][1]);
            }else {
                list.add(new int[]{pre[0],pre[1]});
                pre = B[j];
            }
            j++;
        }
        list.add(new int[]{pre[0],pre[1]});
        int[][] result = new int[list.size()][2];
        for (int k = 0; k < list.size(); k++) {
            result[k] = list.get(k);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        IntervalListUnion intervalListUnion = new IntervalListUnion();
        int[][] A = {{1,2}, {4,8},{9,100}}; 
        int[][] B = {{7,12},{13,15},{16,17},{18,19},{20,21}};

        System.out.println(Arrays.deepToString(intervalListUnion.intervalUnion(A,B)));
    }
}
