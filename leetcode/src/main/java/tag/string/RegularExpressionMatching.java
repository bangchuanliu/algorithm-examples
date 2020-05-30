package tag.string;

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        if (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
            if (p.length() > 1 && p.charAt(1) == '*') {
                return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
            } else {
                return isMatch(s.substring(1), p.substring(1));
            }
        } else if (p.length() > 1 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2));
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();
        System.out.println(regularExpressionMatching.isMatch("", "c*c*"));
    }
}
