package tag.dp;

public class PaintHouseII {

    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int[][] min = new int[2][2];
        min[1][1] = Integer.MAX_VALUE;
        min[0][1] = Integer.MAX_VALUE;

        for (int i = 0; i < costs[0].length; i++) {
            findMin(min, i, costs[0][i]);
        }

        for (int i = 1; i < costs.length; i++) {
            int[][] cur = new int[2][2];
            cur[0][1] = Integer.MAX_VALUE;
            cur[1][1] = Integer.MAX_VALUE;
            for (int j = 0; j < costs[i].length; j++) {
                if (j != min[0][0]) {
                    findMin(cur, j, min[0][1] + costs[i][j]);
                } else {
                    findMin(cur, j, min[1][1] + costs[i][j]);
                }
            }

            min = cur;
        }

        return min[0][1];
    }

    public void findMin(int[][] cur, int color, int val) {
        if (cur[0][1] > val) {
            cur[1][1] = cur[0][1];
            cur[1][0] = cur[0][0];

            cur[0][1] = val;
            cur[0][0] = color;
        } else if (cur[1][1] > val) {
            cur[1][1] = val;
            cur[1][0] = color;
        }
    }
}
