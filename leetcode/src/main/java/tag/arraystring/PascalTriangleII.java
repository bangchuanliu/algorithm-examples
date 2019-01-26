package tag.arraystring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangleII {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<>(rowIndex + 1);

		if (rowIndex < 0) {
			return list;
		}

		list.add(1);

		for (int i = 1; i <= rowIndex; i++) {
			list.add(1);
			for (int j = i - 1; j > 0; j--) {
				int temp = list.get(j) + list.get(j - 1);
				list.set(j, temp);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		PascalTriangleII instance = new PascalTriangleII();
		System.out.println(Arrays.toString(instance.getRow(1).toArray()));
		System.out.println(Arrays.toString(instance.getRow(2).toArray()));
		System.out.println(Arrays.toString(instance.getRow(3).toArray()));
		System.out.println(Arrays.toString(instance.getRow(4).toArray()));
	}
}
