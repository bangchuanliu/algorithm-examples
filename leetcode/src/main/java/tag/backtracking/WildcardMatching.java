package tag.backtracking;

public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        if (s.length() > 0 && p.length() == 0) {
            return false;
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == p.charAt(i) || p.charAt(i) == '?') {
                return isMatch(s.substring(1), p.substring(1));
            }else if (p.charAt(i) == '*') {
                return isMatch(s.substring(1), p.substring(1)) 
                        || isMatch(s, p.substring(1)) 
                        || isMatch(s.substring(1), p);
            } else if (s.charAt(i) != p.charAt(i)) {
                return false;
            }
        }
        
        while (p.length() > 0 && p.charAt(0) == '*') {
            p = p.substring(1);
        }
        
        return p.isEmpty();
    }
    
	public boolean isMatch2(String s, String p) {
		int i = 0;
		int j = 0;
		int star = -1;
		int mark = -1;

		while (i < s.length()) {
			if (j < p.length() && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))) {
				i++;
				j++;
			} else if (j < p.length() && p.charAt(j) == '*') {
				star = j;
				mark = i;
				j++;
			} else if (star != -1) {
				j = star + 1;
				i = ++mark;
			} else {
				return false;
			}
		}

		while (j < p.length() && (p.charAt(j) == '*')) {
			j++;
		}

		return j == p.length();
	}
	
	

	public static void main(String[] args) {
		WildcardMatching instance = new WildcardMatching();
		System.out.println(instance.isMatch("acdcb", "a*c?b"));
		System.out.println(instance.isMatch("aa", "aa"));
		System.out.println(instance.isMatch("aaa", "aa"));
		System.out.println(instance.isMatch("aa", "*"));
		System.out.println(instance.isMatch("aa", "a*"));
		System.out.println(instance.isMatch("ab", "?*"));
		System.out.println(instance.isMatch("aab", "c*a*b"));
		System.out.println(instance.isMatch("abefcdgiescdfimde", "ab*cd?i*de"));
		System.out.println(instance.isMatch("abefcdg", "ab*g***?*"));
	}
}
