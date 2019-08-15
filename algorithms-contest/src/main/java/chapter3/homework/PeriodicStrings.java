package chapter3.homework;

public class PeriodicStrings {
    
    public static int isPeriodicString(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        
        for (int i = 1; i <= input.length(); i++) {
            if (input.length() % i == 0) {
                boolean found = true;
                String pre = null;
                for (int j = 0; j < input.length(); j = j + i) {
                    if (j != 0) {
                        if (!input.substring(j, j + i).equals(pre)) {
                            found = false;
                            break;
                        }
                    }else {
                        pre = input.substring(j, j+i);
                    }
                }
                if (found) {
                    return i;
                }
            }
        }
        
        return input.length();
    }
    
    public static void main(String[] args) {
        System.out.println(isPeriodicString("abcabcabcabc"));
        System.out.println(isPeriodicString("ababab"));
    }
}
