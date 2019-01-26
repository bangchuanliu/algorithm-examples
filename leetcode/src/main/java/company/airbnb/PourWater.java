package company.airbnb;

import java.util.Arrays;

public class PourWater {
    public static int[] pourWater(int[] heights, int V, int K) {
        for (int i = 0; i < V; i++) {
            int cur = K;
            // Move left
            while (cur > 0 && heights[cur] >= heights[cur - 1]) {
                cur--;
            }
            // Move right
            while (cur < heights.length - 1 && heights[cur] >= heights[cur + 1]) {
                cur++;
            }
            // Move left to K
            while (cur > K && heights[cur] >= heights[cur - 1]) {
                cur--;
            }
            heights[cur]++;
        }

        return heights;
    }


    public static void main(String[] args) {
        // [1,2,3,4,3,4,3,3,3,4,3,2,1]
        int[] heights = {1, 2, 3, 4, 3, 2, 1, 2, 3, 4, 3, 2, 1};
        int[] result = pourWater(heights, 5, 5);
        System.out.println(Arrays.toString(result));
    }

}
