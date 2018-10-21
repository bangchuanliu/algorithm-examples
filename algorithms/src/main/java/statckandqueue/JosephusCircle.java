package statckandqueue;

public class JosephusCircle {

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int M = Integer.parseInt(args[1]);

        boolean[] circle = new boolean[N];
        int count = 0;
        int remain = N;
        while (remain > 0) {
            for (int i = 0; i < N; i++) {
                if (!circle[i]) {
                    count++;
                    if (count == M) {
                        circle[i] = true;
                        System.out.print(i + " ");
                        remain--;
                        count = 0;
                    }
                }
            }
        }
    }
}
