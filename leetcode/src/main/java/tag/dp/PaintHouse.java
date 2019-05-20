package tag.dp;

public class PaintHouse {

    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int[] fee = costs[0];

        for (int i = 1; i < costs.length; i++) {
            int[] cur = new int[3];
            cur[0] = costs[i][0] + Math.min(fee[1], fee[2]);
            cur[1] = costs[i][1] + Math.min(fee[0], fee[2]);
            cur[2] = costs[i][2] + Math.min(fee[0], fee[1]);
            fee = cur;
        }

        return Math.min(fee[0], Math.min(fee[1], fee[2]));
    }
}
