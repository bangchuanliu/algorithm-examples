package difficulty.easy;

import java.util.LinkedList;

import common.TreeNode;
/**
 * * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree is symmetric:
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * <p>
 * But the following is not:
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 */

/**
 * @author BangChuan Liu <liubangchuan1100@gmail.com>
 * @date Oct 29, 2014
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    /**
     * recursively method
     *
     * @param left
     * @param right
     * @return
     */
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null && right != null) {
            return false;
        } else if (left != null && right == null) {
            return false;
        } else {
            return left.val == right.val && isSymmetric(left.left, right.right)
                    && isSymmetric(left.right, right.left);
        }
    }

    /**
     * iterative method
     *
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.pollFirst();
            TreeNode right = queue.pollFirst();
            if (left == null && right != null || left != null && right == null) {
                return false;
            }
            if (left != null && right != null && left.val != right.val) {
                return false;
            }
            if (left != null && right != null && left.val == right.val) {
                queue.add(left.left);
                queue.add(right.right);
                queue.add(right.left);
                queue.add(left.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        new SymmetricTree().isSymmetric2(root);
    }

}
