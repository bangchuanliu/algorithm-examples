package company.facebook;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DuplicatedCharSeperateInString {
    
    public String construct(String str) {
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        PriorityQueue<Character> q = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        if (map.size() == 1) {
            return str;
        }
        for (char c : map.keySet()) {
            q.add(c);
        }
        StringBuilder sb = new StringBuilder();
        Character c1 = q.poll();
        while (!q.isEmpty()) {
            Character c2 = q.poll();
            if (map.get(c1) == 0) {
                c1 = c2;
                continue;
            }
            int min = Math.min(map.get(c1), map.get(c2));
            for (int i = 0; i < min; i++) {
                sb.append(c1).append(c2);
                map.put(c1, map.get(c1) - 1);
                map.put(c2, map.get(c2) - 1);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DuplicatedCharSeperateInString duplicatedCharSeperateInString = new DuplicatedCharSeperateInString();
        System.out.println(duplicatedCharSeperateInString.construct("aaabc"));
        System.out.println(duplicatedCharSeperateInString.construct("aaabbc"));
    }
}
