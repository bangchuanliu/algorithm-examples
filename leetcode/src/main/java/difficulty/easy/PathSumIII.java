package difficulty.easy;

import common.TreeNode;
import common.TreeNodeUtil;

public class PathSumIII {
    
    static int count = 0;
    public int pathSum(TreeNode root, int sum) {
        count = 0;

        helper(root, sum);
        return count;
    }

    public void helper(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        helper2(root, sum);
        helper(root.left, sum);
        helper(root.right, sum);
    }
    
    public void helper2(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        if (sum == 0) {
            count++;
        }
        
        helper2(root.left, sum);
        helper2(root.right, sum);
    }
    
    public static void main(String[] args) {
        Integer[] nums = {1,-2,-3,1,3,-2,null,-1};
        TreeNode root = TreeNodeUtil.creatTree(nums);
        PathSumIII pathSumIII = new PathSumIII();
        System.out.println(pathSumIII.pathSum(root, -1));
    }
}
