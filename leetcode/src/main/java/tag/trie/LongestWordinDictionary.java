package tag.trie;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordinDictionary {

    public String longestWord(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        String ret = "";
        for (String str : words) {
            boolean isFind = true;
            for (int i = 1; i <= str.length(); i++) {
                if (!set.contains(str.substring(0,i))) {
                    isFind = false;
                    break;
                }
            }
            if (isFind) {
                if (str.length() > ret.length()) {
                    ret = str;    
                } else if (str.length() == ret.length() && str.compareTo(ret) < 0) {
                    ret = str;
                }
            }
        }
        
        return ret;
    }
    
    public static void main(String[] str) {
        LongestWordinDictionary longestWordinDictionary = new LongestWordinDictionary();
        String[] words = {"m","mo","moc","moch","mocha","l","la","lat","latt","latte","c","ca","cat"};
        System.out.println(longestWordinDictionary.longestWord(words));
    }
}
