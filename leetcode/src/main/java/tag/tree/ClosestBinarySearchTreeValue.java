package tag.tree;

import common.TreeNode;

public class ClosestBinarySearchTreeValue {

    public int closestValue(TreeNode root, double target) {
        double[] ret = new double[]{-1, -1};
        closestValue(root, target, ret);

        return (int) ret[0];
    }


    public void closestValue(TreeNode root, double target, double[] ret) {
        if (root == null) {
            return;
        }

        if (ret[0] == -1 || Math.abs(target - root.val) < ret[1]) {
            ret[0] = root.val;
            ret[1] = Math.abs(target - root.val);
        }

        if (target < root.val) {
            closestValue(root.left, target, ret);
        } else if (target > root.val) {
            closestValue(root.right, target, ret);
        } else {
            return;
        }
    }
}
