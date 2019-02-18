package tag.twopointer;

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
	
	public int lengthOfLongestSubstring(String s) {
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
