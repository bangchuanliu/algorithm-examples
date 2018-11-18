package chapter3_2_BST;

import chapter3_1_SymbolTable.ST;

public class BST implements ST {
    private Node root;

    @Override
    public Integer get(int key) {
        return get(root, key);
    }

    private Integer get(Node node, int key) {
        if (node == null) {
            return null;
        }

        if (key < node.key) {
            return get(node.left, key);
        } else if (key > node.key) {
            return get(node.right, key);
        } else {
            return node.value;
        }
    }

    @Override
    public void put(int key, int value) {
        put(root, key, value);
    }

    public Node put(Node node, int key, int value) {
        if (node == null) {
            return new Node(key, value, 1);
        }
        if (key < node.key) {
            node.left = put(node.left, key, value);
        } else if (key > node.key) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
            node.N = size(node.left) + size(node.right) + 1;
        }
        return node;
    }

    public Integer select(int k) {
        
    }
    
    public Integer rank(int k){
        
    }
    
    
    
    public Integer floor(int key) {
        Node node = floor(root, key);
        if (node == null) {
            return null;
        }
        return node.key;
    }

    private Node floor(Node node, int key) {
        if (node == null) {
            return null;
        }

        if (node.key == key) {
            return node;
        }

        if (key < node.key) {
            return floor(node.left, key);
        }

        Node t = floor(node.right, key);
        if (t != null) {
            return t;
        } else {
            return node;
        }
    }


    public Integer min() {
        return min(root);
    }

    private Integer min(Node node) {
        if (node.left == null) {
            return node.key;
        }
        return min(node.left);
    }


    @Override
    public boolean contains(int key) {
        return false;
    }

    @Override
    public Integer delete(int key) {
        return null;
    }

    @Override
    public int size() {
        return size(root);
    }

    private Integer size(Node node) {
        if (node == null) {
            return null;
        }
        return node.N;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    class Node {
        private int key;
        private int value;
        private Node left;
        private Node right;
        private int N;

        Node(int key, int value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }
}
