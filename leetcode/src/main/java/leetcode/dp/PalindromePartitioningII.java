package leetcode.dp;

public class PalindromePartitioningII {
	
	public int minCut(String s) {
		
		if (s == null || s.length() == 0) {
			return 0;
		}
		
		int n = s.length();
		boolean[][] result = new boolean[n][n];
		int[] cut = new int[n];
		
		for (int j = 0; j < n; j++) {
			cut[j] = j;
			for (int i = 0; i <= j; i++) {
				if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || result[i+1][j-1])) {
					result[i][j] = true;
					
					if (i > 0) {
						cut[j] = Math.min(cut[j], cut[i-1] + 1);
					} else {
						cut[j] = 0;
					}
				}
			}
		}
		
		return cut[n-1];
	}
}
