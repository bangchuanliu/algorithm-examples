package leetcode.easy.stackqueue;

import common.Stack;

class MinStack {
	
	private Stack stack = new Stack();
	private Stack minStack = new Stack();
	int min = Integer.MAX_VALUE;
	
    public void push(int x) {
    	stack.push(x);
    	if(minStack.isEmpty()){
    		minStack.push(x);
    		min = x;
    	}else{
    		if(x <= min){
    			minStack.push(x);
    			min = x;
    		}
    	}
    }

    public void pop() {
    	if(stack.isEmpty() || minStack.isEmpty()){
    		return;
    	}
    	if(stack.top() == minStack.top()){
    		stack.pop();
    		minStack.pop();
    	}else{
    		stack.pop();
    	}
    }

    public int top() {
    	if(stack.isEmpty()){
    		return 0;
    	}
        return stack.top();
    }

    public int getMin() {
    	if(minStack.isEmpty()){
    		return 0;
    	}
        return minStack.top();
    }
    
    public static void main(String[] args){
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