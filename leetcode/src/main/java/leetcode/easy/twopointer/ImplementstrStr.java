package leetcode.easy.twopointer;

/**
 * 
 * @author BangChuan Liu <liubangchuan1100@gmail.com>
 *
 * @date Feb 3, 2015
 */
public class ImplementstrStr {
	public static int strStr(String haystack, String needle) {
		if (haystack == null && needle == null || haystack.trim() == ""
				&& needle.trim() == "") {
			return 0;
		}

		if (haystack == null && needle != null || haystack != null
				&& needle == null || haystack.length() < needle.length()) {
			return -1;
		}
		int i = 0;
		for (; i <= haystack.length() - needle.length(); i++) {
			int j = 0;
			while (j < needle.length()
					&& needle.charAt(j) == haystack.charAt(i + j)) {
				j++;
			}
			if (j == needle.length()) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args){
		System.out.println(strStr("a","a"));
	}
}
