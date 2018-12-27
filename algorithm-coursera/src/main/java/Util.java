import java.util.BitSet;

public class Util {
    
    public static void main(String[] args) {
        BitSet bitSet1 = new BitSet(4);
        bitSet1.set(0);
        bitSet1.set(2);
        BitSet bitSet2 = new BitSet(4);
        bitSet2.set(0);
        bitSet2.set(2);
        System.out.println(bitSet1.length());
        System.out.println(bitSet1.size());
        System.out.println(bitSet1.cardinality());
        System.out.println(bitSet1);
        System.out.println(bitSet1.equals(bitSet2));
    }
}
