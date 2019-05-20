package tag.stackqueue;

import java.util.Stack;

public class MaxStack {
    Stack<Integer> max;
    Stack<Integer> stack;

    /**
     * initialize your data structure here.
     */
    public MaxStack() {
        max = new Stack<>();
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        
        if (max.isEmpty() || max.peek() <= x) {
            max.push(x);                
        }
    }

    public int pop() {
        int top = stack.pop();
        
        if (top == max.peek()) {
            max.pop();    
        }
        return top;
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return max.peek();
    }

    public int popMax() {
        int peek = max.pop();

        Stack<Integer> buffer = new Stack<>();
        while (!stack.isEmpty() && stack.peek() != peek) {
            buffer.push(pop());
        }

        stack.pop();
        while (!buffer.isEmpty()) {
            push(buffer.pop());
        }

        return peek;
    }
    
    public static void main(String[] args) {
        MaxStack maxStack = new MaxStack();
        maxStack.push(5);
        maxStack.push(1);
        maxStack.push(-5);
        maxStack.popMax();
        maxStack.popMax();
        maxStack.top();
    }
}
