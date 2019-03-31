package tag.hashtable;

import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node newHead = new Node(head.val);
        Node p = head.next;
        Node q = newHead;
        Map<Node, Node> map = new HashMap<>();
        map.put(head, newHead);

        while (p != null) {
            Node temp = new Node(p.val);
            map.put(p, temp);
            q.next = temp;
            q = temp;
            p = p.next;
        }

        p = head;

        while (p != null) {
            map.get(p).random = map.get(p.random);
            p = p.next;
        }

        return newHead;
    }


    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int val) {
            this.val =val;
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    ;
}
