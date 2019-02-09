package tag.queue;

import java.util.LinkedList;

public class ShortestSubarraywithSumatLeastK {

    public int shortestSubarray(int[] A, int K) {
        int[] sums = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            sums[i + 1] = sums[i] + A[i];
        }

        int res = Integer.MAX_VALUE;
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < sums.length; i++) {
            
            while (!q.isEmpty() && sums[i] < sums[q.getLast()]) {
                q.removeLast();
            }
            
            while (!q.isEmpty() && sums[i] - sums[q.peek()] >= K) {
                res = Math.min(res, i - q.peek());
                q.removeFirst();
            }
            q.addLast(i);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    public static void main(String[] args) {
        int[] A = {84,-37,32,40,95};
        ShortestSubarraywithSumatLeastK instance = new ShortestSubarraywithSumatLeastK();
        System.out.println(instance.shortestSubarray(A, 167));
    }
}
