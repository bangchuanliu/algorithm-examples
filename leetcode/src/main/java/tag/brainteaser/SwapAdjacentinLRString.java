package tag.brainteaser;

public class SwapAdjacentinLRString {

    public static boolean canTransform(String start, String end) {

        int i = 0;
        int j = 0;

        while (i < start.length() && j < end.length()) {
            while (i < start.length() && start.charAt(i) == 'X') {
                i++;
            }

            while (j < end.length() && end.charAt(j) == 'X') {
                j++;
            }
            if (i < start.length() ^ j < end.length()) {
                return false;
            }

            if (i < start.length() && j < end.length()) {
                if (start.charAt(i) != end.charAt(j)
                        || (start.charAt(i) == 'L' && i < j)
                        || (start.charAt(i) == 'R' && i > j)) {
                    return false;
                }
            }

            i++;
            j++;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(canTransform("XXXLXXXXXX", "XXXLXXXXXX"));
    }
}
