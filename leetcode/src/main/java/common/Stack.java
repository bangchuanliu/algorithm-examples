package common;

public class Stack {
	ListNode top = null;

	public void push(int x) {
		ListNode node = new ListNode(x);
		node.next = null;
		if (top == null) {
			top = node;
		} else {
			top.next = node;
		}
	}

	public void pop() {
		if (top != null) {
			top = top.next;
		}
	}

	public int top() {
		if (top != null) {
			return top.val;
		} else {
			return 0;
		}
	}

	public boolean isEmpty() {
		return top == null;
	}

	public int size() {
		int size = 0;
		if (!isEmpty()) {
			while (top != null) {
				top = top.next;
				size++;
			}
		}
		return size;
	}
}
