package leetcode.math;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the
 * result has only one digit.
 * 
 * For example:
 * 
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only
 * one digit, return it.
 * 
 * Follow up: Could you do it without any loop/recursion in O(1) runtime?
 * 
 */

public class AddDigits {

	/**
	 * naive solution
	 * 
	 * @param num
	 * @return
	 */
	public int addDigits(int num) {
		if (num <= 0) {
			return 0;
		}
		while (num > 9) {
			char[] chs = String.valueOf(num).toCharArray();
			int temp = 0;
			for (char ch : chs) {
				temp += ch - '0';
			}
			num = temp;
		}
		return num;
	}

	public int addDigits3(int num) {
		if (num < 10) {
			return num;
		}
		while (num >= 10) {
			int sum = 0;
			while (num != 0) {
				sum += num % 10;
				num = num / 10;
			}
			num = sum;
		}
		return num;
	}

	public int addDigits2(int num) {
		if (num <= 0) {
			return 0;
		}
		int result = num - 9 * ((num - 1) / 9);
		return result;
	}

	public static void main(String[] args) {
		AddDigits instance = new AddDigits();
		System.out.println(instance.addDigits2(11));
		System.out.println(instance.addDigits2(38));
	}
}
