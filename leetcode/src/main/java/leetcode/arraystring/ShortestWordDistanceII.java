package leetcode.arraystring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistanceII {
	
	private Map<String, List<Integer>> wordIndexMap = new HashMap<>();
	
	public ShortestWordDistanceII(List<String> words) {
		if (words != null) {
			for (int i = 0; i < words.size(); i++) {
				if (wordIndexMap.containsKey(words.get(i))) {
					wordIndexMap.get(words.get(i)).add(i);
				} else {
					List<Integer> indexs = new ArrayList<>();
					indexs.add(i);
					wordIndexMap.put(words.get(i), indexs);
				}
			}
		}
	}
	
	public int shortWordDistance(String word1, String word2) {
		int dis = Integer.MAX_VALUE;
		List<Integer> indexs1 = wordIndexMap.get(word1);
		List<Integer> indexs2 = wordIndexMap.get(word2);
		
		if (indexs1 != null && indexs2 != null) {
			int i = 0; 
			int j = 0;
			while (i < indexs1.size() && j < indexs2.size()) {
				dis = Math.min(dis, Math.abs(indexs1.get(i) - indexs2.get(j)));
				if (indexs1.get(i) < indexs2.get(j)) {
					i++;
				} else {
					j++;
				}
			}
		}
		
		return dis;
	}
}
