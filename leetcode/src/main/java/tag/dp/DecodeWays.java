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
		
		int[] ways = new int[s.length() + 1];
		
		ways[0] = 1;
		ways[1] = 1;
		
		for (int i = 2; i <= s.length(); i++) {
			if (isValid(s.substring(i-1,i))) {
				ways[i] += ways[i-1];
			}
			
			if (isValid(s.substring(i-2,i))) {
				ways[i] += ways[i-2];
			}
		}
		
		return ways[s.length()];
	}
	
	public boolean isValid(String str) {
		if (str.charAt(0) == '0') {
			return false;
		}
		
		return Integer.parseInt(str) >= 1 && Integer.parseInt(str) <= 26;	
	}

	public static void main(String[] args) {
		DecodeWays instance = new DecodeWays();
		System.out.println(instance.numDecodings("27"));
		System.out
				.println(instance
						.numDecodings("9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253"));
	}
}
