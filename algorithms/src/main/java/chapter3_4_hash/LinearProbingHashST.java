package chapter3_4_hash;

public class LinearProbingHashST {
    private int N;
    private int M = 16;
    private Integer[] keys;
    private Integer[] vals;
    
    public LinearProbingHashST() {
        keys = new Integer[M];
        vals = new Integer[M];
    }

    public Integer get(int key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }
    
    private void resize(int M) {
        
    }

    public void put(int key, int val) {
        if (N >= M / 2) {
            resize(2 * M);
        }
        int i = hash(key);
        for (; keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }
    
    private int hash(Integer key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }
}
