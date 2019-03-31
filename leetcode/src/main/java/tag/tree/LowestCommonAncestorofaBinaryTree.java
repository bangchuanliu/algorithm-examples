package tag.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import common.TreeNode;

public class LowestCommonAncestorofaBinaryTree {

	/**
	 * Recursive
	 * 
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if (left != null && right != null) {
			return root;
		}

		return left == null ? right : left;
	}

	/**
	 * post order traversal
	 * 
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
	    if (root == null) {
	        return null;
        }
	    
		Stack<TreeNode> stack = new Stack<>();
		Map<TreeNode, TreeNode> parent = new HashMap<>();
		
		stack.push(root);
		parent.put(root, null);
		
		while (!stack.isEmpty() && !parent.containsKey(p) || !parent.containsKey(q)) {
		    TreeNode node = stack.pop();
		    
		    if (node.left != null) {
		        stack.push(node.left);
		        parent.put(node.left, node);
            }
            
            if (node.right != null) {
                stack.push(node.right);
                parent.put(node.right, node);
            }
        }
		
        Set<TreeNode> set = new HashSet<>();
		while (p != null) {
		    set.add(p);
		    p = parent.get(p);
        }
        
        while (!set.contains(q)) {
            q = parent.get(q);
        }
        
        return q;
	}
}
