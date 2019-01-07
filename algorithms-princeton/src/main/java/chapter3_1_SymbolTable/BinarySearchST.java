package chapter3_1_SymbolTable;

public class BinarySearchST implements ST {
    private int[] keys;
    private int[] values;
    private int size;

    @Override
    public Integer get(int key) {
        int i = rank(key);
        if (i < size && keys[i] == key) {
            return values[i];
        }
        return null;
    }

    @Override
    public void put(int key, int value) {
        int i = rank(key);
        if (i < size && keys[i] == key) {
            values[i] = value;
        } else {
            for (int j = size; j > i; j--) {
                keys[j] = keys[j-1];
                values[j] = values[j-1];
            }
            keys[i] = key;
            values[i] = value;
            size++;
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
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public int rank(int k) {
        int low = 0;
        int high = size - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (keys[mid] < k) {
                high = mid - 1;
            } else if (keys[mid] > k) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }
}
