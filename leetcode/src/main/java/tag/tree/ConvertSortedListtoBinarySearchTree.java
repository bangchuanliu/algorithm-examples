package tag.tree;

import common.ListNode;
import common.TreeNode;


/**
 * 
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * @author admin
 *
 */
public class ConvertSortedListtoBinarySearchTree {
	
	static ListNode p;
	
	public TreeNode sortedListToBST(ListNode head) {
		if(head == null){
			return null;
		}
		p = head;
		return sortedListToBST(0, length(p)-1);
	}
	
	public TreeNode sortedListToBST(int start, int end) {
		if(start > end){
			return null;
		}
		int mid = (start + end)/2;
		TreeNode left = sortedListToBST(start, mid - 1);
		TreeNode root = new TreeNode(p.val);
		p = p.next;
		TreeNode right = sortedListToBST(mid+1, end);
		root.left = left;
		root.right = right;
		return root;
	}
	
	public int length(ListNode head){
		int len = 0;
		ListNode p = head;
		while(p != null){
			len++;
			p = p.next;
		}
		return len;
	}
	
	public static void main(String[] args) {
		ConvertSortedListtoBinarySearchTree instance = new ConvertSortedListtoBinarySearchTree();
		ListNode n1 = new ListNode(1);
		ListNode p = n1;
		for (int i = 2; i <= 20; i++) {
			ListNode node = new ListNode(i);
			p.next  = node;
			p = node;
		}
		
		TreeNode node = instance.sortedListToBST(n1);
		System.out.println(node.val);
	}
}
