package leetcode.easy.math;

public class MultiplyStrings {

	public String multiply(String num1, String num2) {

		if (num1 == null || num2 == null) {
			return "";
		}

		int[] result = new int[num1.length() + num2.length() - 1];

		for (int i = 0; i < num1.length(); i++) {
			for (int j = 0; j < num2.length(); j++) {
				result[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
			}
		}

		StringBuilder sb = new StringBuilder();
		int carry = 0;

		for (int i = result.length - 1; i >= 0; i--) {
			int mod = (result[i] + carry) % 10;
			carry = (result[i] + carry) / 10;
			sb.insert(0, mod);
		}
		
		sb.insert(0, carry);

		while (sb.charAt(0) == '0' && sb.length() > 1) {
			sb.deleteCharAt(0);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		MultiplyStrings instance = new MultiplyStrings();
		System.out.println(instance.multiply("12", "34"));
	}
}
