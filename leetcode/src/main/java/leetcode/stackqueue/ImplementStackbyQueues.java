package leetcode.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackbyQueues {

	private Queue<Integer> q1 = new LinkedList<>();
	private Queue<Integer> q2 = new LinkedList<>();

	// Push element x onto stack.
	public void push(int x) {
		q1.offer(x);
	}

	// Removes the element on top of the stack.
	public void pop() {
		if (!q1.isEmpty()) {
			int size = q1.size();
			for (int i = 0; i < size - 1; i++) {
				q2.offer(q1.poll());
			}
			q1.poll();
		}
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
	}

	// Get the top element.
	public int top() {
		if (!q1.isEmpty()) {
			int size = q1.size();
			for (int i = 0; i < size - 1; i++) {
				q2.offer(q1.poll());
			}
			int top = q1.poll();
			q2.offer(top);
			Queue<Integer> temp = q1;
			q1 = q2;
			q2 = temp;
			return top;
		} else {
			return 0; // or throw exception
		}
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return q1.isEmpty() && q2.isEmpty();
	}
}
