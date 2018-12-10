package divideandconquer;

public class KaratsubaMultiply {

    /**
     * Karatsuba algorithm
     */
    public static int[] multiply(int[] a, int[] b) {
        c = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            x[i] = a[i];
        }
        for (int i = 0; i < a.length; i++) {
            y[i] = b[i];
        }
        multiplyRecursive(a, b, c, 0, a.length - 1);
//        int carry = 0;
//        for (int i = c.length - 1; i >= 0; i--) {
//            int temp = c[i] + carry;
//            c[i] = temp % 10;
//            carry = temp / 10;
//        }
        return c;
    }


    public static int[] add(int[] a, int[] b) {
        int[] c = new int[a.length + 1];
        int carry = 0;
        for (int i = a.length - 1; i >=0; i--) {
            int temp = a[i] + b[i]+ carry;
            c[high] = temp % 10;
            carry = temp / 10;
        }
        c[high] = c[high] + carry;
    }

    public static void subtract(int[] a, int[] b) {
        int carry = 0;
        for (; high >= low; high--) {
            int temp = c[high] + carry;
            c[high] = temp % 10;
            carry = temp / 10;
        }
        c[high] = c[high] + carry;
    }
    
    

    /**
     * assume length is 2^n
     **/
    public static int[] multiplyRecursive(int[] a, int[] b) {
        if (a.length == 1) {
            int[] result = new int[1];
            result[0] = a[0] * b[0];
//            carry(c, 1, 1);
            return result;
        }
        int mid = a.length / 2;
        int[] leftA = new int[mid];
        int[] rightA = new int[mid];
        int[] leftB = new int[mid];
        int[] rightB = new int[mid];

        System.arraycopy(a, 0, leftA, 0, mid);
        System.arraycopy(a, 0, rightA, mid, mid);
        System.arraycopy(b, 0, leftB, 0, mid);
        System.arraycopy(b, 0, rightB, 0, mid);

        int[] sumA = new int[leftA.length];
        int[] sumB = new int[leftB.length];
        for (int i = 0; i < sumA.length; i++) {
            sumA[i] = leftA[i] + rightA[i];
        }

        for (int i = 0; i < sumB.length; i++) {
            sumB[i] = leftB[i] + rightB[i];
        }
        
        int[] F = multiplyRecursive(leftA, leftB);
        int[] G = multiplyRecursive(rightA, rightB);
        int[] H = multiplyRecursive(sumA, sumB);
        int K = convertToInt(H) - convertToInt(F) - convertToInt(G);
        
        int[] c = new int[a.length + b.length];
        
        
        System.arraycopy(F,0,c,1,);
        

        
    }

    public static int convertToInt(int[] a) {
        int sum = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            sum = sum * 10 + a[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a = {9, 9};
        int[] b = {9, 9};
        int[] c = multiply(a, b);

        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i]);
        }
        System.out.println();
    }
}
