package company.airbnb;

import java.util.ArrayList;
import java.util.List;

public class IPTOCIDR {

    public static List<String> ipToCIDR(String ip, int n) {
        List<String> result = new ArrayList<>();
        long num = ipToLong(ip);

        while (n > 0) {
            int mask = Math.max(33 - bitLen(Long.lowestOneBit(num)), 33 - bitLen(n));
            result.add(longToIp(num) + "/" + mask);
            num += 1 << (32 - mask);
            n -= 1 << (32 - mask);
        }

        return result;
    }

    public static String longToIp(long x) {
        return String.format("%s.%s.%s.%s",
                x >> 24, (x >> 16) % 256, (x >> 8) % 256, x % 256);
    }

    public static long ipToLong(String ip) {
        long num = 0;
        for (String str : ip.split("\\.")) {
            num = num * 256 + Long.parseLong(str);
        }
        return num;
    }

    public static int bitLen(long x) {
        if (x == 0) return 1;
        int ans = 0;
        while (x > 0) {
            x >>= 1;
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Long.lowestOneBit(ipToLong("255.0.0.8")));
        System.out.println((ipToCIDR("255.0.0.7", 10)));
    }
}
