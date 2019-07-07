package chapter3;

import java.util.HashMap;
import java.util.Map;

public class MolarMass {
    
    public static double molarQuality(String input) {
        if (input == null || input.length() == 0) {
            return 0.0;
        }
        
        Map<Character, Double> map = new HashMap<>();
        map.put('C', 12.01);
        map.put('H', 1.008);
        map.put('O', 16.00);
        map.put('N', 14.01);
        
        double sum = 0;
        
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                double quality = map.get(input.charAt(i));
                int num = 0;
                while (i + 1 < input.length() && Character.isDigit(input.charAt(i+1))) {
                    num = num * 10 + (input.charAt(i+1) - '0');
                    i++;
                }
                sum += num == 0 ? quality : quality * num;
            }
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        System.out.println(molarQuality("C6H5OH"));
        System.out.println(molarQuality("C12H3"));
    }
}
