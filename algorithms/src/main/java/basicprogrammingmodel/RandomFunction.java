package basicprogrammingmodel;

import java.util.Arrays;

public class RandomFunction {

    public static double uniform(double a, double b) {
        return a + Math.random() * (b - a);
    }

    public static int uniform(int a) {
        return (int) (Math.random() * a);
    }

    public static int uniform(int a, int b) {
        return a + uniform(b - a);
    }

    public static int discrete(double[] a) {
        double r = Math.random();
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (sum >= r) {
                return i;
            }
        }
        return -1;
    }

    public static void shuffle(int[] a) {
        for(int i = 0; i < a.length; i++) {
            int r = uniform(a.length - i);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        System.out.println(uniform(8.0, 12.0));
        System.out.println(uniform(8));
        System.out.println(uniform(8, 12));
        shuffle(a);
        System.out.println(Arrays.toString(a));
    }
}
