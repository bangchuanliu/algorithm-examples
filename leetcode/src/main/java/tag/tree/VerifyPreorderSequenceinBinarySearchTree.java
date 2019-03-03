package tag.tree;

public class VerifyPreorderSequenceinBinarySearchTree {
    
    public boolean verifyPreorder(int[] preorder) {
        return verifyPreorder(preorder, 0, preorder.length - 1);
    }


    public boolean verifyPreorder(int[] preorder, int l, int r) {
        if (l >= r) {
            return true;
        }

        int root = preorder[l];
        int index = l + 1;
        for (; index <= r; index++) {
            if (preorder[index] > root) {
                break;
            }
        }

        for (int i = index; i <= r; i++) {
            if (preorder[i] < root) {
                return false;
            }
        }

        return verifyPreorder(preorder, l + 1, index - 1) && verifyPreorder(preorder, index, r);
    }
}
