package chapter3_1_SymbolTable;

public class SequentialListSearch implements ST {
    private Node first;
    private int size = 0;

    @Override
    public Integer get(int key) {
        for (Node node = first; node != null; node = node.next) {
            if (node.key == key) {
                return node.value;
            }
        }
        return null;
    }

    @Override
    public void put(int key, int value) {
        for (Node node = first; node != null; node = node.next) {
            if (node.key == key) {
                node.value = value;
                return;
            }
        }
        Node node = new Node(key, value);
        node.next = first;
        first = node;
    }

    @Override
    public boolean contains(int key) {
        for (Node node = first; node != null; node = node.next) {
            if (node.key == key) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer delete(int key) {
        return 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    class Node {
        private int key;
        private int value;
        private Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
