package difficulty.easy;

import common.TreeNode;

public class SubtreeofAnotherTree {
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return s != null && (isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t));
    }


    public boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if ((s != null && t == null) || (s == null && t != null)) {
            return false;
        } else {
            return s.val == t.val && isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        }
    }

    public String preorder(TreeNode t, boolean left) {
        if (t == null) {
            if (left)
                return "lnull";
            else
                return "rnull";
        }
        return "#"+t.val + " " +preorder(t.left, true)+" " +preorder(t.right, false);
    }

    public String preOrderString(TreeNode s, boolean flag) {
        if (s == null) {
            return flag == true ? "l#" : "r#";
        }

        String left = preOrderString(s.left, true);
        String right = preOrderString(s.right, false);

        return "#" + s.val + "," + left + "," + right;
    }
    
    public static void main(String[] args) {
        SubtreeofAnotherTree subtreeofAnotherTree = new SubtreeofAnotherTree();
        TreeNode n1 = new TreeNode(12);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
//        n1.left = n2;
        
        String s = subtreeofAnotherTree.preOrderString(n1, true);
        String t = subtreeofAnotherTree.preOrderString(n2, true);


        System.out.println(s.indexOf(t) > -1);
        System.out.println(subtreeofAnotherTree.preOrderString(n1, true));
        System.out.println(subtreeofAnotherTree.preOrderString(n2, true));
    }
}
