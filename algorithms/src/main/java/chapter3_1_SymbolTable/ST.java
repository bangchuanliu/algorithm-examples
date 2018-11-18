package chapter3_1_SymbolTable;

public interface ST {

    public Integer get(int key);

    public void put(int key, int value);

    public boolean contains(int key);

    public Integer delete(int key);

    public int size();

    public boolean isEmpty();
    
}
