package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if (n <= 0 || n < k) {
			return result;
		}

		List<Integer> temp = new ArrayList<Integer>();
		
		combine(1, k, n, result, temp);
		
		return result;
	}

	public void combine(int cur, int size, int n, List<List<Integer>> result, List<Integer> temp) {
		if (size == temp.size()) {
			result.add(new ArrayList<Integer>(temp));
			return;
		}
		
		for (int i = cur; i <= n; i++) {
			temp.add(i);
			combine(i + 1, size, n, result, temp);
			temp.remove(temp.size() - 1);
		}
	}

	public static void main(String[] args) {
		Combinations instance = new Combinations();
		List<List<Integer>> result = instance.combine(10, 7);

		for (List<Integer> list : result) {
			for (int num : list) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
}
