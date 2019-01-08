package leetcode.easy.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  Given a string s and a dictionary of words dict, 
 *  add spaces in s to construct a sentence where each word is a valid dictionary word.

	Return all such possible sentences.
	
	For example, given
	s = "catsanddog",
	dict = ["cat", "cats", "and", "sand", "dog"].
	
	A solution is ["cats and dog", "cat sand dog"].

 * @author BangChuan Liu 
 * @date   2015
 * @Contact liubangchuan1100@gmail.com
 */
public class WordBreakII {

	public List<String> wordBreak(String s, Set<String> dict) {
		List<String> emptyList = new ArrayList<String>();
		if (s == null || s.trim().length() == 0 || dict == null || dict.size() == 0) {
			return emptyList;
		}
		List<String>[] result = new ArrayList[s.length()+1];
		result[0] = emptyList;
		for(int i = 0;i<s.length();i++){
			if(result[i] == null){
				continue;
			}
			for(String str : dict){
				int end = str.length() + i;
				if(end > s.length()){
					continue;
				}
				
				if(str.equals(s.substring(i, end))){
					if(result[end] == null){
						result[end] = new ArrayList<String>();
					}
					result[end].add(str);
				}
			}
		}
		if(result[s.length()] == null){
			return emptyList;
		}
		ArrayList<String> ret =  new ArrayList<String>();
		dfs(result,s.length(),ret,new ArrayList<String>());
		Collections.reverse(ret);
		return ret;
	}
	
	public void dfs(List<String>[] result,int end,List<String> ret, List<String> tmp){
		if(end <= 0){
			String path = "";
			for(String str : tmp){
				path = str + " " + path;
			}
			ret.add(path.trim());
		}
		
		for(String str : result[end]){
			tmp.add(str);
			dfs(result,end-str.length(),ret,tmp);
			tmp.remove(str);
		}
	}
	
	public static void main(String[] args) {
		WordBreakII instance = new WordBreakII();
		String s = "aaaaaaa";
		String[] strs = {"aaaa", "aa", "a"};
		Set<String> dict =new HashSet<String>(Arrays.asList(strs));
		List<String> ret = instance.wordBreak(s, dict);
		for(String str :  ret){
			System.out.println(str);
		}
		
	}
}
