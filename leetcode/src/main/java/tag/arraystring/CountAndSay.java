package tag.arraystring;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read
 * off as "one 2, then one 1" or 1211. Given an integer n, generate the nth
 * sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 * 
 * @author BangChuan Liu <liubangchuan1100@gmail.com>
 *
 * @date Feb 3, 2015
 */
public class CountAndSay {
	
	/**
	 * Recursive approach
	 * 
	 * @param n
	 * @return
	 */
	public String countAndSay(int n) {
		if (n <= 0) {
			return "";
		}
		if (n == 1) {
			return "1";
		}
		String lastSeq = countAndSay(n - 1);
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i < lastSeq.length()) {
			int j = i + 1;
			while (j < lastSeq.length() && lastSeq.charAt(j) == lastSeq.charAt(i)) {
				j++;
			}
			sb.append(j - i).append(lastSeq.charAt(i));
			i = j;
		}
		return sb.toString();
	}

	/**
	 * iterative approach
	 * 
	 * @param n
	 * @return
	 */
	public String countAndSay3(int n) {
		if (n <= 0) {
			return null;
		}

		String str = "1";

		while (n > 1) {
			StringBuffer sb = new StringBuffer();
			char pre = str.charAt(0);
			int counter = 1;

			for (int i = 1; i < str.length(); i++) {
				char cur = str.charAt(i);
				if (cur == pre) {
					counter++;
				} else {
					sb.append(counter).append(pre);
					pre = cur;
					counter = 1;
				}
			}
			sb.append(counter).append(pre);
			str = sb.toString();
			n--;
		}
		return str;
	}
}
