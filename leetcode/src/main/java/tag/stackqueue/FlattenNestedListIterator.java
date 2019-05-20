package tag.stackqueue;

import common.NestedInteger;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class FlattenNestedListIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack = new Stack<>();

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return stack.pop().getInteger();    
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            List<NestedInteger> nest = stack.pop().getList();
            for (int i = nest.size() - 1; i >= 0; i--) {
                stack.push(nest.get(i));
            }
        }
        return !stack.isEmpty();
    }
}
