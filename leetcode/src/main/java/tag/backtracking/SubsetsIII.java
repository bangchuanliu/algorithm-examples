package tag.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsIII {

    public List<String> generateSubsets(String str) {
        List<String> ret = new ArrayList<>();

        generateSubsets(ret, new StringBuilder(), str.toCharArray(), 0);

        return ret;
    }


    public void generateSubsets(List<String> ret, StringBuilder sb, char[] chars, int index) {
        ret.add(sb.toString());

        if (index == chars.length) {
            return;
        }

        for (int i = index; i < chars.length; i++) {
            sb.append(chars[i]);
            generateSubsets(ret, sb, chars, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        SubsetsIII subsetsIII = new SubsetsIII();
        System.out.println(Arrays.toString(subsetsIII.generateSubsets("abc").toArray()));
    }
}
