package basic;

import java.util.BitSet;

public class SortByBitset {
    public static void main(String[] args) {
        BitSet bits = new BitSet(100);
        int[] nums = {8,7,6, 5, 4, 2, 3};
        
        for (int num : nums) {
            bits.set(num, true);
        }
        
        for (int i = 0; i < bits.length(); i++) {
            if (bits.get(i)) {
                System.out.println(i);
            }    
        }
    }
}
