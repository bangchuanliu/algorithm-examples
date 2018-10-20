package leetcode.binarysearch;

public class FirstBadVersion {
	public int findFirstBadVersion(int n) {
		if (n <= 0) {
			return 0;
		}
		long left = 1;
		long right = n;
		int index = -1;
		while (left <= right) {
			int mid = (int) ((left + right) / 2);
			if (VersionControl.isBadVersion(mid)) {
				right = mid - 1;
				index = mid;
			} else {
				left = mid + 1;
			}
		}
		return index;
	}

	public int findFirstBadVersion2(int n) {

		if (n <= 0) {
			return 0;
		}

		int left = 1;
		int right = n;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (VersionControl.isBadVersion(mid)) {
				if (mid == 1 || !VersionControl.isBadVersion(mid - 1)) {
					return mid;
				} else {
					right = mid - 1;
				}
			} else {
				left = mid + 1;
			}
		}

		return right;
	}

	public static void main(String[] args) {
		FirstBadVersion instance = new FirstBadVersion();
		// VersionControl.threshold = 1;
		System.out.println(instance.findFirstBadVersion2(2126753390));
	}
}

class VersionControl {

	public static int threshold = 1702766719;

	public static boolean isBadVersion(int k) {
		return k >= threshold;
	}
}
