package chapter6;

public class DroppingBalls {
    public static void main(String[] args) {
        System.out.println(drop(4, 2));
        System.out.println(drop(3, 4));
        System.out.println(drop(10, 1));
        System.out.println(drop(2, 2));
        System.out.println(drop(8, 128));


        System.out.println(drop2(4, 2));
        System.out.println(drop2(3, 4));
        System.out.println(drop2(10, 1));
        System.out.println(drop2(2, 2));
        System.out.println(drop2(8, 128));
    }

    public static int drop(int height, int num) {
        int maxHeight = 20;
        boolean[] s = new boolean[1 << maxHeight];
        int k = 1;
        int n = (1 << height) - 1;
        for (int i = 0; i < num; i++) {
            k = 1;
            while (k <= n) {
                s[k] = !s[k];
                k = s[k] ? 2 * k : 2 * k + 1;
            }
        }

        return k / 2;
    }

    public static int drop2(int height, int num) {
        int k = 1;
        
        for (int i = 0; i < height - 1; i++){
            if (num % 2 == 0) {
                k = 2 * k + 1;
                num = num / 2;
            }else {
                k = 2 * k;
                num = (num + 1) / 2;
            }
        }
        return k;
    }
}
