package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Util {
    
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(3);
        set.add(5);
        set.add(9);
        set.add(7);
//        System.out.println(set);
//        System.out.println(set.higher(2));
//        System.out.println(set.higher(8));
//        System.out.println(set.headSet(5));
//        System.out.println(set.tailSet(5));
        
//        String s = "a.b.c.d";
//        
//        System.out.println(s.substring(2,2));
//        System.out.println(s.split("\\.").length);
        
//        System.out.println(Math.sqrt(1000));
//        System.out.println(Math.floor(Math.sqrt(1000)));


        Util util = new Util();
        System.out.println(Arrays.toString(util.restoreIpAddresses("25525511135").toArray()));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        restoreIpAddresses(result, s, "");

        return result;
    }


    public void restoreIpAddresses(List<String> result, String s, String temp) {
        if (temp.split("\\.").length > 4) {
            return;
        }
        if (s.length() == 0 && temp.split("\\.").length == 4) {
            result.add(temp.substring(0, temp.length()-1));
            return;
        }

        for (int i = 1; i <= s.length() && i <= 3; i++) {
            String subs = s.substring(0,i);
            if (i == 1 || (i > 1 && subs.charAt(0) != '0' && Integer.parseInt(subs) < 256)) {
                restoreIpAddresses(result, s.substring(i),temp + subs + ".");
            }
        }
    }
}
