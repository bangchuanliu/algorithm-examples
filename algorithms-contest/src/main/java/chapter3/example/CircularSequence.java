package chapter3.example;

public class CircularSequence {

    public static String minLexiSequence(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        
        int ans = 0;
        
        for (int i = 1; i < input.length(); i++) {
            if (less(input, i, ans)) {
                ans = i;
            }
        }
        
        String str = "";
        for (int i = 0; i < input.length(); i++) {
            str += input.charAt(ans++ % input.length());
        }
        
        return str;
    }
  
    public static boolean less(String input, int i, int j) {
        for (int k = 0; k < input.length(); k++) {
            char a = input.charAt((i + k) % input.length());
            char b = input.charAt((j + k) % input.length());
            
            if (a != b) {
                return a < b;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(minLexiSequence("CTCC"));
        System.out.println(minLexiSequence("CGAGTCAGCT"));
    }
}
