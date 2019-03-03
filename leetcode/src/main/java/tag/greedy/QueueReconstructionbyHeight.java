package tag.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionbyHeight {

    public int[][] reconstructQueue(int[][] people) {

        if (people == null || people.length == 0) {
            return new int[0][0];
        }

        Arrays.sort(people, (a, b) -> a[0] == b[0]? a[1] - b[1] : b[0] - a[0]);

        List<int[]> list = new ArrayList<>();

        for (int[] x : people) {
            list.add(x[1], x);
        }

        int[][] result = new int[people.length][people[0].length];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
