package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Util {

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();


        treeSet.add(1);
        treeSet.add(3);
        treeSet.add(5);
        treeSet.add(7);
        treeSet.add(9);
        
        System.out.println(Arrays.toString(treeSet.tailSet(4).toArray()));
        System.out.println(Arrays.toString(treeSet.tailSet(5).toArray()));
    }

   
    
}
