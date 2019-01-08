package leetcode.easy.arraystring;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car"
 * is not a palindrome.
 * 
 * Note: Have you consider that the string might be empty? This is a good
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * 
 * @author BangChuan Liu <liubangchuan1100@gmail.com>
 *
 * @date Oct 29, 2014
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {

		if (s == null) {
			return true;
		}

		int start = 0;
		int end = s.length() - 1;

		while (start < end) {
			if (!isAlphnumeric(s.charAt(start))) {
				start++;
			} else if (!isAlphnumeric(s.charAt(end))) {
				end--;
			} else {
				if (!isEqual(s.charAt(start), s.charAt(end))) {
					return false;
				}
				start++;
				end--;
			}
		}

		return true;
	}

	public boolean isAlphnumeric(char ch) {
		return ch >= '0' && ch <= '9' || ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z';
	}

	public boolean isEqual(char ch1, char ch2) {

		if (ch1 <= 'Z' && ch1 >= 'A') {
			ch1 = (char) (ch1 + 32);
		}

		if (ch2 <= 'Z' && ch2 >= 'A') {
			ch2 = (char) (ch2 + 32);
		}

		return ch1 == ch2;
	}

	public static void main(String[] args) {
		ValidPalindrome ps = new ValidPalindrome();
		System.out.println(ps.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(ps.isPalindrome("race a car"));
	}

}
