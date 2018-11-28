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
        return null;
    }

    public Integer rank(int k) {
        return null;
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
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }


    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    private Node delete(Node node, int key) {
        if (node == null) {
            return null;
        }
        if (key < node.key) {
            node.left = delete(node.left, key);
        } else if (key > node.key) {
            node.right = delete(node.right, key);
        } else {
            if (node.right == null) {
                return node.left;
            }
            if (node.left == null) {
                return node.right;
            }
            Node t = node;
            node = min(t.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }


    private Integer select(Node x, int k) {
        if (x == null) {
            return null;
        }
        if (k < size(x)) {
            return select(x.left, k);
        } else if (k > size(x)) {
            return select(x.right, k - size(x) - 1);
        } else {
            return x.key;
        }
    }

    private Integer rank(int key, Node x) {
        if (x == null) {
            return 0;
        }
        if (key < x.key) {
            return rank(key, x.left);
        } else if (key > x.key) {
            return 1 + size(x.left) + rank(key, x.right);
        } else {
            return size(x.left);
        }
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
