package other;

import java.util.TreeSet;

public class Util {
    
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(3);
        set.add(5);
        set.add(9);
        set.add(7);
        System.out.println(set);
        System.out.println(set.higher(2));
        System.out.println(set.higher(8));
    }
}
