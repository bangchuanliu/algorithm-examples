package tag.random;

import java.util.Random;

public class RandomPickwithWeight {

    int[] p;
    int[] w;
    Random ran = new Random();

    public RandomPickwithWeight(int[] w) {
        this.w = w;
        p = new int[w.length];
        p[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            p[i] = p[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        int sum = p[p.length - 1];
        int num = ran.nextInt(sum);
        int i = 0;
        int j = p.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (num >= p[mid]) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3};
        RandomPickwithWeight solution = new RandomPickwithWeight(nums);
        System.out.println(solution.pickIndex());

    }
}
