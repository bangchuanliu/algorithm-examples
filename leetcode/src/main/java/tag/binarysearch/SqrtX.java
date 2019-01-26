package tag.binarysearch;

/**
 * 
 * @author bliu13 Jan 10, 2016
 */
public class SqrtX {

	public int mySqrt(int x) {

		if (x <= 0) {
			return 0;
		}

		int start = 1;
		int end = x;

		while (start <= end) {
			int mid = end - (end - start) / 2;
			if (mid > x / mid) {
				end = mid - 1;
			} else if (mid < x / mid) {
				start = mid + 1;
			} else {
				return mid;
			}
		}

		return end;
	}

	public double sqrt(int n) {
		double ebsilon = 0.001;
		double left = 1;
		double right = n;
		
		while (left <= right) {
			double mid = (left + right) / 2;
			double diff = Math.abs(mid * mid - n);
			if (diff < ebsilon) {
				return mid;
			} else if (mid * mid > n) {
				right = mid;
			} else {
				left = mid;
			}
		}
		
		return -1.0;
	}
	
	
	
	public static void main(String[] args) {
		SqrtX instance = new SqrtX();
		System.out.println(instance.mySqrt(2147483647));
	}
}
