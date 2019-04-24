package company.facebook;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DuplicatedCharSeperateInString {
    
    public String construct(String str) {
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i),0) + 1);
        }
        PriorityQueue<Character> q = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
       
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            Character c = q.poll();
            if (sb.charAt(sb.length() - 1) == c) {
                Character c2 = q.poll();
                sb.append(c2);
                if (map.get(c2) > 1) {
//                    map.put()
                }
            }
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        DuplicatedCharSeperateInString duplicatedCharSeperateInString = new DuplicatedCharSeperateInString();
        System.out.println(duplicatedCharSeperateInString.construct("aaabc"));
    }
}
