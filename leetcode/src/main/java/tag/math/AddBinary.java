package tag.math;

/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example, a = "11" b = "1" Return "100".
 * 
 * 
 * @author BangChuan Liu <liubangchuan1100@gmail.com>
 *
 * @date Oct 30, 2014
 */
public class AddBinary {

	public String addBinary(String a, String b) {
		StringBuffer sb = new StringBuffer();
		int i = a.length() - 1;
		int j = b.length() - 1;
		int adv = 0;
		while (i < j) {
			a = "0" + a;
			i++;
		}
        while (j < i) {
            b = "0" + b;
            j++;
        }
		
		while (i >= 0 && j >= 0) {
			int sum = a.charAt(i) + b.charAt(j) - '0' - '0' + adv;
			if (sum >= 2) {
				sb.append(sum % 2);
				adv = 1;
			} else {
				sb.append(sum);
				adv = 0;
			}
			i--;
			j--;
		}
		if (adv == 1) {
			sb.append(1);
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(new AddBinary().addBinary("11", "100"));
		System.out.println(new AddBinary().addBinary("1", "11"));
		System.out.println(new AddBinary().addBinary("1111", "1111"));
	}
}
