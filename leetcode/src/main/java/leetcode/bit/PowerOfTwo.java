package leetcode.bit;


/**
 * 
 * @author bliu13 Jan 12, 2016
 */
public class PowerOfTwo {
	public boolean checkPowerOf2(int n) {
		long m = n;
		if (m == 0) {
			return false;
		}
		return (m & (m - 1)) == 0;
	}
	
	public static void main(String[] args) {
		PowerOfTwo instance = new PowerOfTwo();
		System.out.println(instance.checkPowerOf2(-2147483648));
		System.out.println(-2147483648 - 1);
	}
}
