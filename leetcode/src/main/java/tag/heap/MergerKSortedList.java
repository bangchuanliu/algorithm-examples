package tag.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import common.ListNode;

/**
 *Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 * 
 */
public class MergerKSortedList {

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		return mergeKLists(lists, 0, lists.length - 1);	
	}

	public ListNode mergeKLists(ListNode[] lists, int i, int j) {
		if (i >= j) {
			return lists[i];
		}
		int mid = (i+j) / 2;
		ListNode n1 = mergeKLists(lists, i, mid);
		ListNode n2 = mergeKLists(lists, mid+1, j);
		
		return merge(n1, n2);
	}


	public ListNode merge(ListNode n1, ListNode n2) {
		ListNode helper = new ListNode(0);
		ListNode p = helper;
		while (n1 != null && n2 != null) {
			if (n1.val < n2.val) {
				p.next = n1;
				n1 = n1.next;
			}else {
				p.next = n2;
				n2 = n2.next;
			}
			p = p.next;
		}
		if (n1 != null) {
			p.next = n1;
		}else {
			p.next = n2;
		}
		
		return helper.next;
	}
	
	/**
	 * heap
	 * 
	 */
	public ListNode mergeKLists2(List<ListNode> lists) {
		ListNode helperNode = new ListNode(0);
		if (lists == null || lists.size() == 0) {
			return null;
		}
		PriorityQueue<ListNode> q = new PriorityQueue<>((a, b) -> a.val - b.val);

		for (ListNode node : lists) {
			if (node != null) {
				q.add(node);
			}
		}
		ListNode p = helperNode;
		while (!q.isEmpty()) {
			ListNode temp = q.poll();
			p.next = temp;
			p = temp;
			if (temp.next != null) {
				q.add(temp.next);
			}
		}
		return helperNode.next;
	}

	public static void main(String[] args) {
		MergerKSortedList instance = new MergerKSortedList();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(5);
		ListNode n4 = new ListNode(1);
		ListNode n5 = new ListNode(3);
		ListNode n6 = new ListNode(4);
		ListNode n7 = new ListNode(2);
		ListNode n8 = new ListNode(6);
		n1.next = n2;
		n2.next = n3;
		n4.next = n5;
		n5.next = n6;
		n7.next = n8;
		ListNode[] lists = {n1, n4, n7};

		ListNode ret = instance.mergeKLists(lists);
		while (ret != null) {
			System.out.print(ret.val + " ");
			ret = ret.next;
		}
	}
}
