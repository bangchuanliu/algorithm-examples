package leetcode.hash;

import java.util.HashMap;
import java.util.Map;

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}

public class MaxPointsonaLine {

	public int maxPoints(Point[] points) {
		if (points == null || points.length == 0) {
			return 0;
		}

		int max = 0;

		for (int i = 0; i < points.length; i++) {
			int dup = 1;
			int vertical = 0;
			Map<String, Integer> map = new HashMap<>();

			for (int j = i + 1; j < points.length; j++) {
				if (points[i].x == points[j].x) {
					if (points[i].y == points[j].y) {
						dup++;
					} else {
						vertical++;
					}
				} else {
					int yDiff = points[i].y - points[j].y;
					int xDiff = points[i].x - points[j].x;
					int slope = gcd(Math.abs(yDiff), Math.abs(xDiff));
					String slopeStr = String.valueOf(yDiff / slope * xDiff / slope);
					if (map.containsKey(slopeStr)) {
						map.put(slopeStr, map.get(slopeStr) + 1);
					} else {
						map.put(slopeStr, 1);
					}
				}
			}

			max = Math.max(max, dup + vertical);
			for (Integer num : map.values()) {
				max = Math.max(max, num + dup);
			}
		}
		return max;
	}

	public int gcd(int a, int b) {
		if (a > b) {
			return gcd(b, a);
		}

		if (a == 0) {
			return b;
		} else {
			return gcd(b % a, a);
		}
	}

	public static void main(String[] args) {
		MaxPointsonaLine instance = new MaxPointsonaLine();
		Point p1 = new Point(0, 0);
		Point p2 = new Point(1, 1);
		Point p3 = new Point(1, -1);
		Point[] points = { p1, p2, p3 };
		System.out.println(instance.maxPoints(points));
	}
}