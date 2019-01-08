package leetcode.easy.arraystring;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> result = new ArrayList<>();
		if (words == null || words.length == 0) {
			return result;
		}

		int count = 0;
		int last = 0;

		for (int i = 0; i < words.length; i++) {
			if (count + words[i].length() + i - last > maxWidth) {
				StringBuilder sb = new StringBuilder();
				if (i - last - 1 > 0) {
					int spaceNum = (maxWidth - count) / (i - last - 1);
					int extraNum = (maxWidth - count) % (i - last - 1);

					for (int j = last; j < i; j++) {
						sb.append(words[j]);
						if (j < i - 1) {
							for (int k = 0; k < spaceNum; k++) {
								sb.append(" ");
							}
							if (extraNum > 0) {
								sb.append(" ");
								extraNum--;
							}
						}
					}
					result.add(new String(sb.toString()));
				} else {
					sb.append(words[last]);
					for (int j = sb.length(); j < maxWidth; j++) {
						sb.append(" ");
					}
					result.add(new String(sb.toString()));
				}

				count = 0;
				last = i;
			}
			count += words[i].length();
		}

		StringBuilder sb = new StringBuilder();
		for (int j = last; j < words.length; j++) {
			sb.append(words[j]);
			if (sb.length() < maxWidth) {
				sb.append(" ");
			}
		}
		for (int j = sb.length(); j < maxWidth; j++) {
			sb.append(" ");
		}
		result.add(sb.toString());

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "Hello this is a test string";
//		System.out.println(fullJustify(test.split("\\s+"), 40));
//		System.out.println(fullJustify(test.split("\\s+"), 17));
	}
}
