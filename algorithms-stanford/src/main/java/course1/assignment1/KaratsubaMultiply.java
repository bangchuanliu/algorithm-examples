package course1.assignment1;

import java.math.BigInteger;

public class KaratsubaMultiply {

    /**
     * prerequisite: |la - lb| <=1
     */
    public static String multiply(String a, String b) {
        if (a.length() <= 1 || b.length() <= 1) {
            return String.valueOf(Integer.parseInt(a) * Integer.parseInt(b));
        }
        
        int mid = a.length() / 2;
        int mid2 = b.length() / 2;
        String leftA = a.substring(0, mid);
        String rightA = a.substring(mid);
        String leftB = b.substring(0, mid2);
        String rightB = b.substring(mid2);

        String F = multiply(leftA, leftB);
        String G = multiply(rightA, rightB);
        String sumA = new BigInteger(leftA).add(new BigInteger(rightA)).toString();
        String sumB = new BigInteger(leftB).add(new BigInteger(rightB)).toString();
        String H = multiply(sumA, sumB);
        String K = new BigInteger(H).subtract(new BigInteger(F)).subtract(new BigInteger(G)).toString();
        String result = new BigInteger(F).multiply(new BigInteger("10").pow(rightA.length() + rightB.length())).add(new BigInteger(K).multiply(new BigInteger("10").pow((rightA.length() + rightB.length()) / 2)).add(new BigInteger(G))).toString();
        return result;
    }

    public static void main(String[] args) {
        String a = "3141592653589793238462643383279502884197169399375105820974944592";
        String b = "2718281828459045235360287471352662497757247093699959574966967627";
        String result = multiply(a, b);
        String test1 = multiply("4867", "1");  //4687
        String test2 = multiply("121", "121"); //14641

        System.out.println(result);
        System.out.println(test1);
        System.out.println(test2);
    }
}
