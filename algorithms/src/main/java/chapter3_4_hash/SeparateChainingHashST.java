package chapter3_4_hash;

import chapter3_1_SymbolTable.SequentialListSearch;

public class SeparateChainingHashST {
    private int N;
    private int M;
    private SequentialListSearch[] st;
    
    public SeparateChainingHashST() {
        this(997);
    }
    
    public SeparateChainingHashST(int M) {
        this.M = M;
        st = new SequentialListSearch[M];
        for (int i = 0; i < st.length; i++) {
            st[i] = new SequentialListSearch();
        }
    }
    
    private int hash(Integer key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }
    
    public int get(int key) {
        return st[hash(key)].get(key);
    }
    
    public void put(int key, int val) {
        st[hash(key)].put(key, val);
    }
    
}
