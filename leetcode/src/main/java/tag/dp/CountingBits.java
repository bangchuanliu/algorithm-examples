package tag.dp;

/**
 * @date Feb,10 2019
 */
public class CountingBits {

    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;
        
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 1) {
                result[i] = result[i - 1] + 1;
            } else {
                result[i] = result[i / 2];
            }
        }

        return result;
    }
}
