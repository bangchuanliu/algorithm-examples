package tag.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (num == null || num.length == 0) {
            return result;
        }
        Arrays.sort(num);
        subsetsHelper(result, list, num, 0);

        return result;
    }

    private void subsetsHelper(List<List<Integer>> result, ArrayList<Integer> list, int[] num, int pos) {
        result.add(new ArrayList<Integer>(list));
        
        int last = Integer.MIN_VALUE;
        
        for (int i = pos; i < num.length; i++) {
            if (num[i] != last) {
                last = num[i];
                list.add(num[i]);
                subsetsHelper(result, list, num, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 2};
        SubsetsII instance = new SubsetsII();
        List<List<Integer>> result = instance.subsetsWithDup(nums);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
