package chapter3;

import java.util.HashSet;
import java.util.Set;

public class RepeatingDecimal {
    
    public static String repeatingDecimals(int a, int b) {
        if (a == b || a % b == 0) {
            return String.valueOf(a / b);
        }
        
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        
        if (a > b) {
            sb.append(a / b).append(".");
            a = a % b;
        }else {
            sb.append("0.");
        }
        set.add(a);
        
        while (a % b != 0) {
            sb.append(a * 10 / b);
            a = a * 10 % b;
            if (set.contains(a)) {
                break;
            }else {
                set.add(a);
            }
        }
        
        int dotIndex = sb.indexOf(".");
        
        return sb.substring(0, dotIndex+1) + "(" + sb.substring(dotIndex+1) + ")";
    }
    
    public static void main(String[] args) {
        System.out.println(repeatingDecimals(2,3));
        System.out.println(repeatingDecimals(5,43));
    }
}
