package leetcode.easy.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Given a string s, partition s such that every substring of the partition is a palindrome.

	Return all possible palindrome partitioning of s.

	For example, given s = "aab",
	Return
	
	  [
	    ["aa","b"],
	    ["a","a","b"]
	  ]
  
 * @author BangChuan Liu 
 * @date   2015
 * @Contact liubangchuan1100@gmail.com
 */
public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		if(s == null || s.trim().length() == 0){
			return result; 
		}
		List<String> temp = new ArrayList<String>();
		partition(s,result,temp);
		return result;
	}
	
	public void partition(String s,List<List<String>> result,List<String> temp) {
		if(s.length() == 0){
			result.add(new ArrayList<String>(temp));
			return;
		}
		for(int i=1;i<=s.length();i++){
			if(isPalindrome(s.substring(0, i))){
				temp.add(s.substring(0, i));
				partition(s.substring(i),result,temp);
				temp.remove(temp.size()-1);
			}
		}
	}
	
	public boolean isPalindrome(String str) {
		int i = 0;
		int j = str.length() - 1;
		while (i < j && str.charAt(i) == str.charAt(j)) {
			i++;
			j--;
		}
		return i >= j;
	}
	
	public static void main(String[] args){
		PalindromePartitioning instance = new PalindromePartitioning();
		String s = "aab";
		List<List<String>> result = instance.partition(s);
		System.out.println(Arrays.deepToString(result.toArray()));
	}
}
