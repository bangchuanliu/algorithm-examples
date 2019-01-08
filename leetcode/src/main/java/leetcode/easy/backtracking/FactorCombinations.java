package leetcode.easy.backtracking;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {
	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> result = new ArrayList<>();
		if (n <= 1) {
			return result;
		}
		List<Integer> temp = new ArrayList<>();
		getFactors(result, 2, n, temp);
		return result;
	}

	public void getFactors(List<List<Integer>> result, int index, int n, List<Integer> temp) {
		if (n == 1 && temp.size() > 1) {
			result.add(new ArrayList<>(temp));
		} else {
			for (int i = index; i <= n; i++) {
				if (n % i == 0) {
					temp.add(i);
					getFactors(result, i, n / i, temp);
					temp.remove(temp.size() - 1);
				}
			}
		}
	}

	public static void main(String[] args) {
		FactorCombinations instance = new FactorCombinations();
		List<List<Integer>> result = instance.getFactors(12);
		for (List<Integer> temp : result) {
			for (Integer num : temp) {
				System.out.print(num);
			}
			System.out.println();
		}
	}
}
