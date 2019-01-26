package tag.arraystring;

public class ReverseWordsInString {
	public String reverseWords(String s) {
		if (s == null || s.trim().length() == 0) {
			return "";
		}
		String[] strs = s.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for (int i = strs.length - 1; i >= 0; i--) {
			sb.append(strs[i].trim()).append(" ");
		}
		return sb.toString().trim();
	}

	public static void main(String[] args) {
		ReverseWordsInString instance = new ReverseWordsInString();
		System.out.println(instance.reverseWords("   a   b "));
	}
}
