package company.airbnb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AlienDictionary {

    public static String alienOrder(String[] words) {
        String result = "";
        Map<Character, Integer> degrees = new HashMap<>();
        for (String str : words) {
            for (Character ch : str.toCharArray()) {
                degrees.put(ch, 0);
            }
        }

        List<String> pairs = new ArrayList<>();
        preprocess(words, pairs);

        for (String str : pairs) {
            Integer degree = degrees.get(str.charAt(1));
            degrees.put(str.charAt(1), degree + 1);
        }
        
        LinkedList<Character> letters = new LinkedList<>();
        for (Character ch : degrees.keySet()) {
            if (degrees.get(ch) == 0) {
                letters.add(ch);
            }
        }

        while (!letters.isEmpty()) {
            Character ch = letters.poll();
            result += ch;
            for (String str : pairs) {
                if (str.charAt(0) == ch) {
                    Integer degree = degrees.get(str.charAt(1));
                    degree--;
                    if (degree == 0) {
                        letters.add(str.charAt(1));
                    } else {
                        degrees.put(str.charAt(1), degree);
                    }
                }
            }
        }

        return result.length() == degrees.size() ? result : "";
    }

    public static void preprocess(String[] words, List<String> pairs) {
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int m = 0;
            int n = 0;
            while (m < word1.length() && n < word2.length()) {
                if (word1.charAt(m) != word2.charAt(n)) {
                    pairs.add(String.valueOf(word1.charAt(m)) + String.valueOf(word2.charAt(n)));
                    break;
                }
                m++;
                n++;
            }
        }
    }

    public static void main(String[] args) {
        String[] words = {"ab", "adc"};
        System.out.println(alienOrder(words));
    }
}
