package chapter3;

public class PalindromMirror {
    
    public static void panlindromOrMirror(String input) {
        String s = "A   3  HIL JM O   2TUVWXY51SE Z  8 ";
        String[] ans = {"is not a palindrom", "is a regular palindrome", "is a mirrored string", "is a mirrored palindrome"};
        
        if (input == null || input.length() == 0) {
            return;
        }
        
        int i = 0;
        int j = input.length() - 1;
        
        int isPalindrom = 1;
        int isMirror = 1;
        
        while (i < j) {
            if (input.charAt(i) != input.charAt(j)) {
                isPalindrom = 0;
            }
            int pos = Character.isDigit(input.charAt(i)) ? input.charAt(i) - '0' + 25 : input.charAt(i) - 'A';
            if (s.charAt(pos) != input.charAt(j)) {
                isMirror = 0;
            }
            i++;
            j--;
        }
        
        System.out.println(ans[isMirror * 2 + isPalindrom]);
    }
    
    public static void main(String[] args) {
        panlindromOrMirror("NOTAPALINDROM");
        panlindromOrMirror("ISPALINILAPSI");
        panlindromOrMirror("2A3MEAS");
        panlindromOrMirror("ATOYOTA");
    }
}
