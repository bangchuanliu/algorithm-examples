package tag.stackqueue;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class MaxStackII {


    TreeMap<Integer, List<Node>> map = new TreeMap<>();
    DLL dll;

    /** initialize your data structure here. */
    public MaxStackII() {
        dll = new DLL();
    }

    public void push(int x) {
        Node node = dll.add(x);
        if (!map.containsKey(x)) {
            map.put(x, new LinkedList<>());
        }
        map.get(x).add(node);

    }

    public int pop() {
        if (map.size() == 0) {
            return -1;
        }
        int val = dll.remove(dll.tail.pre);
        List<Node> list = map.get(val);
        list.remove(list.size() - 1);
        if (list.isEmpty()) {
            map.remove(val);
        }
        return val;
    }

    public int top() {
        return dll.tail.pre.val;
    }

    public int peekMax() {
        return map.lastKey();
    }

    public int popMax() {
        int val = map.lastKey();
        List<Node> list = map.get(val);
        Node node = list.remove(list.size() - 1);
        if (list.isEmpty()) {
            map.remove(val);
        }
        dll.remove(node);
        return val;
    }

}

class DLL {
    Node tail;
    Node head;

    DLL() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.pre = head;
    }

    public Node add(int x) {
        Node node = new Node(x);
        tail.pre.next = node;
        node.pre = tail.pre;
        node.next = tail;
        tail.pre = node;

        return node;
    }

    public int remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;

        return node.val;
    }
}


class Node {
    int val;
    Node pre;
    Node next;

    Node(int val) {
        this.val = val;
    }
}