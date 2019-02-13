package tag.dp;

/**
 * @author bliu13 Dec 10, 2015
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0, idx = 1;
        while (idx < n) {
            res[idx] = Math.min(res[t2] * 2, Math.min(res[t3] * 3, res[t5] * 5));
            t2 += res[idx] == res[t2] * 2 ? 1 : 0;
            t3 += res[idx] == res[t3] * 3 ? 1 : 0;
            t5 += res[idx] == res[t5] * 5 ? 1 : 0;
            ++idx;
        }
        return res[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new UglyNumberII().nthUglyNumber(10));
    }
}
