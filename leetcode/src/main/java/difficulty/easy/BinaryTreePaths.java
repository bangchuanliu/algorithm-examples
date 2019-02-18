package difficulty.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import common.TreeNode;

public class BinaryTreePaths {
	
	public List<String> binaryTreePaths(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		
		List<String> result = new ArrayList<>();
		paths(root, result, root.val+"");
		
		return result;
	}
	
	public void paths (TreeNode root, List<String> result , String temp) {
		
		if (root.left == null && root.right == null) {
			result.add(temp);
		}
		
		if (root.left != null) {
			paths(root.left, result, temp + "->" + root.left.val);
		}
		
		if (root.right != null) {
			paths(root.right, result, temp + "->" + root.right.val);
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		root.left = left;
		
		BinaryTreePaths instance = new BinaryTreePaths();
		List<String> list = instance.binaryTreePaths(root);
		System.out.println(Arrays.toString(list.toArray()));
		
	}
}
