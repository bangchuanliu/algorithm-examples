package tag.hashtable;

import java.util.HashMap;
import java.util.Map;

public class VerifyAAllianDictionary {
    
    public boolean isAlienSorted(String[] words, String order) {
        if (words == null || words.length == 0) {
            return false;
        }

        Map<Character, Integer> index = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            index.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (!isOrder(words[i],words[i+1],index)) {
                return false;
            }
        }

        return true;
    }


    public boolean isOrder(String s1, String s2, Map<Character, Integer> index) {
        int len = Math.min(s1.length(), s2.length());

        for (int i = 0; i < len; i++) {
            if (index.get(s1.charAt(i)) < index.get(s2.charAt(i))) {
                return true;
            }else if (index.get(s1.charAt(i)) > index.get(s2.charAt(i))) {
                return false;
            }
        }

        return len == s1.length();
    }
    
    public static void main(String[] args) {
        VerifyAAllianDictionary verifyAAllianDictionary = new VerifyAAllianDictionary();
        String[] words = {"hello","leetcode"};
        System.out.println(verifyAAllianDictionary.isAlienSorted(words, "hlabcdefgijkmnopqrstuvwxyz"));
    }
}
