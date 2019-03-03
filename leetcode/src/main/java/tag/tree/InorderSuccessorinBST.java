package tag.tree;

import common.TreeNode;

public class InorderSuccessorinBST {
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }

        if (p.val < root.val) {
            TreeNode node = inorderSuccessor(root.left, p);
            return node == null ? root : node;
        } else {
            return inorderSuccessor(root.right, p);
        }
    }

    boolean isFound = false;
    TreeNode node = null;
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        helper(root, p);
        return node;
    }
    public void helper(TreeNode root, TreeNode p) {
        if (isFound  || root == null) {
            return;
        }

        inorderSuccessor(root.left, p);
        if (root.val > p.val && !isFound) {
            isFound = true;
            node = root;
        }
        inorderSuccessor(root.right, p);
    }
}
