package difficulty.easy;

import common.TreeNode;

public class ConstructStringfromBinaryTree {
    
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }

        String left = tree2str(t.left);
        String right = tree2str(t.right);

        if (left.isEmpty() && right.isEmpty()) {
            return t.val + "";
        } else if (!left.isEmpty() && right.isEmpty()) {
            return t.val + "(" + left + ")";
        } else {
            return t.val + "(" + left + ")" + "(" + right + ")";
        }
    }
    
    public static void main(String[] args) {
        ConstructStringfromBinaryTree constructStringfromBinaryTree = new ConstructStringfromBinaryTree();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.left = n2;
        n2.left = n4;
        n1.right = n3;
        System.out.println(constructStringfromBinaryTree.tree2str(n1));
    }
}
