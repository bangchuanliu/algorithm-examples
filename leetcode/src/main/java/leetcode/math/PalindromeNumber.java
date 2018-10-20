package leetcode.math;


/**
 * 
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * @author BangChuan Liu <liubangchuan1100@gmail.com>
 *
 * @date Oct 29, 2014
 */
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x < 0) {
	           return false;
	       } 
	       
	       int y = x;
	       int res = 0;
	       
	       while (y != 0) {
	           res = res * 10 + y % 10;
	           y = y / 10;
	       }
	       
	       return res == x;
	}
	
	public static void main(String[] args){
		PalindromeNumber instance = new PalindromeNumber();
		System.out.println(instance.isPalindrome(1));
		
	}
}
