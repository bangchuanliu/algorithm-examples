package chapter4;

import java.util.Arrays;

public class AncientCipher {
    
    public static void main(String[] args) {
        char[] a = "JPWUDJSTVP".toCharArray();
        char[] b = "VICTORIOUS".toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        System.out.println(new String(a));
        System.out.println(new String(b));
    }
}
