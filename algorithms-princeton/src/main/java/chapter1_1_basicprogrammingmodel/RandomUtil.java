package chapter1_1_basicprogrammingmodel;

import java.util.Arrays;
import java.util.Random;

public class RandomUtil {

    private static Random random = new Random();

    public static double uniform(double a, double b) {
        return a + Math.random() * (b - a);
    }

    public static int uniform(int a) {
        return random.nextInt(a);
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

    public static <Item> void shuffle(Item[] a) {
        for (int i = 0; i < a.length; i++) {
            int r = uniform(a.length - i);
            Item temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(uniform(8.0, 12.0));
        System.out.println(uniform(8));
        System.out.println(uniform(8, 12));
        RandomUtil.shuffle(a);
        System.out.println(Arrays.toString(a));

        Random random = new Random();
        int[] b = new int[32];
        for (int i = 0; i < 32; i++) {
            b[i] = random.nextInt(32);
        }
        Arrays.sort(b);
        System.out.print(Arrays.toString(b));
        
        //double[] doubles = random.doubles(1, 10).toArray();
        //System.out.println(doubles.length);
                
    }
}
