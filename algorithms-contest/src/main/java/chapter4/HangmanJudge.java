package chapter4;

import java.util.HashSet;
import java.util.Set;

public class HangmanJudge {

    public static String hangmanJudge(String ans, String guess) {
        Set<Character> set = new HashSet<>();
        for (char c : ans.toCharArray()) {
            set.add(c);
        }

        int count = 0;
        int i = 0;

        while (count < 7 && i < guess.length()) {
            if (set.isEmpty()) {
                return "You Win";
            }
         
            if (!set.contains(guess.charAt(i))) {
                count++;
            } else {
                set.remove(guess.charAt(i));
            }
            i++;
        }

        if (count < 7) {
            return "You chickened out";
        } else {
            return "You lose";
        }
    }
    
    public static void main(String[] args) {
        System.out.println(hangmanJudge("cheese", "chese"));
        System.out.println(hangmanJudge("cheese", "abcdefg"));
        System.out.println(hangmanJudge("cheese", "abcdefgig"));
    }
}
