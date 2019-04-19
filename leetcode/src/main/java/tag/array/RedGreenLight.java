package tag.array;

import java.util.Arrays;

public class RedGreenLight {
    
    // {0,1,1,1,0,1}
    public int[] revertLight(int[] nums) {
        int[] ret = {0,-1,-1};
        
        int i = 0;
        int j = i;
        int count = 0;
        while (j < nums.length) {
            if (nums[j] == 0) {
                count--;
            } else {
                count++;
                if (count > ret[0]) {
                    ret[0] = count;
                    ret[1] = i;
                    ret[2] = j;
                }
            }
            if (count < 0) {
                i = j+1;
                count = 0;
            }
            j++;
        }
        
        return ret;
    }
    
    public static void main(String[] args) {
        RedGreenLight redGreenLight = new RedGreenLight();
        int[] nums = {1,0,1};
        System.out.println(Arrays.toString(redGreenLight.revertLight(nums)));
    }
}
