package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Util {

    public static void main(String[] args) {
        int[][] edges ={{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        
        Map<String ,List<String>> map = new HashMap<>();
        
        map.computeIfAbsent("aaa", v -> new ArrayList<>()).add("a");
    }

    
}
