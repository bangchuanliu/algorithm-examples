package chapter4.example;

public class DoleQueue {

    public static void doleQueue(int n, int k, int m) {
        boolean[] p = new boolean[n];
        int left = n;
        int i = 0;
        int j = p.length;

        while (left > 0) {
            i = go(p, i, 1, k);
            j = go(p, j, -1, m);

            left--;
            System.out.print((i) + " ");
            if (i != j) {
                left--;
                System.out.print(j + 1);
            }
            p[i] = true;
            p[j] = true;

            System.out.println();
        }
    }

    public static int go(boolean[] p, int i, int d, int step) {
        while (step-- > 0) {
            do {
               i = (i + d + p.length) % p.length;  
            }while(p[i]);
        }
        return i;
    }

    public static void main(String[] args) {
        doleQueue(10, 4, 3);
    }
}
