package tag.arraystring;


/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 
 * @author BangChuan Liu <liubangchuan1100@gmail.com>
 *
 * @date Oct 29, 2014
 */
public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		String minStr = strs[0];
		for (String s : strs) {
			if (s.length() < minStr.length()) {
				minStr = s;
			}
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < minStr.length(); i++) {
			for (String s : strs) {
				if (s.charAt(i) != minStr.charAt(i)) {
					return sb.toString();
				}
			}
			sb.append(minStr.charAt(i));
		}
		return sb.toString();
	}
}
