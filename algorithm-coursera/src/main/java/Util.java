import np.assignment2.Point;

import java.math.BigDecimal;
import java.util.BitSet;
import java.util.Random;

public class Util {
    
    public static void main(String[] args) {
//        BitSet bitSet1 = new BitSet(4);
//        bitSet1.set(0);
//        bitSet1.set(2);
//        BitSet bitSet2 = new BitSet(4);
//        bitSet2.set(0);
//        bitSet2.set(2);
//        System.out.println(bitSet1.length());
//        System.out.println(bitSet1.size());
//        System.out.println(bitSet1.cardinality());
//        System.out.println(bitSet1);
//        System.out.println(bitSet1.equals(bitSet2));
//        
//        System.out.println(Integer.MAX_VALUE);

        Random random  = new Random();
        for (int i = 1; i <= 10; i++) {
                
        }
        BigDecimal d1 = new BigDecimal(10);
        BigDecimal d2 = d1.subtract(new BigDecimal((2)));
        System.out.println(d1);
        System.out.println(d2);

        Point p1 = new Point(24166.6667d, 13250.0000);
        Point p2 = new Point(23883.3333, 14533.3333);
        System.out.println(p1.dist(p2));
    }
}
