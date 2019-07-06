package chapter3;

public class WRTYU {
    public static String wertyu(String input) {
        String s = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";
        
        if (input == null || input.length() == 0) {
            return input;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(char c : input.toCharArray()) {
            char cur = c;
            if (c != ' ') {
                int pos = s.indexOf(c);
                if (pos != 0) {
                    pos = pos - 1;
                }
                cur = s.charAt(pos);
            }
            sb.append(cur);
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(wertyu("O S, GOMR YPFSU/"));
    }
}
