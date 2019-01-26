package tag.bit;

public class BitwiseANDOfNumbersRange {
	public int rangeBitwiseAnd(int m, int n) {
		if (m > n) {
			return 0;
		}

		int i = 0;
		
		while (m != n) {
			m = m >> 1;
			n = n >> 1;
			i++;
		}
		
		return m << i;
	}
	
	public static void main(String[] args) {
		BitwiseANDOfNumbersRange instance = new BitwiseANDOfNumbersRange();
		System.out.println(instance.rangeBitwiseAnd(26,30));
	}
}
