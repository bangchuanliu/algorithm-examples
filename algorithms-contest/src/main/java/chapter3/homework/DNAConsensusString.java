package chapter3.homework;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DNAConsensusString {
    
    public static String minHammingDistance(List<String> strings) {
        Map<Character, Integer> countMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < strings.get(0).length(); i++) {
            countMap.clear();
            for (String str: strings) {
                countMap.put(str.charAt(i), countMap.getOrDefault(str.charAt(i), 0) + 1);
            }
            
            char c = ' ';
            int count = 0;
            for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
                if (entry.getValue() > count) {
                    count = entry.getValue();
                    c = entry.getKey();
                }
            }
            sb.append(c);
        }
        return sb.toString();   
    }
    
    public static void main(String[] args) {
        List<String> strings = Stream.of("TATGATAC","TAAGCTAC","AAAGATCC","TGAGATAC","TAAGATGT").collect(Collectors.toList());
        System.out.println(minHammingDistance(strings));
        
    }
}
