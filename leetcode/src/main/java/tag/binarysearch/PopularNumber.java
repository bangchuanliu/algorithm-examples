package tag.binarysearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PopularNumber {

    public Set<Integer> majority(int[] nums) {
        Set<Integer> ret = new HashSet<>();
        int c1 = nums[nums.length / 4];
        int c2 = nums[nums.length / 2];
        int c3 = nums[nums.length * 3 / 4];

        int left = left(nums, 0, nums.length - 1, c1);
        int right = right(nums, 0, nums.length - 1, c1);

        if (right - left >= nums.length / 4) {
            ret.add(c1);
        }

        left = left(nums, 0, nums.length - 1, c2);
        right = right(nums, 0, nums.length - 1, c2);

        if (right - left >= nums.length / 4) {
            ret.add(c2);
        }

        left = left(nums, 0, nums.length - 1, c3);
        right = right(nums, 0, nums.length - 1, c3);

        if (right - left >= nums.length / 4) {
            ret.add(c3);
        }

        return ret;
    }


    public int left(int[] nums, int i, int j, int target) {
        if (i > j) {
            return -1;
        }

        while (i <= j) {
            int mid = (i + j) / 2;

            if (nums[mid] >= target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }    
        }

        return i;
    }

    public int right(int[] nums, int i, int j, int target) {
        if (i > j) {
            return -1;
        }
        
        while (i <= j) {
            int mid = (i + j) / 2;

            if (nums[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }    
        }

        return j;
    }
    
    public static void main(String[] args) {
        PopularNumber popularNumber = new PopularNumber();
        int[] nums = {1,1,1,6,6,6,9,145};
        System.out.println(Arrays.toString(popularNumber.majority(nums).toArray()));
    }
}
