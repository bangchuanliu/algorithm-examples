package greedy_dp.assignment4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Knapsack {

    public static int maxValue(int[] values, int[] weights, int knapsackSize) {
        int[][] dp = new int[values.length][knapsackSize];
        for (int i = 1; i < values.length; i++) {
            for (int j = 1; j < knapsackSize; j++) {
                if (j < weights[i]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i]] + values[i]);    
                }
            }
        }
        
        return dp[values.length-1][knapsackSize-1];
    }

    public static void main(String[] args) throws IOException {
        String path = "/Users/b0l00ev/Documents/personal/data/knapsack1.txt";
//        String path = "/Users/b0l00ev/Documents/personal/data/test";
        List<String> list = Files.lines(Paths.get(path)).filter(str -> str.length() > 0).collect(Collectors.toList());
        int knapsackSize = Integer.parseInt(list.get(0).split("\\s+")[0]);
        int items = Integer.parseInt(list.get(0).split("\\s+")[1]);
        int[] values = new int[items + 1];
        int[] weights = new int[items + 1];
        for (int j = 1; j < list.size(); j++) {
            String[] valueWeight = list.get(j).split("\\s+");
            values[j] = Integer.parseInt(valueWeight[0]);
            weights[j] = Integer.parseInt(valueWeight[1]);
        }
        System.out.println(maxValue(values,weights,knapsackSize));
    }
}
