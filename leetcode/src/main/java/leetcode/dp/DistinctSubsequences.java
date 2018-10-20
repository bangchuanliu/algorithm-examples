package leetcode.dp;

public class DistinctSubsequences {
	
	public int numDistinct(String s, String t) {
		if (s == null || t == null || s.length() == 0 || t.length() == 0) {
			return 0;
		}
		
		int[][] nums = new int[s.length()+1][t.length()+1];
		
		for (int i = 0; i < s.length(); i++) {
			nums[i][0] = 1;
		}
		
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= t.length(); j++) {
				nums[i][j] = nums[i-1][j];
				if (s.charAt(i-1) == t.charAt(j-1)) {
					nums[i][j] += nums[i-1][j-1];
				}
			}
		}
		
		return nums[s.length()][t.length()];
	}
	
	public static void main(String[] args) {
		DistinctSubsequences instance = new DistinctSubsequences();
		System.out.println(instance.numDistinct("ccc", "c"));
	}
}
