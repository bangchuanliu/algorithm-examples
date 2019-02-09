package tag.array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	
	public List<List<Integer>> generate(int numRows) {
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
