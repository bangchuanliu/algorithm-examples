package company.airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(candidates, target, temp, result, 0);
        return result;
    }

    public static void combinationSum(int[] candidates, int target, List<Integer> temp, List<List<Integer>> result, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            temp.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], temp, result, i);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        List<List<Integer>> result = combinationSum(candidates, 7);
        System.out.println(Arrays.deepToString(result.toArray()));

        int[] candidates2 = {2, 3, 5};
        result = combinationSum(candidates2, 8);
        System.out.println(Arrays.deepToString(result.toArray()));
    }
}
