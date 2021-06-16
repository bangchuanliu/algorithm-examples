package tag.stackqueue;

import java.util.Stack;


class MinStack {
    
    private Stack<int[]> s = new Stack<>();

    public void push(int x) {
        if (s.isEmpty()) {
            s.push(new int[] {x, x,});
        }
        
        if (x < s.peek()[1]) {
            s.push(new int[] {x, x});
        } else {
            s.push(new int[] {x, s.peek()[1]});
        }
    }

    public void pop() {
        if (!s.isEmpty()) {
            s.pop();
        }
    }

    public int top() {
        return s.isEmpty() ? 0 : s.peek()[0];
    }

    public int getMin() {
        return s.isEmpty() ? 0 : s.peek()[1];
    }

    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(512);
        s.push(-1024);
        s.push(-1024);
        s.push(512);
        s.pop();
        s.getMin();
        s.pop();
        s.getMin();
        s.pop();
        s.getMin();
    }
}