package tag.math;

/**
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * For example, a = "11" b = "1" Return "100".
 *
 * @author BangChuan Liu <liubangchuan1100@gmail.com>
 * @date Oct 30, 2014
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        int carry = 0;
        int len = Math.max(a.length(), b.length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int tmp = carry;
            if (i < a.length())
                tmp += a.charAt(a.length() - i - 1) - '0';
            if (i < b.length())
                tmp += b.charAt(b.length() - i - 1) - '0';
            carry = tmp / 2;
            sb.append(tmp % 2);
        }
        if (carry > 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("11", "100"));
        System.out.println(new AddBinary().addBinary("1", "11"));
        System.out.println(new AddBinary().addBinary("1111", "1111"));
    }
}
