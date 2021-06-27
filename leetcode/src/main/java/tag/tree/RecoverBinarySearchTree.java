package tag.tree;

import common.TreeNode;
import common.TreeHelper;

public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        helper(root);
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }

    TreeNode n1 = null;
    TreeNode n2 = null;
    TreeNode pre = null;
    boolean isFound = false;
    public void helper(TreeNode root){
        if(root == null){
            return;
        }

        helper(root.left);
        
        if (pre != null && pre.val > root.val) {
            if (!isFound) {
                n1 = pre;
                isFound = true;
            }
            n2 = root;
        }
        pre = root;
        helper(root.right);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

//        n2.left = n3;
//        n2.right = n1;
        n3.left = n1;
        n3.right = n4;
        n4.left = n2;
        RecoverBinarySearchTree instance = new RecoverBinarySearchTree();
        instance.recoverTree(n3);
//        TreeNodeUtil.printTree(n2);
        TreeHelper.PrintInorder(n3);
    }
}
