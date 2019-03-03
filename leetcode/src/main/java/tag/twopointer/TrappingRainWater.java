package tag.twopointer;

public class TrappingRainWater {
    public int trap(int[] height) {
        int lmax = 0;
        int rmax = 0;

        int left = 0;
        int right = height.length - 1;
        int result = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] < lmax) {
                    result += lmax - height[left];
                }else {
                    lmax = height[left];
                }
                left++;
            }else {
                if (height[right] < rmax) {
                    result += rmax - height[right];
                }else {
                    rmax = height[right];
                }
                right--;
            }

        }

        return result;
    }
}
