package tag.twopointer;

/**
 * @author BangChuan Liu <liubangchuan1100@gmail.com>
 * @date Feb 3, 2015
 */
public class ImplementstrStr {
    public static int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            while (j < needle.length()
                    && needle.charAt(j) == haystack.charAt(i + j)) {
                j++;
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("a", "a"));

        System.out.println('H');
        System.out.println((char) ('H' + 32));
    }
}
