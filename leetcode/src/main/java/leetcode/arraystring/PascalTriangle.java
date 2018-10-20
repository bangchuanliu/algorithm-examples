package leetcode.arraystring;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
		
		List<List<Integer>> list = new ArrayList<>();

		if (numRows <= 0) {
			return list;
		}

		List<Integer> row = new ArrayList<>();
		row.add(1);
		list.add(row);
		int i = 2;
		while (i <= numRows) {
			List<Integer> nextRow = new ArrayList<>();

			nextRow.add(row.get(row.size() - 1));

			for (int j = row.size() - 1; j > 0; j--) {
				nextRow.add(row.get(j) + row.get(j - 1));
			}

			nextRow.add(row.get(0));
			list.add(nextRow);
			row = nextRow;
			i++;
		}

		return list;
	}

	public List<List<Integer>> generate2(int numRows) {
		List<List<Integer>> result = new ArrayList<>();

		if (numRows <= 0) {
			return result;
		}

		List<Integer> cur = new ArrayList<>();
		cur.add(1);
		result.add(cur);

		for (int i = 1; i < numRows; i++) {
			List<Integer> next = new ArrayList<>();
			next.add(1);
			for (int j = 0; j < cur.size() - 1; j++) {
				next.add(cur.get(j) + cur.get(j+1));
			}
			next.add(1);
			result.add(next);
			cur = next;
		}

		return result;
	}

}
