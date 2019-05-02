package other;

import java.math.BigInteger;
import java.util.PriorityQueue;

public class Util {

    public static void main(String[] args) {

        PriorityQueue<Integer> q = new PriorityQueue<>();
        BigInteger id = BigInteger.valueOf(13866763745L).shiftLeft(23);
        id = id.or(BigInteger.valueOf(1341 <<(64-41-13)));
        
        System.out.println(id);

        System.out.println(2 << 10);
    }

    static int minimumDistance(String[] array, String word1, String word2) {

        int s = -1;
        int e = -1;

        int r = array.length;
        boolean isSame = false;
        if (word1.equals(word2)) {
            isSame = true;
        }

        for (int i = 0; i < array.length; i++) {

            if (isSame && array[i].equals(word1)) {
                if (s != -1) {
                    r = Math.min(r, Math.abs(s-i));
                }
                s = i;
            } else {
                if (array[i].equals(word1)) {
                    s = i;
                } else if (array[i].equals(word2)) {
                    e = i;
                }
                if (s != -1 && e != -1) {
                    r = Math.min(r, Math.abs(s-e));
                }
            }
        }
        return r;
    }
}

