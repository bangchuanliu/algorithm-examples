package divideandconquer;

public class GradeSchoolMultiply {

    /**
     * grade school algorithm
     */
    public static int[] multiply(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int k = c.length - 1;
        for (int i = a.length - 1; i >= 0; i--) {
            int x = k;
            for (int j = b.length - 1; j >= 0; j--) {
                int prod = a[i] * b[j];
                c[x] = c[x] + prod;
                x--;
            }
            k--;
        }
        int carry = 0;
        for (int i = c.length - 1; i >= 0; i--) {
            int temp = c[i] + carry;
            c[i] = temp % 10;
            carry = temp / 10;
        }
        return c;
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9, 3, 2, 3, 8, 4, 6, 2, 6, 4, 3, 3, 8, 3, 2, 7, 9, 5, 0, 2, 8, 8, 4, 1, 9, 7, 1, 6, 9, 3, 9, 9, 3, 7, 5, 1, 0, 5, 8, 2, 0, 9, 7, 4, 9, 4, 4, 5, 9, 2};
        int[] b = {2, 7, 1, 8, 2, 8, 1, 8, 2, 8, 4, 5, 9, 0, 4, 5, 2, 3, 5, 3, 6, 0, 2, 8, 7, 4, 7, 1, 3, 5, 2, 6, 6, 2, 4, 9, 7, 7, 5, 7, 2, 4, 7, 0, 9, 3, 6, 9, 9, 9, 5, 9, 5, 7, 4, 9, 6, 6, 9, 6, 7, 6, 2, 7};
        int[] c = multiply(a, b);

        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i]);
        }
    }
}
