package tag.string;

import java.util.HashSet;
import java.util.Set;

public class NextClosestTime {
    public String nextClosestTime(String time) {
        int cur = Integer.parseInt(time.substring(0,2)) * 60;
        cur += Integer.parseInt(time.substring(3,5));

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < time.length(); i++) {
            if (time.charAt(i) != ':')
                set.add(time.charAt(i) - '0');
        }

        while(true) {
            cur = (cur + 1) % (24 * 60);
            int h1 = cur / 60 / 10;
            int h2 = cur / 60 % 10;
            int m1 = cur % 60 / 10;
            int m2 = cur % 60 % 10;

            if (set.contains(h1) && set.contains(h2) && set.contains(m1) && set.contains(m2)) {
                return h1 + "" + h2 + ":" + m1 + "" + m2;
            }
        }
        
        
    }

    public static void main(String[] args) {
        NextClosestTime nextClosestTime = new NextClosestTime();
        System.out.println(nextClosestTime.nextClosestTime("23:59"));
    }
}
