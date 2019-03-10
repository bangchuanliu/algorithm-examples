package tag.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeneralizedAbbreviation {

    public List<String> generateAbbreviations(String word) {
        List<String> ans = new ArrayList<String>();
        generateAbbreviations(ans, word, 0, 1);
        return ans;
    }


    private void generateAbbreviations(List<String> ans,String word, int i, int k) {
        if (k > word.length() || i >= word.length() || i + k > word.length()) {
            return;
        }
        
        if (i + k <= word.length()) {
            String tmp = "";
            tmp += word.substring(0, i);
            tmp += k;
            tmp += word.substring(i + k);
            ans.add(tmp);
        }
        
        
        generateAbbreviations(ans, word, i + 1, k);
        generateAbbreviations(ans, word, i, k + 1);
    }


    // i is the current position
    // k is the count of consecutive abbreviated characters
    private void backtrack(List<String> ans, StringBuilder builder, String word, int i, int k) {
        int len = builder.length(); // keep the length of builder
        if (i == word.length()) {
            if (k != 0) builder.append(k); // append the last k if non zero
            ans.add(builder.toString());
        } else {
            // the branch that word.charAt(i) is abbreviated
            backtrack(ans, builder, word, i + 1, k + 1);

            // the branch that word.charAt(i) is kept
            if (k != 0) builder.append(k);
            builder.append(word.charAt(i));
            backtrack(ans, builder, word, i + 1, 0);
        }
        builder.setLength(len); // reset builder to the original state
    }

    public static void main(String[] args) {
        GeneralizedAbbreviation instance = new GeneralizedAbbreviation();
        List<String> result = instance.generateAbbreviations("word");
        System.out.println(Arrays.deepToString(result.toArray()));
    }
}
