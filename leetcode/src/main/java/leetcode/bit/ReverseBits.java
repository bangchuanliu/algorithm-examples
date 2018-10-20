package leetcode.bit;


/**
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * For example, given input 43261596 (represented in binary as
 * 00000010100101000001111010011100), return 964176192 (represented in binary as
 * 00111001011110000010100101000000).
 * 
 * Follow up: If this function is called many times, how would you optimize it?
 * 
 * @author bliu13 Jan 13, 2016
 */
public class ReverseBits {
	// you need treat n as an unsigned value
    public int reverseBits(int n) {
        if(n == 0){
        	return n;
        }
        int m = 0;
        int len = 31;
        while(len > 0){
        	int temp = n & 1;
        	m = temp | m;
        	n = n >>> 1;
        	m = m << 1;
        	len--;
        }
        int temp = n & 1;
    	m = temp | m;
        return m;
    }
}
