package tag.hash;

import java.util.HashMap;
import java.util.Map;

public class FractiontoRecurringDecimal {
	
	public String fractionToDecimal(int numerator, int denominator) {
		if (denominator == 0) {
			return null;
		}
		
		Map<Long,Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		long numeratorLong = (long)numerator;
		long denominatorLong = (long)denominator;
		
		if (numeratorLong % denominatorLong == 0) {
			return String.valueOf(numeratorLong / denominatorLong);
		}
		
		int sign = 1;
		if (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) {
			sign = -1;
		}
		
		numeratorLong = Math.abs(numeratorLong);
		denominatorLong = Math.abs(denominatorLong);
		
		sb.append(numeratorLong / denominatorLong).append(".");
		numeratorLong = (numeratorLong % denominatorLong) * 10;
		int start = sb.length();
		
		while (numeratorLong != 0 && !map.containsKey(numeratorLong)) {
			map.put(numeratorLong, start);
			start++;
			sb.append(numeratorLong /  denominatorLong);
			numeratorLong = (numeratorLong % denominatorLong) * 10;
		}
		
		if (numeratorLong == 0) {
			return sign == -1 ? "-" + sb.toString() : sb.toString();
		} else {
			start = map.get(numeratorLong);
			String result = sb.substring(0, start) + "(" + sb.substring(start) + ")";
			return sign == -1 ? "-"+result : result;
		}
	}
	
	public static void main(String[] args) {
		FractiontoRecurringDecimal instance = new FractiontoRecurringDecimal();
		System.out.println(instance.fractionToDecimal(1,6));
	}
}
