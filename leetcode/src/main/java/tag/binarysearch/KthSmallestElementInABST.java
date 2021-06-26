package tag.binarysearch;

import java.util.LinkedList;


class TreeNode {
	public int val;
	public int leftCount;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
		left = null;
		right = null;
	}
}

public class KthSmallestElementInABST {

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

	public int k2(TreeNode root, int k) {
		if(k == root.leftCount + 1) {
			return root.val;
		}else if(k < root.leftCount + 1) {
			return k2(root.left, k);
		} else {
			return k2(root.right, k - root.leftCount -1);
		}
	}

	public int addCount(TreeNode root) {
		if(root == null) {
			return 0;
		}

		int left = addCount(root.left);
		int right = addCount(root.right);

		root.leftCount = left;
		return left + right + 1;
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
        KthSmallestElementInABST instance = new KthSmallestElementInABST();
        Integer[] nums = {3,1,4,null,2};
//        TreeNode node = TreeNodeUtil.creatTree(nums);
//        System.out.println(instance.kthSmallest3(node,1));
	} 
}


