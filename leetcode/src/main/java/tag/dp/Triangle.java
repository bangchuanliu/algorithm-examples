package tag.dp;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *  Given a triangle, find the minimum path sum from top to bottom. Each step you may move to <adjacent> numbers on the row below.

	For example, given the following triangle
	[
	     [2],
	    [3,4],
	   [6,5,7],
	  [4,1,8,3]
	]
	The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
	
	Note:
	Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 * 
 * @author admin
 *
 */
public class Triangle {
		
	/**
	 * 
	 * @param triangle
	 * @return
	 */
	public int minimumTotal(List<List<Integer>> triangle) {
		
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}
	    
	    int rowSize = triangle.size();
	    int[] total	= new int[triangle.get(rowSize - 1).size()];
	    
	    for (int i = 0; i < total.length; i++) {
	        total[i] = triangle.get(rowSize - 1).get(i);
	    }
	
	    for (int i = rowSize - 2; i >= 0; i--) {
	        for (int j = 0; j < triangle.get(i).size(); j++) {
	            total[j] = triangle.get(i).get(j) + Math.min(total[j], total[j+1]);
	        }
	    }
	
	    return total[0];
	}
	
	public static void main(String[] args){
		Triangle t = new Triangle();
		Integer[] r1 = {-1};
		Integer[] r2 = {2,3};
		Integer[] r3 = {1,-1,-3};
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		triangle.add(new ArrayList(Arrays.asList(r1)));
		triangle.add(new ArrayList(Arrays.asList(r2)));
		triangle.add(new ArrayList(Arrays.asList(r3)));
		System.out.println(t.minimumTotal(triangle));
	}
}
