package tag.backtracking;

import java.util.ArrayList;
import java.util.List;

public class BeautifulArrangement {
    int count = 0;

    public int countArrangement(int N) {

        List<Integer> temp = new ArrayList<>();
        boolean[] used = new boolean[N + 1];

        permute(used, N, temp, 1);

        return count;
    }


    public void permute(boolean[] used, int N, List<Integer> temp, int index) {

        if (index > N) {
            count++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!used[i] && (i % index == 0 || index % i == 0)) {
                used[i] = true;
                temp.add(i);
                permute(used, N, temp, index + 1);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }
}
