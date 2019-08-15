package chapter3.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Light {
    
    public static List<Integer> switchLight(int lights, int k) {
        if (lights <= 0 || k <= 0) {
            return new ArrayList<>();
        } 
        
        boolean[] light = new boolean[lights+1];
        List<Integer> result = new ArrayList<>();
        
        for (int i = 1; i <= k; i++) {
            for (int j = i ; j < light.length; j = j+ i) {
                light[j] = !light[j];
            }
        }
        
        for (int i = 1; i < light.length; i++) {
            if (light[i]) {
                result.add(i);
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(switchLight(7,3).toArray()));
    }
}
