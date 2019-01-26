package tag.binarysearch;

/**
 * 
 * @author bliu13 Jan 11, 2016
 */
public class HIndexII {
	public int hIndex(int[] citations) {
		if (citations == null || citations.length == 0) {
			return 0;
		}

		int left = 1;
		int right = citations.length - 1;
		int index = 0;
		
		while (left < right) {
			int mid = (left + right) / 2;
			
			if (citations[citations.length - 1 - mid] >= mid) {
				right = mid - 1;
				index = mid;
			} else {
				left = mid + 1;
				index = left;
			}
		}

		return citations[index];
	}
}
