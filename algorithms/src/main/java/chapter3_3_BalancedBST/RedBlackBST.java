package chapter3_3_BalancedBST;

public class RedBlackBST {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;
    
    public void put(int key, int val) {
        root = put(root, key, val);
        root.color = BLACK;
    }
    
    private Node put(Node h, int key, int val) {
        if (h == null) {
            return new Node(key, val, 1, RED);
        }
        if (key < h.key) {
            h.left = put(h.left, key, val);
        } else if (key > h.key) {
            h.right = put(h.right, key, val);
        }else {
            h.value =val;
        }
        
        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColor(h);
        }
        h.N = size(h.right) + size(h.left) + 1;
        return h;
    }
    
    
    
    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }
    
    public Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    public void flipColor(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }
    
    public Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }
    
    
    public int size(Node x) {
        if (x == null) {
            return 0;
        }
        return size(x.left) + size(x.right) + 1;
    }
    
    
    private class Node {
        int key;
        int value;
        Node left, right;
        int N;
        boolean color;
        
        Node (int key, int val, int N, boolean color) {
            this.key = key;
            this.value = val;
            this.N = N;
            this.color = color;
        }
    }
}
