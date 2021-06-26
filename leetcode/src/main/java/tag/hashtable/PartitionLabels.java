package tag.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> indexMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            indexMap.put(s.charAt(i), i);
        }

        int j = 0;
        while (j < s.length()) {
            int i = j;
            int index = j;
            while (j <= index) {
                index = Math.max(index, indexMap.get(s.charAt(j)));
                j++;
            }
            result.add(j - i);
        }
        return result;
    }

    public static void main(String[] args) {
        PartitionLabels partitionLabels = new PartitionLabels();
        System.out.println(Arrays.toString(partitionLabels.partitionLabels("ababcbacadefegdehijhklij").toArray()));
    }
}
