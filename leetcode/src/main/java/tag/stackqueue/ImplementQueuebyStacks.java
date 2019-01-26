package tag.stackqueue;

import java.util.LinkedList;

/**
 * Implement the following operations of a queue using stacks.
 * 
 * push(x) -- Push element x to the back of queue. pop() -- Removes the element
 * from in front of queue. peek() -- Get the front element. empty() -- Return
 * whether the queue is empty. Notes: You must use only standard operations of a
 * stack -- which means only push to top, peek/pop from top, size, and is empty
 * operations are valid. Depending on your language, stack may not be supported
 * natively. You may simulate a stack by using a list or deque (double-ended
 * queue), as long as you use only standard operations of a stack. You may
 * assume that all operations are valid (for example, no pop or peek operations
 * will be called on an empty queue).
 * 
 * @author bliu13 Jan 12, 2016
 */
public class ImplementQueuebyStacks {
	private LinkedList<Integer> s1 = new LinkedList<>();
	private LinkedList<Integer> s2 = new LinkedList<>();

	// Push element x to the back of queue.
	public void push(int x) {
		s1.push(x);
	}

	// Removes the element from in front of queue.
	public void pop() {
		while (!s1.isEmpty()) {
			s2.push(s1.pop());
		}

		s2.pop();

		while (!s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}

	// Get the front element.
	public int peek() {
		while (!s1.isEmpty()) {
			s2.push(s1.pop());
		}

		int ret = s2.peek();

		while (!s2.isEmpty()) {
			s1.push(s2.pop());
		}

		return ret;
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return s1.isEmpty();
	}
}
