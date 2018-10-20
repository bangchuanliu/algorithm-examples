package leetcode.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import common.ListNode;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * @author BangChuan Liu
 * @date 2015
 * @Contact liubangchuan1100@gmail.com
 */
public class MergerKSortedList {
	public ListNode mergeKLists(List<ListNode> lists) {
		ListNode helperNode = new ListNode(0);
		if (lists == null || lists.size() == 0) {
			return null;
		}
		PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		});

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
		ListNode n1 = null;
		ListNode n2 = new ListNode(1);

		List<ListNode> lists = new ArrayList<>();
		lists.add(n1);
		lists.add(n2);

		ListNode[] lists2 = { n1, n2 };

		System.out.println(instance.mergeKLists(lists).val);
	}
}
