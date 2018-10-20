package leetcode.tree;

import java.util.Arrays;
import java.util.List;

import common.TreeNode;

/**
 * 
 * Given an array where elements are sorted in ascending order, convert it to a
 * height balanced BST.
 * 
 * @author admin
 *
 */
public class ConvertSortedArraytoBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null || num.length == 0) {
			return null;
		}
		return sortedArrayToBST(num, 0, num.length - 1);
	}

	public TreeNode sortedArrayToBST(int[] num, int low, int high) {
		if (low > high) {
			return null;
		}
		int mid = (low + high) / 2;
		TreeNode root = new TreeNode(num[mid]);
		TreeNode left = sortedArrayToBST(num, low, mid - 1);
		TreeNode right = sortedArrayToBST(num, mid + 1, high);
		root.left = left;
		root.right = right;
		return root;
	}

	public TreeNode sortedArrayToBST2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}

		int mid = nums.length / 2;
		int[] leftArray = Arrays.copyOfRange(nums, 0, mid);
		int[] rightArray = Arrays.copyOfRange(nums, mid + 1, nums.length);

		TreeNode root = new TreeNode(nums[mid]);
		TreeNode left = sortedArrayToBST(leftArray);
		TreeNode right = sortedArrayToBST(rightArray);

		root.left = left;
		root.right = right;

		return root;
	}

	public static void main(String[] args) {
		ConvertSortedArraytoBinarySearchTree instance = new ConvertSortedArraytoBinarySearchTree();
		int[] num = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		TreeNode root = instance.sortedArrayToBST(num);
		List<Integer> result = new BinaryTreePreorderTraversal().preorderTraversal(root);
		System.out.println(Arrays.toString(result.toArray()));
	}

}
