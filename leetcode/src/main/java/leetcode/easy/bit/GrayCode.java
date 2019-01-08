package leetcode.easy.bit;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	public static List<Integer> grayCode(int n) {
		List<Integer> result = new ArrayList<Integer>();
		if (n < 0) {
			return result;
		}
		int size = 1 << n;
		for (int i = 0; i < size; i++) {
			int code = (i >> 1) ^ i;
			result.add(code);
		}
		return result;
	}

	
	public static void main(String[] args){
		List<Integer> result = grayCode(2);
		for(int a : result){
			System.out.print(a + "  ");
		}
	}
}
