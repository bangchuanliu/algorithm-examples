package tag.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    
    public String frequencySort(String s) {
        Map<Character, Integer> count = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0)+1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> count.get(b) - count.get(a));
        for (char c : count.keySet()) {
            maxHeap.add(c);
        }
        
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char c = maxHeap.poll();
            while (count.get(c) > 0) {
                sb.append(c);
                count.put(c, count.get(c) - 1);
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        SortCharactersByFrequency sortCharactersByFrequency = new SortCharactersByFrequency();
        System.out.println(sortCharactersByFrequency.frequencySort("raaeaedere"));
    }
}
