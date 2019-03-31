package tag.string;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int len = 0;
        int last = 0;

        for (int i = 0; i < words.length; i++) {
            if (len + words[i].length() + i - last > maxWidth) {
                StringBuilder sb = new StringBuilder();

                if (i - last - 1 > 0) {
                    int space = (maxWidth - len) / (i - last - 1);
                    int extra = (maxWidth - len) % (i - last - 1);

                    for (int k = last; k < i; k++) {
                        sb.append(words[k]);
                        if (k != i - 1) {
                            for (int m = 0; m < space; m++) {
                                sb.append(" ");
                            }

                            if (extra > 0) {
                                sb.append(" ");
                                extra--;
                            }
                        }
                    }
                } else {
                    sb.append(words[last]);
                    for (int k = words[last].length(); k < maxWidth; k++) {
                        sb.append(" ");
                    }
                }
                result.add(sb.toString());
                len = words[i].length();
                last = i;
            } else {
                len += words[i].length();
            }
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
