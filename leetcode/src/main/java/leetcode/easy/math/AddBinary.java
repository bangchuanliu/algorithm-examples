package leetcode.easy.math;

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
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}
		StringBuffer sb = new StringBuffer();
		int i = a.length() - 1;
		int j = b.length() - 1;
		int adv = 0;
		while (i < j) {
			a = "0" + a;
			i++;
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

	public String addBinary2(String a, String b) {
		if (a == null || a.length() == 0) {
			return b;
		}

		if (b == null || b.length() == 0) {
			return a;
		}

		int adv = 0;
		int alen = a.length();
		int blen = b.length();

		StringBuffer sb = new StringBuffer();
		int i = 0;
		for (; i < alen && i < blen; i++) {
			int sum = a.charAt(alen - i - 1) - '0' + b.charAt(blen - i - 1) - '0' + adv;
			sb.append(sum % 2);
			if (sum >= 2) {
				adv = 1;
			} else {
				adv = 0;
			}
		}

		while (i < alen) {
			int sum = a.charAt(alen - i - 1) - '0' + adv;
			sb.append(sum % 2);
			if (sum >= 2) {
				adv = 1;
			} else {
				adv = 0;
			}
			i++;
		}

		while (i < blen) {
			int sum = b.charAt(blen - i - 1) - '0' + adv;
			sb.append(sum % 2);
			if (sum >= 2) {
				adv = 1;
			} else {
				adv = 0;
			}
			i++;
		}

		if (adv == 1) {
			sb.append(1);
		}

		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(new AddBinary().addBinary("11", "100"));
		System.out.println(new AddBinary().addBinary("1", "111"));
		System.out.println(new AddBinary().addBinary("1111", "1111"));
	}
}
