package leetcode.math;

/**
 * 1 -> A 2 -> B 3 -> C ... 26 -> Z 27 -> AA 28 -> AB
 * 
 * 
 * @author BangChuan Liu <liubangchuan1100@gmail.com>
 *
 * @date Jan 27, 2015
 */
public class ExcelSheetColumnTitle {

	public static String convertToTitle(int n) {
		 if(n <= 0){
		        throw new IllegalArgumentException("Input is not valid!");
		    }
		 
		    StringBuilder sb = new StringBuilder();
		 
		    while(n > 0){
		        n--;
		        char ch = (char) (n % 26 + 'A');
		        n /= 26;
		        sb.append(ch);
		    }
		 
		    sb.reverse();
		    return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(convertToTitle(1));
		System.out.println(convertToTitle(26));
		System.out.println(convertToTitle(52));
		System.out.println(convertToTitle(701));
	}
}
