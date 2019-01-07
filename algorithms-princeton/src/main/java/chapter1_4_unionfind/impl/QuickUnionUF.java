package chapter1_4_unionfind.impl;

import chapter1_4_unionfind.UF;

public class QuickUnionUF implements UF {

    private int[] ids;
    private int count;

    public QuickUnionUF(int N) {
        ids = new int[N];
        count = N;
        for (int i = 0; i < N; i++) {
            ids[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int pr = find(ids[p]); 
        int qr = find(ids[q]);
        if (pr == qr) {
            return;
        }
        ids[p] = qr;
        count--;
    }

    @Override
    public int find(int p) {
        while (ids[p] != p) {
            p = ids[p];
        }
        return p;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return count;
    }
}
