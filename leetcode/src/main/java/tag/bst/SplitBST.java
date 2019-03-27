package tag.bst;

import common.TreeNode;

public class SplitBST {
    
    public TreeNode[] splitBST(TreeNode root, int V) {
        if (root == null) {
            return new TreeNode[]{null, null};
        }
        TreeNode[] split;
        if (root.val <= V) {
            split =  splitBST(root.right, V);
            root.right = split[0];
            split[0] = root;
        } else {
            split =  splitBST(root.left, V);
            root.left = split[1];
            split[1] = root;
        }
        
        return split;
    }
}
