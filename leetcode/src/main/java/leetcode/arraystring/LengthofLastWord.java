package leetcode.arraystring;

/**
 * 
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * For example, Given s = "Hello World", return 5.
 * 
 * @author BangChuan Liu <liubangchuan1100@gmail.com>
 *
 * @date Jan 28, 2015
 */
public class LengthofLastWord {
	public int lengthOfLastWord(String s) {

		if (s == null || s.length() == 0) {
			return 0;
		}

		int i = s.length() - 1;
		int size = 0;

		while (i >= 0 && s.charAt(i) == ' ') {
			i--;
		}

		while (i >= 0 && (s.charAt(i) <= 'z' && s.charAt(i) >= 'a' || s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
			size++;
			i--;
		}

		return size;
	}
}
