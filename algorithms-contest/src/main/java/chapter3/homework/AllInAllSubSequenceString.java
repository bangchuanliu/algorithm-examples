package chapter3.homework;

public class AllInAllSubSequenceString {
    
    public static boolean isSubsequence(String s, String t) {
        if (t == null) {
            return false;
        }
        
        int i = 0;
        int j = 0;
        
        while (i < t.length() && j < s.length()) {
            if (t.charAt(i) == s.charAt(j)) {
                i++;
                j++;
            }else {
                i++;
            }
        }
        
        return j == s.length();
    }
    
    public static void main(String[] args) {
        System.out.println(isSubsequence("sequence","subsequence"));
        System.out.println(isSubsequence("person","compression"));
        System.out.println(isSubsequence("VERDI","vivaVittorioEmanueleReDiItalia"));
        System.out.println(isSubsequence("caseDoesMatter","CaseDoesMatter"));
    }
}
