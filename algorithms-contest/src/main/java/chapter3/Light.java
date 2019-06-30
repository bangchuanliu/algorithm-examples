package chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Light {
    
    public static List<Integer> switchLight(boolean[] lights, int k) {
        if (k <= 0) {
            return new ArrayList<>();
        }
        for (int i = 1; i <= k; i++) {
            for (int j = i; j < lights.length; j = j+i) {
                lights[j] = !lights[j];
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        for (int i = 1; i < lights.length; i++) {
            if (lights[i]) {
                result.add(i);
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        boolean[] lights = new boolean[8];
        System.out.println(Arrays.toString(switchLight(lights,3).toArray()));
    }
}
