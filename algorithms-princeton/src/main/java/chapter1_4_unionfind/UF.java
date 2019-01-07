package chapter1_4_unionfind;

public interface UF {
    public void union(int p, int q);
    
    public int find(int p);
    
    public boolean connected(int p, int q);
    
    public int count();
}
