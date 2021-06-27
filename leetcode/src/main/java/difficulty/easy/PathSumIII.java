package difficulty.easy;

import common.TreeNode;
import common.TreeHelper;

public class PathSumIII {

    static int count = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        helper(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);

        return count;
    }

    public void helper(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (sum == root.val) {
            count++;
        }

        helper(root.left, sum - root.val);
        helper(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        Integer[] nums = {1, -2, -3, 1, 3, -2, null, -1};
        TreeNode root = TreeHelper.creatTree(nums);
        PathSumIII pathSumIII = new PathSumIII();
        System.out.println(pathSumIII.pathSum(root, -1));
    }
}
