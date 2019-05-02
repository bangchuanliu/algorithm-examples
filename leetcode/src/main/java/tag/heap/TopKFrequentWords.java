package tag.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> q = new PriorityQueue<>((a, b) -> map.get(a) == map.get(b)? b.compareTo(a) : map.get(a) - map.get(b));

        for (String str : map.keySet()) {
            q.add(str);
            if (q.size() > k) {
                q.poll();
            }
        }
        List<String> ret = new ArrayList<>();
        while (!q.isEmpty()) {
            ret.add(0,q.poll());
        }

        return ret;
    }
}
