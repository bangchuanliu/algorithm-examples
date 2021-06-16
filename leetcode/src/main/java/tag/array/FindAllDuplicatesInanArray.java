package tag.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllDuplicatesInanArray {
    
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        for (int num : nums) {
            if (nums[Math.abs(num)-1] < 0) {
                result.add(Math.abs(num));
            } else {
                nums[Math.abs(num)-1] = -nums[Math.abs(num)-1];
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        FindAllDuplicatesInanArray findAllDuplicatesinanArray = new FindAllDuplicatesInanArray();
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(Arrays.toString(findAllDuplicatesinanArray.findDuplicates(nums).toArray()));
    }
}
