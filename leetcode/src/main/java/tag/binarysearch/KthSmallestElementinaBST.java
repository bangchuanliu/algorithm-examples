package tag.binarysearch;

import java.util.LinkedList;

import common.TreeNode;
import common.TreeNodeUtil;

public class KthSmallestElementinaBST {

	/**
	 * in order traversal iterative
	 *
	 * @param root
	 * @param k
     * @return
     */
	public int kthSmallest(TreeNode root, int k) {
		if (root == null || k < 0) {
			return 0;
		}

		LinkedList<TreeNode> stack = new LinkedList<>();
		TreeNode p = root;
		int count = 0;

		while (!stack.isEmpty() || p != null) {
			if (p != null) {
				stack.push(p);
				p = p.left;
			} else {
				TreeNode node = stack.pop();
				count++;
				if (count == k) {
					return node.val;
				}
				p = node.right;
			}
		}

		return 0;
	}

	/**
	 * follow up, if the data structure of node can be changed
	 * @param root
	 * @param k
     * @return
     */
	public int kthSmallest2(TreeNode root, int k) {
		if (root == null || k < 0) {
			return 0;
		}

		int numOfNodesInLeft = getNumberOfNodes(root.left);

		if (k == numOfNodesInLeft + 1) {
			return root.val;
		} else if (k < numOfNodesInLeft + 1) {
			return kthSmallest2 (root.left, k);
		} else {
			return kthSmallest2 (root.right, k - numOfNodesInLeft - 1);
		}
	}

	public int getNumberOfNodes(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return getNumberOfNodes(node.left) + getNumberOfNodes(node.right) + 1;
	}

	/**
	 * in order traversal recursive
	 *
	 * @param root
	 * @param k
     * @return
     */
	public int kthSmallest3(TreeNode root, int k) {
		if (root == null || k < 0) {
			return 0;
		}

		helper(root, k);

		return result;
	}

	private int count;
	private int result;

	public void helper(TreeNode root, int k) {
		if (root == null) {
			return;
		}
        if (count < k) {
            helper(root.left, k);
            count++;
            if (count == k) {
                result = root.val;
                return;
            }
            helper(root.right, k);    
        }
	}
	
	public static void main(String[] args) {
        KthSmallestElementinaBST instance = new KthSmallestElementinaBST();
        Integer[] nums = {3,1,4,null,2};
        TreeNode node = TreeNodeUtil.creatTree(nums);
        System.out.println(instance.kthSmallest3(node,1));
	} 
}
