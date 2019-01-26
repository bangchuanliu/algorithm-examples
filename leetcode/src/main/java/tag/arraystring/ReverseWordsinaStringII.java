package tag.arraystring;

import java.util.Arrays;

public class ReverseWordsinaStringII {
	public void reverseWords(char[] s) {
		if (s == null || s.length == 0) {
			return;
		}

		reverse(s, 0, s.length - 1);

		int i = 0;
		int j = 0;

		while (j < s.length) {
			if (s[j] == ' ') {
				reverse(s, i, j - 1);
				i = j + 1;
			}
			j++;
		}
		reverse(s, i, j - 1);
	}

	public void reverse(char[] s, int left, int right) {
		while (left < right) {
			char ch = s[left];
			s[left] = s[right];
			s[right] = ch;
			left++;
			right--;
		}
	}

	public static void main(String[] args) {
		char[] s = { 'a', ' ', 'b' };
		ReverseWordsinaStringII instance = new ReverseWordsinaStringII();
		instance.reverseWords(s);
		System.out.println(Arrays.toString(s));
	}
}
