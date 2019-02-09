package tag.string;

public class AdditiveNumber {
	
	public boolean isAdditiveNumber(String num) {
		if (num == null || num.length() == 0) {
			return false;
		}
		
		for (int i = 0; i < num.length(); i++) {
			for (int j = i + 1; j < num.length(); j++) {
				String first = num.substring(0, i + 1);
				String second = num.substring(i+1, j+1);
				if (first.length() > 1 && first.startsWith("0") || second.length() > 1 && second.startsWith("0")) {
					continue;
				}
				
				String third = addStr(first, second);
				String temp = first + second + third;
				
				while (temp.length() < num.length()) {
					first = second;
					second = third;
					third = addStr(first, second);
					temp += third;
				}
				
				if (temp.equals(num)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public String addStr(String a, String b) {
		int len = Math.min(a.length(), b.length());
		int aLen = a.length() - 1;
		int bLen = b.length() - 1;
		int adv = 0;
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for (; i < len; i++) {
			int temp = (a.charAt(aLen - i) + b.charAt(bLen - i) - '0' - '0' + adv) % 10;
			sb.append(temp);
			adv = (a.charAt(aLen - i) + b.charAt(bLen - i) - '0' - '0' + adv) / 10;
		}
		while (i < a.length()) {
			int temp = (a.charAt(aLen - i) - '0' + adv) % 10;
			sb.append(temp);
			adv = (a.charAt(aLen - i) - '0' + adv) / 10;
			i++;
		}
		while (i < b.length()) {
			int temp = (b.charAt(bLen - i) - '0' + adv) % 10;
			sb.append(temp);
			adv = (b.charAt(bLen - i) - '0' + adv) / 10;
			i++;
		}
		
		if (adv > 0) {
			sb.append(adv);
		}
		return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		AdditiveNumber instance = new AdditiveNumber();
//		System.out.println(instance.isAdditiveNumber("1023"));
		System.out.println(instance.addStr("10", "2"));
	}
}
