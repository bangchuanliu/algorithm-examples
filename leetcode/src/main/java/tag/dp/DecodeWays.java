package tag.dp;

/**
 * 
 * @author bliu13 Jan 5, 2016
 */
public class DecodeWays {

	public int numDecodings(String s) {
		if (s.startsWith("0")) {
			return 0;
		}
		if (s == null || s.length() == 0) {
			return 0;
		}

		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i < dp.length; i++) {
			if (s.charAt(i-1) != '0') {
				dp[i] += dp[i-1];
			}

			if (s.charAt(i-2) != '0' && Integer.parseInt(s.substring(i-2,i)) <= 26) {
				dp[i] += dp[i-2];
			}
		}

		return dp[dp.length-1];
	}


	public static void main(String[] args) {
		DecodeWays instance = new DecodeWays();
		System.out.println(instance.numDecodings("27"));
		System.out
				.println(instance
						.numDecodings("9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253"));
	}
}
