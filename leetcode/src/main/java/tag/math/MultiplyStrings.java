package tag.math;

public class MultiplyStrings {

	public String multiply(String num1, String num2) {
		if (num1 == null || num2 == null) {
			return null;
		}

		int[] prod = new int[num1.length() + num2.length()];

		for (int i = 0; i < num1.length(); i++) {
			for (int j = 0; j < num2.length(); j++) {
				prod[i+j+1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
			}
		}

		int adv = 0;

		for (int i = prod.length - 1; i >= 0; i--) {
			int n = prod[i] + adv;
			prod[i] = n % 10;
			adv = n / 10;
		}

		prod[0] = Math.max(prod[0],adv);


		StringBuilder sb = new StringBuilder();

		for (int num : prod) {
			if (!(sb.length() == 0 && num == 0)) {
				sb.append(num);
			}
		}

		return sb.toString().length() == 0 ? "0": sb.toString();
	}

	public static void main(String[] args) {
		MultiplyStrings instance = new MultiplyStrings();
		System.out.println(instance.multiply("9", "9"));
	}
}
