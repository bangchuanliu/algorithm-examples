package tag.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), map.getOrDefault(S.charAt(i), 0) + 1);
        }

        int i = 0;
        int j = 0;
        int k = i;
        while (j < S.length()) {
            int num = map.get(S.charAt(j));
            num--;
            map.put(S.charAt(j), num);
            if (num == 0) {
                while (k < j && map.get(S.charAt(k)) == 0) {
                    k++;
                }
                if (k == j) {
                    result.add(j - i + 1);
                    i = j+1;
                    k = i;
                }
            }
            j++;
        }
        return result;
    }
    
    public static void main(String[] args) {
        PartitionLabels partitionLabels = new PartitionLabels();
        System.out.println(Arrays.toString(partitionLabels.partitionLabels("ababcbacadefegdehijhklij").toArray()));
    }
}
