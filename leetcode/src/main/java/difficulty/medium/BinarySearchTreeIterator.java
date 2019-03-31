package difficulty.medium;

import java.util.Stack;

import common.TreeNode;

public class BinarySearchTreeIterator {
    Stack<TreeNode> stack = new Stack<>();

    public BinarySearchTreeIterator(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        if (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode p = node.right;

            while (p != null) {
                stack.push(p);
                p = p.left;
            }

            return node.val;
        }

        return 0;
    }
}
