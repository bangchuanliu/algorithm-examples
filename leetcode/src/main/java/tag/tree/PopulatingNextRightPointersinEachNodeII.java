package tag.tree;

import java.util.LinkedList;

public class PopulatingNextRightPointersinEachNodeII {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node pre = null;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (pre != null) {
                    pre.next = node;
                }
                pre = node;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args){
        PopulatingNextRightPointersinEachNodeII instance = new PopulatingNextRightPointersinEachNodeII();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        n1.right = n3;
        n1.left= n2;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        n4.left = n7;
        n6.right = n8;
        Node root = instance.connect(n1);
        System.out.println(root);
    }

   static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
