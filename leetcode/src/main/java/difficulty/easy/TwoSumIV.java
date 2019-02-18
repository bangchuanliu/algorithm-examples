package difficulty.easy;

import common.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class TwoSumIV {
    public boolean findTarget(TreeNode root, int k) {
        return findTarget(root, k, new HashSet<Integer>());
    }

    public boolean findTarget(TreeNode root, int k, Set<Integer> set) {
        if (root == null) {
            return false;
        }

        boolean left = findTarget(root.left, k, set);
        if (left) {
            return true;
        }

        if (set.contains(root.val)) {
            return true;
        } else {
            set.add(k - root.val);
        }
        boolean right = findTarget(root.right, k, set);

        return right;
    }
}
