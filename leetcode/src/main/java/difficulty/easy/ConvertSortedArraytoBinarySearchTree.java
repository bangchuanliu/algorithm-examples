package difficulty.easy;

import java.util.Arrays;
import java.util.List;

import common.TreeNode;
import tag.tree.BinaryTreePreorderTraversal;

/**
 * Given an array where elements are sorted in ascending order, convert it to a
 * height balanced BST.
 *
 * @author admin
 */
public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] num) {
        return sortedArrayToBST(num, 0, num.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] num, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(num, low, mid - 1);
        root.right = sortedArrayToBST(num, mid + 1, high);
        return root;
    }

    public static void main(String[] args) {
        ConvertSortedArraytoBinarySearchTree instance = new ConvertSortedArraytoBinarySearchTree();
        int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode root = instance.sortedArrayToBST(num);
        List<Integer> result = new BinaryTreePreorderTraversal().preorderTraversal(root);
        System.out.println(Arrays.toString(result.toArray()));
    }

}
