package greedy_dp.assignment2;

public class WeightedQuickUnionPathCompression {
    private int[] id;
    private int count;
    private int[] size;

    public WeightedQuickUnionPathCompression(int vertices) {
        count = vertices;
        id = new int[vertices + 1];
        for (int i = 1; i < id.length; i++) {
            id[i] = i;
        }
        size = new int[vertices + 1];
        for (int i = 1; i < id.length; i++) {
            size[i] = 1;
        }
    }

    public int find(int p) {
        int root = p;
        while (root != id[root]) {
            root = id[root];
        }
        while (id[p] != root) {
            int newP = id[p];
            id[p] = root;
            p = newP;
        }
        return root;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pr = find(p);
        int qr = find(q);
        
        if (pr != qr) {
            if (size[pr] <= size[qr]) {
                id[pr] = qr;
                size[qr] += size[pr];
            } else {
                id[qr] = pr;
                size[pr] += size[qr];
            }
        }
        count--;
    }

    public int[] getId() {
        return id;
    }

    public int getCount() {
        return count;
    }

    public int getSize(int p) {
        return size[p];
    }
}
