package chapter7;

import java.util.Arrays;

public class Queues {
    public static void main(String[] args) {
        int[] c = new int[8];
        search(0, 8, c);
        System.out.println(count);
    }
    static int count = 0;
    public static void search(int r, int n, int[] c) {
        if (r == n) {
            count++;
            System.out.println(Arrays.toString(c));
            return;
        }
        
        for (int i = 0; i < n; i++) {
            c[r] = i;
            if (isValid(r, c)) {
                search(r + 1, n, c);
            }
        }
    }
    
    public static boolean isValid(int r, int[] c) {
        for (int i = 0; i < r; i++) {
            if (c[i] == c[r] || c[r] == c[i] - (r - i) || c[r] == c[i] + (r-i)){
                return false;
            }
        }
        
        return true;
    }
}
