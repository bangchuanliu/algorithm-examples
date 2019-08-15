package chapter2;

import java.math.BigDecimal;

public class Decimal {
    
    public static BigDecimal getDecimal(int a, int b, int c) {
        double quotient = (double) a / (double) b;
        
        return BigDecimal.valueOf(quotient).setScale(c, BigDecimal.ROUND_HALF_UP);
    }
    
    public static void main(String[] args) {
        System.out.println(getDecimal(1,6,4));
    }
}
