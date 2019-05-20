package other;

import java.util.concurrent.atomic.AtomicInteger;

public class Util {

    public static void main(String[] args) {
        Util util = new Util();
        
        System.out.println(util.oneValidString("())"));
        
        System.out.println(System.currentTimeMillis());

        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println(atomicInteger.incrementAndGet());
        System.out.println(atomicInteger.incrementAndGet());

    }
    
    
    public String oneValidString(String s) {
        int left = 0;
        int right = 0;
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
                sb.append(c);
            }else if (c == ')') {
                if (left > 0) {
                    left--;
                    sb.append(c);
                }
            }
        }
        
        
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == ')') {
                right++;
            }else if (sb.charAt(i) == '(') {
                if (right == 0) {
                    sb.deleteCharAt(i);
                }else {
                    right--;
                }
            }
        }
        
        return sb.toString();
        
    }
}


