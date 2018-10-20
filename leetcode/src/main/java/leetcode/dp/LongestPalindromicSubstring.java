package leetcode.dp;

/**
 * Given a string S, find the longest palindromic substring in S. You may assume
 * that the maximum length of S is 1000, and there exists one unique longest
 * palindromic substring.
 * 
 * @author BangChuan Liu
 * @date 2015
 * @Contact liubangchuan1100@gmail.com
 */
public class LongestPalindromicSubstring {
	
	//simple solution
	public String longestPalindrome2(String s) {
		if (s == null || s.trim().length() <= 1) {
			return s;
		}
		String lStr = "";
		for(int i=0;i<s.length();i++){
			String pStr = helper(s,i,i);
			if(lStr.length() < pStr.length()){
				lStr = pStr;
			}
			pStr = helper(s,i,i+1);
			if(lStr.length() < pStr.length()){
				lStr = pStr;
			}
		}
		return lStr;
	}
	public String helper(String str, int begin, int end) {
		while (begin >= 0 && end < str.length()
				&& str.charAt(begin) == str.charAt(end)) {
			begin--;
			end++;
		}
		return str.substring(begin+1, end);
	}
	
	
	
	
	public static void main(String[] args) {
		LongestPalindromicSubstring instance = new LongestPalindromicSubstring();
		System.out.println(instance.longestPalindrome2("aabaa"));
		System.out.println(instance.longestPalindrome2("aacdefg"));
		System.out.println(instance.longestPalindrome2("acdefgg"));
		System.out.println(instance.longestPalindrome2("acdedfghijk"));
		System.out.println(instance.longestPalindrome2("acdefghijik"));
	}
}
