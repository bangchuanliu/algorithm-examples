package leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import common.TreeNode;

public class BinaryTreePaths {
	
	public List<String> binaryTreePaths(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		
		List<Integer> temp = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		temp.add(root.val);
		paths(root, result, temp);
		
		List<String> resultStr = new ArrayList<>();
		
		for (List<Integer> list : result) {
			String str = "";
			for (int i = 0; i < list.size() - 1; i++) {
				str += list.get(i) + "->";
			}
			str = str + list.get(list.size() - 1);
			resultStr.add(str);
		}
		
		return resultStr;
	}
	
	public void paths (TreeNode root, List<List<Integer>> result , List<Integer> temp) {
		
		if (root.left == null && root.right == null) {
			result.add(new ArrayList<>(temp));
		}
		
		if (root.left != null) {
			temp.add(root.left.val);
			paths(root.left, result, temp);
			temp.remove(temp.size() - 1);
		}
		
		if (root.right != null) {
			temp.add(root.right.val);
			paths(root.right, result, temp);
			temp.remove(temp.size() - 1);
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
