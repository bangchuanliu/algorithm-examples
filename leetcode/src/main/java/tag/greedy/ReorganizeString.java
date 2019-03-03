package tag.greedy;

import java.util.PriorityQueue;

public class ReorganizeString {
    public String reorganizeString(String S) {
        PriorityQueue<MultiChar> q = new PriorityQueue<>((a, b) -> a.count == b.count ? a.letter - b.letter : b.count - a.count);
        int[] count = new int[26];

        for (int i = 0; i < S.length(); i++) {
            count[S.charAt(i) - 'a']++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                if (count[i] > (S.length() + 1) / 2) {
                    return "";
                }
                MultiChar multiChar = new MultiChar(count[i], (char) (i + 'a'));
                q.add(multiChar);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (q.size() >= 2) {
            MultiChar temp1 = q.poll();
            MultiChar temp2 = q.poll();

            while (temp1.count > 0 && temp2.count > 0) {
                sb.append(temp1.letter);
                sb.append(temp2.letter);
                temp1.count--;
                temp2.count--;
            }

            if (temp1.count > 0) {
                q.add(temp1);
            }
            if (temp2.count > 0) {
                q.add(temp2);
            }
        }

        while (!q.isEmpty()) {
            sb.append(q.poll());
        }

        return sb.toString();
    }


    class MultiChar {
        int count;
        char letter;

        MultiChar(int count, char letter) {
            this.count = count;
            this.letter = letter;
        }
    }
}
