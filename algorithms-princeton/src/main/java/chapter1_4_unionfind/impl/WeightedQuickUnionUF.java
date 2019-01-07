package chapter1_4_unionfind.impl;

import chapter1_4_unionfind.UF;

public class WeightedQuickUnionUF implements UF {
    private int[] ids;
    private int count;
    private int[] size;

    public WeightedQuickUnionUF(int N) {
        ids = new int[N];
        size = new int[N];
        count = N;
        for (int i = 0; i < N; i++) {
            ids[i] = i;
        }
        for (int i = 0; i < N; i++) {
            size[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) {
            return;
        }

        if (size[i] < size[j]) {
            ids[i] = j;
            size[j] += size[i];
        } else {
            ids[j] = i;
            size[i] += size[j];
        }
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
