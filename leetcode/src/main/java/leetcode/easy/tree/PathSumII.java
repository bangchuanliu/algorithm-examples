package leetcode.easy.tree;


import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

public class PathSumII {
	
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	
    	List<List<Integer>> result = new ArrayList<>();
    	
    	if (root == null) {
    		return result;
    	}
    	
    	List<Integer> temp = new ArrayList<>();
    	temp.add(root.val);
    	
    	pathSum(result, root, sum - root.val, temp);
    	
    	return result;
    }
    
    public void pathSum(List<List<Integer>> result, TreeNode node, int sum, List<Integer> temp) {
    	
    	if (node.left == null && node.right == null && sum == 0) {
    		result.add(new ArrayList<>(temp));
    	}
    	
    	if (node.left != null) {
    		temp.add(node.left.val);
    		pathSum(result, node.left, sum - node.left.val, temp);
    		temp.remove(temp.size() - 1);
    	}
    	
    	if (node.right != null) {
    		temp.add(node.right.val);
    		pathSum(result, node.right, sum - node.right.val, temp);
    		temp.remove(temp.size() - 1);
    	}
    }
}
