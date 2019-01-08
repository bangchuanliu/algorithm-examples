package leetcode.easy.arraystring;

public class ShortestWordDistance {

	public int shortWordDistance(String[] words, String word1, String word2) {
		if (words == null || words.length == 0 || word1 == null || word2 == null) {
			return 0;
		}

		int index1 = -1;
		int index2 = -1;
		int min = words.length;

		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				index1 = i;
			} else if (words[i].equals(word2)) {
				index2 = i;
			}

			if (index1 != -1 && index2 != -1) {
				min = Math.min(Math.abs(index1 - index2), min);
			}
		}

		return min;
	}
}
