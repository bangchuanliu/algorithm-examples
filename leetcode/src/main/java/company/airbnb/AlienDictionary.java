package company.airbnb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AlienDictionary {

    public static String alienOrder(String[] words) {
        Map<Character, Integer> degree = new HashMap<>();
        Map<Character, List<Character>> g = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                degree.put(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];

            int j = 0;
            int len = Math.min(s1.length(), s2.length());
            while (j < len && s1.charAt(j) == s2.charAt(j)) {
                j++;
            }
            if (j < len) {
                List<Character> list = g.getOrDefault(s1.charAt(j), new ArrayList<>());
                list.add(s2.charAt(j));
                g.put(s1.charAt(j), list);
                degree.put(s2.charAt(j), degree.getOrDefault(s2.charAt(j), 0) + 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        for (char c : degree.keySet()) {
            if (degree.get(c) == 0) {
                q.add(c);
            }
        }

        while (!q.isEmpty()) {
            char cur = q.poll();
            sb.append(cur);
            if (g.get(cur) != null) {
                for (char c : g.get(cur)) {
                    int d = degree.get(c);
                    d--;
                    if (d == 0) {
                        q.add(c);
                    }
                    degree.put(c, d);
                }
            }

        }

        return sb.length() == degree.size() ? sb.toString() : "";
    }

    public static void main(String[] args) {
        String[] words = {"ab", "adc"};
        System.out.println(alienOrder(words));
    }
}
