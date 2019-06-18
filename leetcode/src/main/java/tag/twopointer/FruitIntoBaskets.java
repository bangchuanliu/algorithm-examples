package tag.twopointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitIntoBaskets {

    public int totalFruit(int[] tree) {
        if (tree == null || tree.length == 0) {
            return 0;
        }

        int i = 0;


        Map<Integer, Integer> count = new HashMap<>();
        count.put(tree[0], 1);
        int max = 1;
        for (int j = 1; j < tree.length; j++) {
            count.put(tree[j], count.getOrDefault(tree[j], 0) + 1);

            while (i < j && count.size() > 2) {
                int num = count.get(tree[i]);
                num--;
                if (num == 0) {
                    count.remove(tree[i]);
                } else {
                    count.put(tree[i], num);
                }
                i++;
            }

            max = Math.max(max, j - i + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] num = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        FruitIntoBaskets instance = new FruitIntoBaskets();
        int ret = instance.totalFruit(num);
        System.out.println(ret);
    }
}
