package tag.bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
//		List<Integer> result = grayCode(2);
//		for(int a : result){
//			System.out.print(a + "  ");
//		}

        char[] chars = new char[3];
        for (int i = 0; i < 3; i++) {
            chars[i] = '0';
        }
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        boolean[] used = new boolean[3];
        grayCode(3, 0, result, used, chars,set);
        System.out.println(Arrays.toString(result.toArray()));
	}

	public static void grayCode(int n, int k, List<Integer> result, boolean[] used, char[] chars,Set<Integer> set) {
	    if (!set.contains(Integer.parseInt(new String(chars), 2))) {
            result.add(Integer.parseInt(new String(chars), 2));
            set.add(Integer.parseInt(new String(chars), 2));
        }
        
		if (k == n) {
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!used[i]) {
				used[i] = true;
                chars[i] = chars[i] == '0' ? '1' : '0';
				grayCode(n, k + 1, result, used, chars,set);
                chars[i] = chars[i] == '0' ? '1' : '0';
				used[i] = false;
			}
		}
	}
}
