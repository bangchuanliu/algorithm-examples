package tag.trie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplaceWords {

    public String replaceWords(List<String> dict, String sentence) {
        String[] strs = sentence.split("\\s+");

        StringBuilder sb = new StringBuilder();

        for (String word : strs) {
            String prefix = word;
            for (String d : dict) {
                if (word.startsWith(d) && d.length() < prefix.length()) {
                    prefix = d;
                }
            }
            sb.append(" ").append(prefix);
        }

        return sb.toString().trim();
    }


    public String replaceWordsTrie(List<String> dict, String sentence) {
//        Node root = new Node();
//        for (String str : dict) {
//            Node cur = root;
//            for (char ch : str.toCharArray()) {
//                if (cur.children[ch-'a'] == null) {
//
//                }
//            }
//        }
        return null;
    }


    class Node {
        Map<Character, Node> children;
        String word;

        Node() {
            children = new HashMap<>();
        }
    }
}
