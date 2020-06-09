package tag.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringwithConcatenationofAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        if (s.length() == 0 || words.length == 0) {
            return new ArrayList<>();
        }
        int len = words[0].length();
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> cached = new HashMap<>();

        for (String str : words) {
            cached.put(str, cached.getOrDefault(str, 0) + 1);
        }

        int i = 0;
        while (i <= s.length() - words.length * len) {
            Map<String, Integer> temp = new HashMap<>(cached);
            int j = i;
            while (j + len <= s.length() && temp.containsKey(s.substring(j, j + len))) {
                int count = temp.get(s.substring(j, j + len));
                count--;
                if (count == 0) {
                    temp.remove(s.substring(j, j + len));
                } else {
                    temp.put(s.substring(j, j + len), count);
                }
                j = j + len;
            }
            if (temp.size() == 0) {
                result.add(i);
            }
            i++;

        }

        return result;
    }

    public List<Integer> findSubstring(String s, String[] words, int index) {
        if (s == null || s.length() == 0 || words == null || words.length == 0 || s.length() < words.length * words[0].length()) {
            return new ArrayList<>();
        }

        int len = words[0].length();
        List<Integer> result = findSubstring(s.substring(1), words, index + 1);
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int i = 0;
        int j = 0;

        while (i + len <= s.length() && j < words.length && map.containsKey(s.substring(i, i + len))) {
            String str = s.substring(i, i + len);
            map.put(str, map.get(str) - 1);
            if (map.get(str) == 0) {
                map.remove(str);
            }
            i = i + len;
            j++;
        }
        if (map.size() == 0) {
            result.add(index);
        }
        return result;
    }

    public static void main(String[] args) {
        SubstringwithConcatenationofAllWords substringwithConcatenationofAllWords = new SubstringwithConcatenationofAllWords();
        String s = "wordwordword";
        System.out.println(s.length());
        String[] words = {"word", "good", "best", "good"};
        System.out.println(Arrays.toString(substringwithConcatenationofAllWords.findSubstring(s, words).toArray()));
    }
}
