package tag.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        PriorityQueue<Integer> heap =
                new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));

        for (Integer key : map.keySet()) {
            heap.add(key);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        while(!heap.isEmpty()) {
            result.add(heap.poll());
        }

        Collections.reverse(result);
        return result;
    }
}
