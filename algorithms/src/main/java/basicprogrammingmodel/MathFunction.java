package basicprogrammingmodel;

public class MathFunction {


    public double sqrt(int a, double low, double high) {
        double ebusilon = 1e-15;
        double c = low + (high - low) / 2.0;
        double diff = Math.abs(c * c - a);
        if ( diff < ebusilon) {
            return c;
        } else if (c * c < a) {
            return sqrt(a, c + 1, high);
        } else {
            return sqrt(a, low, c - 1);
        }
    }


    public double sqrt(double a) {
        if (a < 0) return Double.NaN;
        double ebusilon = 1e-15;
        double t = a;
        while (Math.abs(t - a / t) > ebusilon * t) {
            t = (a / t + t) / 2.0;
        }
        return t;
    }


    public static void main(String[] args) {
        MathFunction mathFunction = new MathFunction();
        System.out.println(mathFunction.sqrt(16, 0.0, 16.0));
        System.out.println(Math.sqrt((16)));
    }
}
