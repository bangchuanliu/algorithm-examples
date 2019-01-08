package leetcode.easy.math;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

	public String getPermutation(int n, int k) {
		if (n < 0 || k < 0) {
			return "";
		}
		
		List<Integer> nums = new ArrayList<>();
		
		for (int i = 1; i <= n; i++) {
			nums.add(i);
		}
		
		int factorProduct = 1;
		StringBuffer sb = new StringBuffer();
		
		for (int i = 1; i <= n; i++) {
			factorProduct *= i;
		}
		k--;
		
		for (int i = 0; i < n; i++) {
			factorProduct = factorProduct / (n - i);
			int curIndex = k / factorProduct;
			k = k % factorProduct;
			sb.append(nums.get(curIndex));
			nums.remove(curIndex);
		}
		
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		PermutationSequence instance = new PermutationSequence();
		String result = instance.getPermutation(2,1);
		System.out.println(result);
	}

}
