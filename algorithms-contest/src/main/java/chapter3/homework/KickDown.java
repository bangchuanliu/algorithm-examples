package chapter3.homework;

public class KickDown {
    
    public static int kickDown(String a, String b) {
        for (int k = 0; k < a.length(); k++) {
            int i = k;
            int j = 0;
            
            while (i < a.length() && j < b.length()) {
                if (a.charAt(i) -'0' + b.charAt(j) - '0' > 3) {
                    break;
                }
                i++;
                j++;
            }
            
            if (i == a.length() || j == b.length()) {
                return k + Math.max(b.length(), a.length() - k);
            }
        }
        
        return a.length() + b.length();
    }
    
    public static void main(String[] args) {
        System.out.println(kickDown("2112112112","2212112"));
        System.out.println(kickDown("12121212","21212121"));
        System.out.println(kickDown("2211221122","21212"));
    }
}
