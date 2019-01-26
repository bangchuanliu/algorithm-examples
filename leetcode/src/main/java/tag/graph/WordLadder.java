package tag.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


/**
 * 
 *  Given two words (beginWord and endWord), and a dictionary, find the length of shortest transformation sequence from beginWord to endWord, such that:

	Only one letter can be changed at a time
	Each intermediate word must exist in the dictionary
	For example,
	
	Given:
	start = "hit"
	end = "cog"
	dict = ["hot","dot","dog","lot","log"]
	As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
	return its length 5.
	
	Note:
	Return 0 if there is no such transformation sequence.
	All words have the same length.
	All words contain only lowercase alphabetic characters.
 * 
 * @author BangChuan Liu 
 * @date   2015
 * @Contact liubangchuan1100@gmail.com
 */
public class WordLadder {
	public int ladderLength(String beginWord, String endWord,
			Set<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null || beginWord.equals(endWord)) {
            return 0;
        }
        
        LinkedList<String> wordQ = new LinkedList<>();
        LinkedList<Integer> distanceQ = new LinkedList<>();
        wordQ.add(beginWord);
        distanceQ.add(1);
        
        int result = Integer.MAX_VALUE;
        
        while (!wordQ.isEmpty()) {
            String word = wordQ.poll();
            int dis = distanceQ.poll();
            
            if (word.equals(endWord)) {
                result = Math.min(dis,result);
            }
          
            for (int i = 0; i < beginWord.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char[] words = word.toCharArray();
                    if (words[i] == c) {
                        continue;
                    }
                    words[i] = c;
                    String temp = new String(words);
                    if (wordList.contains(temp)) {
                        wordQ.add(temp);
                        distanceQ.add(dis+1);
                        wordList.remove(temp);
                    }
                }
            }
        }
        
        return result == Integer.MAX_VALUE ? 0 : result;
	}
	public static void main(String[] args){
		WordLadder instance = new WordLadder();
		String[] dicts = {"hot","dot","dog"};
		Set<String> dict = new HashSet<String>(Arrays.asList(dicts));
		int result = instance.ladderLength("hot", "dog", dict);
		System.out.println(result);
	}
}
