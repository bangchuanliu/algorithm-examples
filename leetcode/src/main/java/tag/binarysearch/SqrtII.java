package tag.binarysearch;

public class SqrtII {

    public double mySqrt(double x, double ebsl) {

        if (x <= 0) {
            return 0;
        }
        
        double guess = x / 2; 
        while (Math.abs(guess - x / guess) > ebsl) {
            guess = (guess + x / guess) / 2;
        }

        return guess;
    }

    public static void main(String[] args) {
        SqrtII instance = new SqrtII();
        System.out.println(instance.mySqrt(0.01, 0.0000001));
    }
}
