package leetcode.easy.dp;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;
/**
 * 
 * @author bliu13 Jan 5, 2016
 */
public class UniqueBinarySearchTreesII {

	public List<TreeNode> generateTrees(int n) {

		return constructTree(1, n);
	}

	public List<TreeNode> constructTree(int start, int end) {
		
		List<TreeNode> result = new ArrayList<>();
		
		if (start > end) {
			result.add(null);
			return result;
		}
		
		for (int i = start; i <= end; i++) {
			List<TreeNode> lefts = constructTree(start, i - 1);
			List<TreeNode> rights = constructTree(i+1, end);
			
			for (TreeNode left : lefts) {
				for (TreeNode right : rights) {
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					result.add(root);
				}
			}
		}
		
		return result;
	}
	
	public static void  main(String[] args) {
		UniqueBinarySearchTreesII instance = new UniqueBinarySearchTreesII();
		
		List<TreeNode> nodes1 = instance.generateTrees(1);
		List<TreeNode> nodes2 = instance.generateTrees(2);
		List<TreeNode> nodes3 = instance.generateTrees(3);
		List<TreeNode> nodes4 = instance.generateTrees(4);
		
		System.out.println(nodes1.size());
	}
}
