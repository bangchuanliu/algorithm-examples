package tag.string;

import java.util.Arrays;

public class FlipArray {
	
	public void flip(int[][] array) {
		
		if (array == null) {
			return;
		}
		
		int n = array.length;
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < n - i; j++) {
				int temp = array[i][j];
				array[i][j] = array[n-j-1][n-i-1];
				array[n-j-1][n-i-1] = temp;
			}
		}
	}
	
	
	public static void main(String[] args) {
		int[][] array = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12},{13,14,15,16}};
		FlipArray instance = new FlipArray();
		instance.flip(array);
		System.out.println(Arrays.deepToString(array));
	}
}
