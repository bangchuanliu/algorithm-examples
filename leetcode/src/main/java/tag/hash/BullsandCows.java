package tag.hash;

import java.util.HashMap;
import java.util.Map;

public class BullsandCows {
	public String getHint(String secret, String guess) {

		if (secret == null || guess == null || secret == "" || guess == "" || secret.length() != guess.length()) {
			return "";
		}

		Map<Character, Integer> letters = new HashMap<>();

		int bull = 0;
		int cow = 0;

		for (int i = 0; i < secret.length(); i++) {
			if (guess.charAt(i) == secret.charAt(i)) {
				bull++;
			} else {
				if (letters.containsKey(secret.charAt(i))) {
					letters.put(secret.charAt(i), letters.get(secret.charAt(i)) + 1);
				} else {
					letters.put(secret.charAt(i), 1);
				}
			}
		}

		for (int i = 0; i < guess.length(); i++) {
			if (guess.charAt(i) != secret.charAt(i)) {
				if (letters.containsKey(guess.charAt(i)) && letters.get(guess.charAt(i)) > 0) {
					cow++;
					letters.put(guess.charAt(i), letters.get(guess.charAt(i)) - 1);
				}
			}
		}

		return bull + "A" + cow + "B";
	}

	public static void main(String[] args) {
		BullsandCows instnace = new BullsandCows();
		System.out.println(instnace.getHint("1807", "7810"));
	}
}
