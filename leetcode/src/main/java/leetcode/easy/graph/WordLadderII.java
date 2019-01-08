package leetcode.easy.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
 * @author BangChuan Liu
 * @date 2015
 * @Contact liubangchuan1100@gmail.com
 */
public class WordLadderII {
	static int dis = Integer.MAX_VALUE;

	public List<List<String>> findLadders1(String beginWord, String endWord, Set<String> wordList) {
		List<List<String>> result = new ArrayList<>();
		if (beginWord == null || endWord == null || wordList == null || beginWord.equals(endWord)) {
			return result;
		}

		Queue<String> words = new LinkedList<>();
		List<String> temp = new ArrayList<>();

		words.add(beginWord);
		wordList.add(endWord);

		findLadders2(words, result, endWord, wordList, temp);

		Iterator<List<String>> ite = result.iterator();
		while (ite.hasNext()) {
			List<String> path = ite.next();
			if (path.size() > dis) {
				ite.remove();
			}
		}

		return result;
	}

	public void findLadders2(Queue<String> words, List<List<String>> result, String endWord, Set<String> wordList,
			List<String> temp) {
		if (!words.isEmpty()) {
			String word = words.poll();
			if (word.equals(endWord)) {
				result.add(new ArrayList<>(temp));
				dis = Math.min(temp.size(), dis);
			} else {
				for (int i = 0; i < word.length(); i++) {
					for (char c = 'a'; c <= 'z'; c++) {
						char[] chars = word.toCharArray();
						if (chars[i] == c) {
							continue;
						}
						chars[i] = c;
						String tempStr = new String(chars);
						if (wordList.contains(tempStr)) {
							words.add(tempStr);
							temp.add(tempStr);
							wordList.remove(tempStr);
							findLadders2(words, result, endWord, wordList, temp);
							temp.remove(temp.size() - 1);
							wordList.add(tempStr);
						}
					}
				}
			}
		}
	}

	
	// only find one
	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
		List<List<String>> result = new ArrayList<>();
		if (beginWord == null || endWord == null || wordList == null || beginWord.equals(endWord)) {
			return result;
		}

		Queue<String> words = new LinkedList<>();
		List<String> temp = new ArrayList<>();

		words.add(beginWord);
		wordList.add(beginWord);
		wordList.add(endWord);

		while (!words.isEmpty()) {
			String word = words.poll();
			if (word.equals(endWord)) {
				result.add(new ArrayList<>(temp));
				dis = Math.min(temp.size(), dis);
			} else {
				for (int i = 0; i < word.length(); i++) {
					for (char c = 'a'; c <= 'z'; c++) {
						char[] chars = word.toCharArray();
						if (chars[i] == c) {
							continue;
						}
						chars[i] = c;
						String tempStr = new String(chars);
						if (wordList.contains(tempStr)) {
							words.add(tempStr);
							temp.add(tempStr);
							wordList.remove(tempStr);
							findLadders2(words, result, endWord, wordList, temp);
							temp.remove(temp.size() - 1);
							wordList.add(tempStr);
						}
					}
				}
			}
		}

		Iterator<List<String>> ite = result.iterator();
		while (ite.hasNext()) {
			List<String> path = ite.next();
			if (path.size() > dis) {
				ite.remove();
			}
		}

		return result;
	}
	
	
	
	
	
	public static void main(String[] args) {
		WordLadderII instance = new WordLadderII();
		String[] wordLists = { "si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av",
				"sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe",
				"ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if",
				"pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi",
				"os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt",
				"io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye" };
		Set<String> wordList = new HashSet<String>(Arrays.asList(wordLists));
		List<List<String>> result = instance.findLadders("qa", "sq", wordList);
		System.out.println(Arrays.deepToString(result.toArray()));
	}
}
