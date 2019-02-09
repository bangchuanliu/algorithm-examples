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
        System.out.println(set.headSet(5));
        System.out.println(set.tailSet(5));
        
//        System.out.println(Math.sqrt(1000));
//        System.out.println(Math.floor(Math.sqrt(1000)));
        
    }
}
