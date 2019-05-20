package tag.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * Given two words (beginWord and endWord), and a wordListionary, find all
 * shortest transformation sequence(s) from beginWord to endWord, such that:
 * 
 * Only one letter can be changed at a time Each intermediate word must exist in
 * the wordListionary For example,
 * 
 * Given: beginWord = "hit" endWord = "cog" wordList =
 * ["hot","dot","dog","lot","log"] Return [ ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"] ] Note: All words have the same length. All
 * words contain only lowercase alphabetic characters.
 * 
 */
public class WordLadderII {

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		if (beginWord.equals(endWord)) {
			return new ArrayList<>();
		}

		Queue<String> q = new LinkedList<>();
		Set<String> marked = new HashSet<>();
		q.add(beginWord);
		marked.add(beginWord);
		boolean isFound = false;
		Map<String, List<String>> map = new HashMap<>();

		while (!q.isEmpty() || !isFound) {
			int size = q.size();
			List<String> tempList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				String str = q.poll();

				if (str.equals(endWord)) {
					isFound = true;
				}
				
				for (String temp : wordList) {
					if (!marked.contains(temp) && isOneDiff(str, temp)) {
						List<String> list = map.getOrDefault(temp, new ArrayList<>());
						list.add(str);
						map.put(temp, list);
						q.add(temp);
						tempList.add(temp);
					}
				}
			}
			marked.addAll(tempList);
		}
		List<List<String>> result = new ArrayList<>();
		List<String> temp = new ArrayList<>();
		temp.add(endWord);
		generateList(beginWord, endWord, map, temp, result);

		return result;

	}

	public boolean isOneDiff(String s1, String s2) {
		int i = 0;
		while (s1.charAt(i) == s2.charAt(i)) {
			i++;
		}

		return s1.substring(i+1).equals(s2.substring(i+1));
	}

	public void generateList(String start, String end, Map<String, List<String>> map, List<String> temp, List<List<String>> result) {
		if (end.equals(start)) {
			result.add(new ArrayList<>(temp));
			return;
		}

		for(String word : map.get(end)) {
			temp.add(0,word);
			generateList(start, word, map, temp, result);
			temp.remove(0);
		}
	}
	
	
	
	public static void main(String[] args) {
		WordLadderII instance = new WordLadderII();
//		String[] wordLists = {"hot","dot","dog","lot","log","cog"};
		String[] wordLists = { "si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av",
				"sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe",
				"ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if",	
				"pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi",
				"os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt",
				"io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye" };
		Set<String> wordList = new HashSet<String>(Arrays.asList(wordLists));
		List<List<String>> result = instance.findLadders("qa", "sq", Arrays.asList(wordLists));
//		List<List<String>> result = instance.findLadders("hit", "cog", Arrays.asList(wordLists));
		System.out.println(Arrays.deepToString(result.toArray()));
	}
}
