package leetcode.easy.twopointer;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters. For example, 
 * the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 * @author admin
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
	
	/**
	 * Recursive solution
	 * 
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s) {
		 if (s == null || s.length() == 0) {
	           return 0;
	       }
	       
	       if (s.length() == 1) {
	           return 1;
	       }
	       
	       int i = 0;
	       int j = 1;
	       int maxLen = 0;
	       
	       Map<Character,Integer> letterIndexMap = new HashMap<>();
	       letterIndexMap.put(s.charAt(i), i);
	       
	       while (j < s.length()) {
	           if (letterIndexMap.containsKey(s.charAt(j))) {
	               maxLen = Math.max(maxLen, j - i);
	               int cur = letterIndexMap.get(s.charAt(j)) + 1;
	               for (int k = i; k < cur; k++) {
	            	   letterIndexMap.remove(s.charAt(k));
	               }
	               i = cur;
	           } 
	           
	           letterIndexMap.put(s.charAt(j),j);
	           j++;
	       }
	       maxLen = Math.max(maxLen, j - i);
	       return maxLen;
	}
	
	public int lengthOfLongestSubstring2(String s) {
		if(s == null || s.length() == 0){
			return 0;
		}
		boolean[] flag = new boolean[256];
		int result = 0;
		int start = 0;
		char[] arr = s.toCharArray();
		for(int i=0;i<arr.length;i++){
			char current = arr[i];
			if(flag[current]){
				result = Math.max(result, i-start);
				for(int k = start;k<i;k++){
					if(arr[k] == current){
						start = k + 1;
						break;
					}else{
						flag[arr[k]] = false;
					}
				}
			}
			flag[current] = true;
		}
		return Math.max(arr.length - start, result);
	}
	
	
	public static void main(String[] args){
		LongestSubstringWithoutRepeatingCharacters instance = new LongestSubstringWithoutRepeatingCharacters();
		String s = "abba";
		String ss = "bbbbbbbbb";
		System.out.println(instance.lengthOfLongestSubstring(s));
		System.out.println(instance.lengthOfLongestSubstring(ss));
	}
}
