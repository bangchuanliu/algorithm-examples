package course3.assignment3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MaximumWightIndependentSet {

    public static List<Integer> maxWeightIS(int[] a) {
        int[] dp = new int[a.length];
        dp[0] = a[0];
        dp[1] = Math.max(a[0], a[1]);
        for (int i = 2; i < a.length; i++) {
            dp[i] = Math.max(dp[i - 1], a[i] + dp[i - 2]);
        }

        List<Integer> nodes = new ArrayList<>();
        int i = dp.length - 1;
        while (i >= 1) {
            if (dp[i] > dp[i - 1]) {
                nodes.add(i);
                i = i - 2;
            } else {
                i--;
            }
        }
        if (i == 0) {
            nodes.add(0);
        }
        return nodes;
    }


    public static void main(String[] args) throws IOException {
        // 10100110
        String path = "/Users/b0l00ev/Documents/personal/data/mwis.txt";
        List<String> list = Files.lines(Paths.get(path)).filter(str -> str.length() > 0).collect(Collectors.toList());
        int[] a = new int[list.size() - 1];
        for (int j = 1; j < list.size(); j++) {
            a[j - 1] = Integer.parseInt(list.get(j));
        }
        List<Integer> nodes = maxWeightIS(a);
        int[] ret = {0,1,2,3,16,116,516,996};
        for (int num : ret) {
            System.out.print(nodes.contains(num) == true ? 1 : 0);
        }
    }
}
