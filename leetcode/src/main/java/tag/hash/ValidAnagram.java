package tag.hash;

public class ValidAnagram {
	public boolean isAnagram(String s, String t) {

		if (s == null || t == null || s.length() != t.length()) {
			return false;
		}

		int[] index = new int[256];

		for (int i = 0; i < s.length(); i++) {
			index[s.charAt(i)]++;
		}

		for (int i = 0; i < t.length(); i++) {
			index[t.charAt(i)]--;
		}

		for (Integer count : index) {
			if (count != 0) {
				return false;
			}
		}

		return true;
	}
	
	public static void main(String[] args) {
		ValidAnagram instance = new ValidAnagram();
		System.out.println(instance.isAnagram("a", "a"));
	}
}
